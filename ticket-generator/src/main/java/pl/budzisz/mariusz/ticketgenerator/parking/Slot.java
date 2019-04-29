package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
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
        num++;
    }

    @Override
    public String toString() {
        return "\n{" +
            " slot " + number + " " +
            ", isOccupied= '" + getIsOccupied() + "' " +
            "}\n";
    }
    
}