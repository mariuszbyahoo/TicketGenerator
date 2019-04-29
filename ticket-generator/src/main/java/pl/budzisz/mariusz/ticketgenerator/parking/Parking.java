package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Parking {

    List<ArrayList> rows = new ArrayList<>(5);

    public List<ArrayList> getRows() {
        return this.rows;
    }

    public void setRows(List<ArrayList> rows) {
        this.rows = rows;
    }

    public void generateRows(List<ArrayList> rows){
        for(int i = 0; i < 5 ; i ++){
            ArrayList<Slot> column = new ArrayList<Slot>(5);
            generateColumns(column);
            rows.add(i, column);
        }
    }

    public void generateColumns(List<Slot>columns){
        for(int j = 0 ; j < 5 ; j ++){
            columns.add(new Slot());
        }
    }

    public Parking() {
        generateRows(rows);
        System.out.println("Wygenerowano wiersze");
    }

    @Override
    public String toString() {
        return "{Parking:\n" +
            " rows= '" + getRows().get(0).toString() + 
            "\n" + getRows().get(1).toString() +
            "\n" + getRows().get(2).toString() +
            "\n" + getRows().get(3).toString() +
            "\n" + getRows().get(4).toString() + "'" +
            "}";
    }
}