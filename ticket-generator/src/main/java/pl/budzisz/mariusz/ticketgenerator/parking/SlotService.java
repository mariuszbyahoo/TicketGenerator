package pl.budzisz.mariusz.ticketgenerator.parking;

import java.io.File;
import java.io.IOException;
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

    public String writeParkingInfo(){
        return parking.toString();
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
    	
    	Text title = new Text("Tytul");
    	Text author = new Text("Autor");
    	Paragraph p = new Paragraph().add(title).add(" Napisane przez ").add(author);
    	document.add(p);
    	document.close();
    	
    }
}