package pl.budzisz.mariusz.ticketgenerator.parking;

import java.util.ArrayList;
import java.util.List;

public class Row extends ArrayList {
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


    /*public void fillCollumns(List<Slot> slotList){
        for(int j = 0; j < 5 ; j ++){
            slotList.get(j).setNumber("Column = " + columnNumber + "/ " + j);;
        }
    }*/

    public Row() {
        //fillCollumns(slotList);
    }


    @Override
    public String toString() {
        return "\n{" +
            " columnNumber= '" + getColumnNumber() + " '" +
            ", slotList= '" + getSlotList() + " '" +
            "}\n";
    }

}