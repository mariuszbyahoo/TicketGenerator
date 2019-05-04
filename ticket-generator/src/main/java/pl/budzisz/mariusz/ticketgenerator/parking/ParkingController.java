package pl.budzisz.mariusz.ticketgenerator.parking;

import java.io.File;
import java.io.IOException;
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
	
	public static final String DEST = "docs/parkingFile.pdf"; 

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
    public String parkingInfo (){
        return String.format(service.writeParkingInfo());
    }
    
    @RequestMapping(path = "/parkingPdf", method = RequestMethod.GET)
    public void writeFile() throws IOException{
    	File file = new File(DEST);
    	file.getParentFile().mkdirs();
    	service.createPdf(DEST);
    }
    
    @PutMapping("/getTicket")
    @ResponseBody
    public String ticketInfo (@RequestParam int columnNumber, int slotNumber) {
    	service.occupySlot(columnNumber, slotNumber);
    	return String.format(ticket.toString());
    }
    
}