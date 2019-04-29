package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Slot {
     String number;
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

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public Slot() {
    }

    @Override
    public String toString() {
        return "\n{" +
            " number= '" + getNumber() + "' " +
            ", isOccupied= '" + getIsOccupied() + "' " +
            "}\n";
    }
    
}