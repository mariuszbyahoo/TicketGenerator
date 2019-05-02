package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parking {

    List<ArrayList> row = new ArrayList<ArrayList>();

    public List<ArrayList> getRows() {
        return this.row;
    }

    public void setRow(List<ArrayList> row) {
        this.row = row;
    }

    public void generateRows(List<ArrayList> row){
        for(int i = 0; i < 5 ; i ++){
            row.add(new Column());
            Column column = (Column) row.get(i);
            column.setColumnNumber(i);
                for(int j = 0; j < 5 ; j ++){
                	Slot slot = new Slot();
                    column.slotList.add(slot);
                    slot.setNum(j + 1);
                    slot.setColumnNum(column.getColumnNumber());
                }
        }
    }

    public Parking() {
        generateRows(row);
        System.out.println("Wygenerowano wiersze");
    }

    @Override
    public String toString() {
        return "{Parking:\n" +
            " row of Columns= '" + getRows().get(0).toString() + 
            "\n" + getRows().get(1).toString() +
            "\n" + getRows().get(2).toString() +
            "\n" + getRows().get(3).toString() +
            "\n" + getRows().get(4).toString() + "'" +
            "}";
    }
}