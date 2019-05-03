package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Slot {
     int num = 0;
     int columnNum = 0;
     String numName = "NO." + num;
     boolean isOccupied;

     
     public int getColumnNum() {
    	 return columnNum;
     }
     
     public void setColumnNum(int columnNum) {
    	 this.columnNum = columnNum;
     }
    /**
     * @return the number
     */
    public String getNumName() {
        return numName;
    }
    
    public void setNum(int num) {
    	this.num = num;
    	numName = "NO." + num;
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
		if(isOccupied) {
			return " OCCUPIED" + columnNum + " | " + numName;
		}else {
			return "FREE Column: " + columnNum + ", Slot " + numName + "]";
		}
	}
    
}