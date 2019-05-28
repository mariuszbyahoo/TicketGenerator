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

    @RequestMapping("/parkingInfo")
    @ResponseBody
    public JsonArray parkingInfo (){
        return service.writeParkingInfo();
        		//String.format(service.writeParkingInfo());
    }
    
    @RequestMapping(path = "/parkingPdf", method = RequestMethod.GET)
    public String writeFile() throws IOException{
    	DEST = "docs/parkingFile" + i +".pdf";
    	File file = new File(DEST);
    	file.getParentFile().mkdirs();
    	service.parkingInfoAsPdf(DEST);
    	i++;
    	return "Sprawdz folder docs";
    }

    
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
    		return "Pobierz bilet z folderu docs";
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    		return "Error occured";
    	}
    }
    
    @PutMapping("/exit")
    @ResponseBody
    public String exit (@RequestParam int columnNumber, int slotNumber) {
    	service.exitSlot(columnNumber, slotNumber);
    	return "Slot nr. " + columnNumber + "/" + slotNumber + " has been exited.\n Have a nice day! :)";
    }
	 
}