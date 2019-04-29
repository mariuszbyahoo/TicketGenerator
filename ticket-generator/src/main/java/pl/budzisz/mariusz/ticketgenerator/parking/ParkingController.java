package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    Parking parking;

    @RequestMapping("/parkingInfo")
    @ResponseBody
    public String parkingInfo (ApplicationContext ctx){
        parking = ctx.getBean(parking.getClass());
        return String.format(parking.toString());
    }
}