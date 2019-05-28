package pl.budzisz.mariusz.ticketgenerator.parking;

import java.io.File;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import pl.budzisz.mariusz.ticketgenerator.ticket.Ticket;

@Service
public class SlotService{

@Autowired
Parking parking;

private String contentProt;
private JsonArray column1;
private JsonValue slotObject1;
private JsonValue slotObject2;
private JsonValue slotObject3;
private JsonValue slotObject4;
private JsonValue slotObject5;
private JsonValue soldTicketsObject;

    public JsonArray writeParkingInfo(){
    	prepareParkingData();
        return column1;
        		//"Dane Json: \n" + parkingObject +"\n" + parking.toString();
    }
    
    public void occupySlot(int columnNumber, int slotNumber) {
    	
    	parking.getRows().
    	get(columnNumber).getSlotList().
    	get(slotNumber).setOccupied(SlotStatus.OCCUPIED);
    	
    	System.out.println(parking.getRows().
    			get(columnNumber).getSlotList().
    			get(slotNumber).toString());
    }
    
    public void exitSlot(int columnNumber, int slotNumber) {
    	parking.getRows().
    	get(columnNumber).getSlotList().
    	get(slotNumber).setOccupied(SlotStatus.FREE);
    	
    	System.out.println(parking.getRows().
    			get(columnNumber).getSlotList().
    			get(slotNumber).toString());
    }
    
    public void ticketAsPdf(String dest, Slot slot) throws IOException{
    	PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
    	
    	Document document = new Document(pdf);
    	
    	PdfFont font = PdfFontFactory.createFont();
    	
    	Text title = new Text("Welcome on my parking!");
    	String desc = "Your parking lot: " + slot.getNumName() + " column number: " + (slot.getColumnNum() + 1);
    	
    	Paragraph p1 = new Paragraph().add(title);
    	Paragraph p2 = new Paragraph().add(desc);
    	document.add(p1);
    	document.add(p2);
    	document.close();
    }
    
    public void parkingInfoAsPdf(String dest) throws IOException{
    	
    	PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
    	
    	Document document = new Document(pdf);
    	
    	PdfFont font = PdfFontFactory.createFont();
    	
    	Text title = new Text("Theres my parking: ");
    	try {
    		contentProt = parking.getRows().get(0).toString() + "\n" + parking.getRows().get(1).toString()
    				+"\n"+ parking.getRows().get(2).toString() + "\n" + parking.getRows().get(3).toString() 
    				+ "\n" + parking.getRows().get(4).toString();
    	}catch(Exception ex) {
    		System.out.println("\nTheres your stack trace:\n");
    		ex.printStackTrace();
    	}
    	
    	Text content = new Text(contentProt);
    	Paragraph p1 = new Paragraph().add(title);
    	Paragraph p2 = new Paragraph().add(content);
    	document.add(p1);
    	document.add(p2);
    	document.close();
    	
    }
    
    public void prepareParkingData() {
    		JsonObjectBuilder slotBuilder = Json.createObjectBuilder();
    		JsonArrayBuilder columnBuilder = Json.createArrayBuilder();

    		
    		slotObject1 = slotBuilder.add("Column 1", prepareStringColumn(0)).build();
    		slotObject2 = slotBuilder.add("Column 2", prepareStringColumn(1)).build();
    		slotObject3 = slotBuilder.add("Column 3", prepareStringColumn(2)).build();
    		slotObject4 = slotBuilder.add("Column 4", prepareStringColumn(3)).build();
    		slotObject5 = slotBuilder.add("Column 5", prepareStringColumn(4)).build();

    		columnBuilder.add(slotObject1);
    		columnBuilder.add(slotObject2);
    		columnBuilder.add(slotObject3);
    		columnBuilder.add(slotObject4);
    		columnBuilder.add(slotObject5);
    		column1 = columnBuilder.build();
    		
    		System.out.println(slotObject1.toString() + " ");

    }
    
    private String prepareStringColumn(int columnIndex) {
    	String desc =  parking.row.get(columnIndex).slotList.get(0).getNumName() +" stan miejsca: "+ parking.row.get(columnIndex).slotList.get(0).getIsOccupied()
        		+" | "+parking.row.get(columnIndex).slotList.get(1).getNumName() +" stan miejsca: "+ parking.row.get(columnIndex).slotList.get(1).getIsOccupied()
        		+" | "+parking.row.get(columnIndex).slotList.get(2).getNumName() +" stan miejsca: "+ parking.row.get(columnIndex).slotList.get(2).getIsOccupied()
        		+" | "+parking.row.get(columnIndex).slotList.get(3).getNumName() +" stan miejsca: "+ parking.row.get(columnIndex).slotList.get(3).getIsOccupied()
        		+" | "+parking.row.get(columnIndex).slotList.get(4).getNumName() +" stan miejsca: "+ parking.row.get(columnIndex).slotList.get(4).getIsOccupied();
    	return desc;
    }
}