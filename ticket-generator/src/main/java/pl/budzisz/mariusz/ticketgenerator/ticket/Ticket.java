package pl.budzisz.mariusz.ticketgenerator.ticket;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import pl.budzisz.mariusz.ticketgenerator.parking.Slot;
import pl.budzisz.mariusz.ticketgenerator.parking.SlotStatus;

/**
 * Class representing an every ticket generated by the program.
 * @author mariu
 *
 */
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "request")
@Component
public class Ticket {
	
	/**
	 * Ticket's class counter, helps to differ one PDF - ticket from another.
	 */
	public static int number = 0;
	
	@Autowired
	Slot slot;
	
	/**
	 * Method which makes a specific slot occupied.
	 * @param slot
	 */
	public void occupySlot(Slot slot) {
		this.slot = slot;
		slot.setOccupied(SlotStatus.OCCUPIED);
	}
	
	/**
	 * public constructor which increments the counter
	 */
	public Ticket() {
		number ++;
	}
	
	public Slot getSlot() {
		return this.slot;
	}

	@Override
	public String toString() {
		return "Ticket [NO. " + Ticket.number + ", Parking Lot =" + slot + "]";
	}
	
}
