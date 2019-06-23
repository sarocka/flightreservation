package flightReservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import flightReservation.model.Reservation;

@Component
public class PDFGenerator {

	public void generatePdf(Reservation reservation, String filePath){
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		document.open();
		try {
			document.add(generateTable(reservation));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.close();
	}

	private PdfPTable generateTable(Reservation reservation) {
	PdfPTable table = new PdfPTable(2);
	PdfPCell cell = new PdfPCell(new Phrase("Flight itinerary"));
	cell.setColspan(2);
	table.addCell(cell);
	cell = new PdfPCell(new Phrase("Flight details"));
	cell.setColspan(2);
	table.addCell(cell);
	table.addCell("Departure city: ");
	table.addCell(reservation.getFlight().getDepartureCity());
		return table;
	}
}
