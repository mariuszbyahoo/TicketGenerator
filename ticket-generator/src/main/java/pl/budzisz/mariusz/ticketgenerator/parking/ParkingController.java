package pl.budzisz.mariusz.ticketgenerator.parking;

import java.io.File;
import java.io.IOException;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.budzisz.mariusz.ticketgenerator.ticket.Ticket;

/**
 * RestController class, which has an autowired Ticket and SlotService, two counters for a PDF files and their destinations as a String values.
 * @author mariu
 *
 */
@RestController
public class ParkingController {
	
	private static int i = 1;
	private static int j = 1;
	public static String DEST;
	public static String DEST2;

    @Autowired
    SlotService service;
    
	@Autowired
    Ticket ticket;
	
	public Ticket getTicket() {
			return ticket;
	}

	 public void setTicket(Ticket ticket) {
			this.ticket = ticket;
	}

	 /**
	  * This method simply uses the SlotService's "writeParkingInfo" method and attaches its invocation into an "/parkingInfo" URL.
	  * @return
	  */
    @RequestMapping("/parkingInfo")
    @ResponseBody
    public JsonArray parkingInfo (){
        return service.writeParkingInfo();
    }
    
    /**
     * This method will create a new File in the "/docs/" folder of the project's main folder and will invoke the SlotService's "parkingInfoAsPdf()" method.
     * @return
     * @throws IOException
     */
    @RequestMapping(path = "/parkingPdf", method = RequestMethod.GET)
    public String writeFile() throws IOException{
    	DEST = "docs/parkingFile" + i +".pdf";
    	File file = new File(DEST);
    	file.getParentFile().mkdirs();
    	service.parkingInfoAsPdf(DEST);
    	i++;
    	return "Check the docs folder";
    }

    /**
     * This PUT method need to get a two parameters, in order to choose a specific Parking Lot and first of all, generate a new file
     * in the "/docs/" folder named "parkingTicketX.pdf" (where an X is a controller's counter), second of all, use the SlotSevice's method "occupySlot()"
     * in order to change the slot's occupation status into "OCCUPIED". Still needs to get an Exception feature, which will inform the user, what the chosen slot
     * is currently occupied, and will ask about the another slot's coordinates. Or, to automate the whole parking lot's choice process.
     * @param columnNumber
     * @param slotNumber
     * @return
     */
    @PutMapping("/getTicket")
    @ResponseBody
    public String ticketInfo (@RequestParam int columnNumber, int slotNumber) {
    	try {
    		DEST2 = "docs/parkingTicket" + j +".pdf";
    		File file = new File(DEST2);
        	file.getParentFile().mkdirs();
    		service.occupySlot(columnNumber, slotNumber);
    		service.ticketAsPdf(DEST2, service.parking.row.get(columnNumber).getSlotList().get(slotNumber));
    		j ++;
    		return "Take a ticket (check the docs folder)";
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    		return "Error occured";
    	}
    }
    
    /**
     * This method uses the columnNumber and slotNumber parameters to choose a specific parking slot and to make it FREE again. 
     * Still needs to get an Exception feature, which will inform the user, what the chosen slot
     * is currently free, and will ask about the another slot's coordinates. Or, to automate the whole parking lot's choice process.
     * @param columnNumber
     * @param slotNumber
     * @return
     */
    @PutMapping("/exit")
    @ResponseBody
    public String exit (@RequestParam int columnNumber, int slotNumber) {
    	service.exitSlot(columnNumber, slotNumber);
    	return "Slot nr. " + columnNumber + "/" + slotNumber + " has been exited.\n Have a nice day! :)";
    }
	 
}