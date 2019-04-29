package pl.budzisz.mariusz.ticketgenerator;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Slot {
    private int number;
    private boolean isOccupied;

    /**
     * @return the number
     */
    public int getNumber() {
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
    public void setNumber(int number) {
        this.number = number;
    }
    

    @Override
    public String toString() {
        return "{" +
            " number= '" + getNumber() + "' " +
            ", isOccupied= '" + getIsOccupied() + "' " +
            "}";
    }
    
}