package pl.budzisz.mariusz.ticketgenerator.ticket;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import pl.budzisz.mariusz.ticketgenerator.parking.Slot;
import pl.budzisz.mariusz.ticketgenerator.parking.SlotStatus;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
@Component
public class Ticket {
	
	public static int number = 0;
	
	@Autowired
	Slot slot;
	
	public void occupySlot(Slot slot) {
		this.slot = slot;
		slot.setOccupied(SlotStatus.OCCUPIED);
	}
	
	public Ticket() {
		number ++;
	}
	
	@PostConstruct
    public void init() {
         System.out.println("start request");
         System.out.println(Ticket.number);
    }

    @PreDestroy
    public void onDestroy() {
         System.out.println("ends request");
         System.out.println(Ticket.number);
    }

	@Override
	public String toString() {
		return "Ticket [NO. " + Ticket.number + ", Parking Lot =" + slot + "]";
	}
	
}
