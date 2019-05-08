package pl.budzisz.mariusz.ticketgenerator.parking;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Slot {
     int num = 0;
     int columnNum = 0;
     String numName = "NO." + num;
     SlotStatus isOccupied;

     
     public int getColumnNum() {
    	 return columnNum;
     }
     
     public void setColumnNum(int columnNum) {
    	 this.columnNum = columnNum;
     }

    public String getNumName() {
        return numName;
    }
    
    public void setNum(int num) {
    	this.num = num;
    	numName = "NO." + num;
    }

    public SlotStatus getIsOccupied() {
        return isOccupied;
    }

    public void setOccupied(SlotStatus isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Slot() {
    }

	@Override
	public String toString() {
		if(isOccupied.equals(SlotStatus.OCCUPIED)) {
			return " OCCUPIED ";
		}else {
			return "Miejsce " + numName + " |' FREE '| ";
		}
	}
}