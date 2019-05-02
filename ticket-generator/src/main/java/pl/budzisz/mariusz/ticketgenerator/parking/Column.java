package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Column extends ArrayList {
    
	int columnNumber = 0;
    
    List<Slot> slotList = new ArrayList<Slot>(5);


    public int getColumnNumber() {
        return this.columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public List<Slot> getSlotList() {
        return this.slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }


    

    public Column() {
    }


    @Override
    public String toString() {
        return "\n{" +
            " columnNumber= '" + getColumnNumber() + " '" +
            ", slotList= '" + getSlotList() + " '" +
            "}\n";
    }

}