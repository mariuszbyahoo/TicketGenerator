package pl.budzisz.mariusz.ticketgenerator.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pl.budzisz.mariusz.ticketgenerator.parking.Parking;
import pl.budzisz.mariusz.ticketgenerator.parking.Slot;

@Scope("prototype")
@Component
public class Ticket {
	
	int number = 0;
	
	@Autowired
	Slot slot;
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void occupySlot(Slot slot) {
		this.slot = slot;
		slot.setOccupied(true);
	}
	
	public Ticket() {
		this.number ++;
	}

	@Override
	public String toString() {
		return "Ticket [NO. " + number + ", Parking Lot =" + slot + "]";
	}
	
}
