package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * "Prototype" - Scoped class representing every column of Parking Lots, contains it own position in the row and an ArrayList of Slots of course.
 * @author mariu
 *
 */
@Scope("prototype")
@Component
public class Column {
    
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
        return "\n" +
            " Column " + (getColumnNumber()+1) + "" +
            ", parking Lots= " + getSlotList() + " " +
            "\n";
    }

}