package pl.budzisz.mariusz.ticketgenerator.parking;

import java.io.File;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

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
private JsonObject parkingObject;
private JsonObject soldTicketsObject;
String parkingLotDesc;

    public JsonObject writeParkingInfo(){
    	prepareParkingData();
        return parkingObject;
        		//"Dane Json: \n" + parkingObject +"\n" + parking.toString();
    }
    
    public void occupySlot(int columnNumber, int slotNumber) {
    	
    	parking.getRows().
    	get(columnNumber).getSlotList().
    	get(slotNumber).setOccupied(true);
    	
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
    	for(int i = 0 ; i < parking.getRows().size(); i ++) {
    		JsonObjectBuilder parkingBuilder = Json.createObjectBuilder();
    		JsonObjectBuilder soldTicketsBuilder = Json.createObjectBuilder();
    		parkingLotDesc =  parking.row.get(0).slotList.get(0).getNumName() +" stan miejsca: "+ parking.row.get(0).slotList.get(0).getIsOccupied();
    		
    		parkingBuilder.add("Tytuł parkingBuidera",1);
    		soldTicketsBuilder.add("Tytuł soldTicketsBuildera", 1);
    		
    		parkingObject = parkingBuilder.add("Parking Lot", parkingLotDesc).add("val2", "a to jest druga wartość").build();
    		// tu trzeba zrobić parking jako obiekt JSON i potem każda kolumna jako JSON i każde miejsce parkingowe jako JSON
    	}
    }
}