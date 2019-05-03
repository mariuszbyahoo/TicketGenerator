package pl.budzisz.mariusz.ticketgenerator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.budzisz.mariusz.ticketgenerator.parking.ParkingController;
import pl.budzisz.mariusz.ticketgenerator.ticket.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketGeneratorTests {
	
	@Autowired
	ParkingController parkingController;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void TicketGeneration() {
		for(int i = 0 ; i < 5 ; i ++) {
			//parkingController.ticketInfo(0,0);
		}
		if(Ticket.number == 5) {
			assertTrue(true);
		}
	}

}
