package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

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

    public void generateRows(List<ArrayList> rows){
        for(int i = 0; i < 5 ; i ++){
            rows.add(new Column());
            Column row = (Column) rows.get(i);
            row.setColumnNumber(i);
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