package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    @Autowired
    SlotService service = new SlotService();

    @RequestMapping("/parkingInfo")
    @ResponseBody
    public String parkingInfo (){
        return String.format(service.writeParkingInfo());
    }
}