package marcop.szablony;
import java.io.IOException;

import marcop.ISzablon;
import marcop.PdfCreator;
import marcop.ReadDataFromExcel;
import marcop.RodzajJezyka;
import marcop.Wiersz;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
// WA�ONA_2
//				TO DO:
//					Uk�ad
//
//
//
public class SzWazona2 implements ISzablon{
	private int liczbaEtykiet=2;
	private RodzajJezyka jezyk;
	private int wysokoscNapisu = 120;
	private int szerokoscNapisu = 450;
	
	public SzWazona2(RodzajJezyka jezyk) {
		this.jezyk=jezyk;
	}
	@Override
	public void wypelnijDokument(Document document) throws IOException, DocumentException {
		
		Rectangle one = new Rectangle(596, 425); 
		document.add(createTable1());
		document.setPageSize(one);
		document.setMargins(2, 2, 2, 2);
		document.newPage();
		document.add(createTable1());
	}
	@Override
	public int getLiczbaEtykiet() {
		return liczbaEtykiet;
	}
	@Override
	public int getArkusz() {
		return arkusz;
	}
	@Override
	public int getWysokoscNapisu() {
		return wysokoscNapisu;
	}
	@Override
	public int getSzerokoscNapisu() {
		return szerokoscNapisu;
	}
	int arkusz = 1;
	public  PdfPTable createTable1() throws DocumentException,
			IOException {

		PdfPTable table = new PdfPTable(4);

		table.setSpacingBefore(300);
		table.setSpacingAfter(0);
		table.setTotalWidth(550);
		table.setLockedWidth(true);
		table.setWidths(new int[] { 1, 0, 0, 0 });

		PdfPCell cell;
		float fntSize = 20, lineSpacing, cellHeight;
		String komPusta, kom1A, kom1B, kom2, kom3,
						 kom2A, kom2B, kom4, kom5;

		BaseFont bf = BaseFont.createFont("arial.ttf",
				BaseFont.CP1250, BaseFont.EMBEDDED);
		Font font = new Font(bf, fntSize, Font.BOLD,
				new CMYKColor(0, 0, 0, 255));

		ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel(0, arkusz);
		PdfCreator.addPage = 1;
		Wiersz wiersz = readDataFromExcel.pobierzWiersz(PdfCreator.addPage + 2);
		Wiersz wiersz2 = readDataFromExcel.pobierzWiersz(PdfCreator.addPage + 3);
		Wiersz wiersz3 = readDataFromExcel.pobierzWiersz(PdfCreator.addPage + 4);
		Wiersz wiersz4 = readDataFromExcel.pobierzWiersz(PdfCreator.addPage + 5);


		komPusta = ""; 																// PE�NA NAZWA
		kom1A = (wiersz.getEx2A() + " - 3 KG"); 									// PE�NA NAZWA
		kom1B = (wiersz2.getEx2A() + " - 3 KG");									 // PE�NA NAZWA
		kom2 = ("KOD:" + wiersz2.getEx2B().split("\\.")[0] 							// KOD, PARTIA, DATA
				+ "   PARTIA:" + wiersz2.getEx2C().split("\\.")[0] + "   DATA WA�NO�CI: 12/2019");
		kom3 = ("TEMPERATURA POLIMERYZACJI " + wiersz2.getEx2E());					 // TEMPERATURA

		
		kom2A = (wiersz3.getEx2A() + " - 3 KG"); 									// PE�NA NAZWA
		kom2B = (wiersz4.getEx2A() + " - 3 KG");									 // PE�NA NAZWA
		kom4 = ("KOD:" + wiersz4.getEx2B().split("\\.")[0] 							// KOD, PARTIA, DATA
				+ "   PARTIA:" + wiersz4.getEx2C().split("\\.")[0] + "   DATA WA�NO�CI: 12/2019");
		kom5 = ("TEMPERATURA POLIMERYZACJI " + wiersz4.getEx2E());					 // TEMPERATURA
		
		
		// ////////////////////////////////////////////////
		// kom1B = Pe�na nazwa

		lineSpacing = 30;
		cellHeight = 120;
		Paragraph p = new Paragraph(new Phrase(lineSpacing, komPusta, font));

		cell = new PdfPCell(p);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// ////////////////////////////////////////////////
		// kom1B = Pe�na nazwa

		lineSpacing = 0;
		cellHeight = 20;
		Paragraph p2 = new Paragraph(new Phrase(lineSpacing, kom1A, font));

		cell = new PdfPCell(p2);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);
		// ////////////////////////////////////////////////
		// kom1B = Pe�na nazwa

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p3 = new Paragraph(new Phrase(lineSpacing, kom1B, font));

		cell = new PdfPCell(p3);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// //////////////////////////////////////////
		// kom2 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p4 = new Paragraph(new Phrase(lineSpacing, kom2, font));

		cell = new PdfPCell(p4);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// ////////////////////////////////////////////////
		// kom3 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p5 = new Paragraph(new Phrase(lineSpacing, kom3, font));

		cell = new PdfPCell(p5);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// kom1B = Pe�na nazwa

//		lineSpacing = 30;
//		cellHeight = 20;
//		Paragraph p6 = new Paragraph(new Phrase(lineSpacing, komPusta, font));
//
//		cell = new PdfPCell(p6);
//		cell.setColspan(4);
//		cell.setFixedHeight(cellHeight);
//		cell.setBorder(PdfPCell.NO_BORDER);
//		cell.setPaddingLeft(0);
//		cell.setPaddingRight(0);
//		cell.setPaddingTop(0);
//		cell.setPaddingBottom(0);
//		table.addCell(cell);

		// ////////////////////////////////////////////////
		// kom1B = Pe�na nazwa

		lineSpacing = 0;
		cellHeight = 20;
		Paragraph p7 = new Paragraph(new Phrase(lineSpacing, kom2A, font));

		cell = new PdfPCell(p7);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);
		// ////////////////////////////////////////////////
		// kom1B = Pe�na nazwa

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p8 = new Paragraph(new Phrase(lineSpacing, kom2B, font));

		cell = new PdfPCell(p8);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// //////////////////////////////////////////
		// kom2 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p9 = new Paragraph(new Phrase(lineSpacing, kom4, font));

		cell = new PdfPCell(p9);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);

		// ////////////////////////////////////////////////
		// kom3 =

	//	lineSpacing = 30;
	//	cellHeight = 50;
		Paragraph p10 = new Paragraph(new Phrase(lineSpacing, kom5, font));

		cell = new PdfPCell(p10);
		cell.setColspan(4);
		cell.setFixedHeight(cellHeight);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPaddingLeft(0);
		cell.setPaddingRight(0);
		cell.setPaddingTop(0);
		cell.setPaddingBottom(0);
		table.addCell(cell);
		
		return table;

	}

	
}