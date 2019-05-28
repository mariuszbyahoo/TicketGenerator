package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Parking {

    List<Column> row = new ArrayList<Column>();

    public List<Column> getRows() {
        return this.row;
    }

    public void setRow(List<Column> row) {
        this.row = row;
    }

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