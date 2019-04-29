package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SlotService{

Parking parking = new Parking();

    public String writeParkingInfo(){
        return parking.toString();
    }

}