package pl.budzisz.mariusz.ticketgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketGenerator {
	public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TicketGenerator.class, args);    
	}
}
