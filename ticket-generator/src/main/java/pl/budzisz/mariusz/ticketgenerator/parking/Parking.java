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
            rows.add(i, new ArrayList<Slot>(5));
        }
    }

    public Parking() {
        generateRows(rows);
    }

    @Override
    public String toString() {
        return "{Parking:\n" +
            " rows= '" + getRows().toString() + "'" +
            "}";
    }
}