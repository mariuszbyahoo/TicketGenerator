package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotService{

@Autowired
Parking parking;

    public String writeParkingInfo(){
        return parking.toString();
    }
    
    public void occupySlot() {
    	Slot slot = (Slot) parking.getRows().get(0).get(0);
    	System.out.println(slot.toString());
    }

}