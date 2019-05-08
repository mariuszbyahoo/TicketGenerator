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
String parkingLotDesc1;
String parkingLotDesc2;
String parkingLotDesc3;
String parkingLotDesc4;
String parkingLotDesc5;

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
    
    public void createPdf(String dest) throws IOException{
    	
    	PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
    	
    	Document document = new Document(pdf);
    	
    	PdfFont font = PdfFontFactory.createFont();
    	
    	Text title = new Text("Oto nasz parking: ");
    	try {
    		for(int i = 0 ; i < parking.getRows().size(); i ++) {
    			contentProt = contentProt + "\n" + parking.getRows().get(i).toString();
    		}
    	}catch(Exception ex) {
    		System.out.println("\nA oto nasz stack trace:\n");
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
    		parkingLotDesc1 =  parking.row.get(0).slotList.get(0).getNumName() +" stan miejsca: "+ parking.row.get(0).slotList.get(0).getIsOccupied();
    		parkingLotDesc2 =  parking.row.get(1).slotList.get(1).getNumName() +" stan miejsca: "+ parking.row.get(1).slotList.get(1).getIsOccupied();
    		parkingLotDesc3 =  parking.row.get(2).slotList.get(2).getNumName() +" stan miejsca: "+ parking.row.get(2).slotList.get(2).getIsOccupied();
    		parkingLotDesc4 =  parking.row.get(3).slotList.get(3).getNumName() +" stan miejsca: "+ parking.row.get(3).slotList.get(3).getIsOccupied();
    		parkingLotDesc5 =  parking.row.get(4).slotList.get(4).getNumName() +" stan miejsca: "+ parking.row.get(4).slotList.get(4).getIsOccupied();
    		
    		slotObject1 = slotBuilder.add("Lot", parkingLotDesc1).build();
    		slotObject2 = slotBuilder.add("Lot", parkingLotDesc2).build();
    		slotObject3 = slotBuilder.add("Lot", parkingLotDesc3).build();
    		slotObject4 = slotBuilder.add("Lot", parkingLotDesc4).build();
    		slotObject5 = slotBuilder.add("Lot", parkingLotDesc5).build();

    		columnBuilder.add(slotObject1);
    		columnBuilder.add(slotObject2);
    		columnBuilder.add(slotObject3);
    		columnBuilder.add(slotObject4);
    		columnBuilder.add(slotObject5);
    		column1 = columnBuilder.build();
    		
    		System.out.println(slotObject1.toString() + " " + slotObject2.toString());

    }
}