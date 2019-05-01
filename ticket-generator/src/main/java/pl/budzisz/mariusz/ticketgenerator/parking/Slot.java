package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Slot {
     int num = 0;
     String number = "NO." + num;
     boolean isOccupied;

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }
    
    public void setNum(int num) {
    	this.num = num;
    	number = "NO." + num;
    }
    /**
     * @return the isOccupied
     */
    public boolean getIsOccupied() {
        return isOccupied;
    }

    /**
     * @param isOccupied the isOccupied to set
     */
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Slot() {
    }

    @Override
    public String toString() {
        return "\n{" +
            " slot " + number + " " +
            ", isOccupied= '" + getIsOccupied() + "' " +
            "}\n";
    }
    
}