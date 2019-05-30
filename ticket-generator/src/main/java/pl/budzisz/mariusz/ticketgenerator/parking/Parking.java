package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Class representing a first layer of data; contains one ArrayList "row" which contains Columns.
 * @author mariu
 *
 */
@Component
public class Parking {

    List<Column> row = new ArrayList<Column>();

    public List<Column> getRows() {
        return this.row;
    }

    public void setRow(List<Column> row) {
        this.row = row;
    }

    /**
     * This method generates every one of the columns, and fills it in with an empty Slots.
     * @param row
     */
    public void generateRow(List<Column> row){
        for(int i = 0; i < 5 ; i ++){
            row.add(new Column());
            Column column = row.get(i);
            column.setColumnNumber(i);
                for(int j = 0; j < 5 ; j ++){
                	Slot slot = new Slot();
                    column.slotList.add(slot);
                    slot.setNum(j + 1);
                    slot.setColumnNum(column.getColumnNumber());
                    slot.setOccupied(SlotStatus.FREE);
                }
        }
    }

    /**
     * public constructor which automatically invokes a "generateRow()" method.
     */
    public Parking() {
        generateRow(row);
    }

    @Override
    public String toString() {
        return 
            " Columns on parking:\n " + getRows().get(0).toString() + 
            "\n" + getRows().get(1).toString() +
            "\n" + getRows().get(2).toString() +
            "\n" + getRows().get(3).toString() +
            "\n" + getRows().get(4).toString() ;
    }
}