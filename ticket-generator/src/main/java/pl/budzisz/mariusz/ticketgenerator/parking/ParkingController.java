package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.budzisz.mariusz.ticketgenerator.ticket.Ticket;

@RestController
public class ParkingController {

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
    
    @PutMapping("/getTicket")
    @ResponseBody
    public String ticketInfo () {
    	return String.format(ticket.toString());
    }
    
}