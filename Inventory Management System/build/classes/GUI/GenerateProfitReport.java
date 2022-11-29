package GUI;

import Code.db;
//import static GUI.GenerateInvoice.getBillRowCell;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import static com.pdf.InvoiceGenerator.getBillRowCell;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateProfitReport {

    public static void main(String[] args) {
        String pdfFilename =  System.getProperty("user.home")+"/Documents/Profit Report.pdf";
        GenerateProfitReport generateInvoice = new GenerateProfitReport();

        generateInvoice.createPDF(pdfFilename);

    }

    private void createPDF(String pdfFilename) {

        try {

            OutputStream file = new FileOutputStream(new File(pdfFilename));
            Document document = new Document();
            PdfWriter.getInstance(document, file);

            //Inserting Image in PDF
//            Image image = Image.getInstance("res/logo.png");//Header Image
//            image.scaleAbsolute(540f, 72f);//image width,height 

            PdfPTable irdTable = new PdfPTable(2);
            irdTable.addCell(getIRDCell("Report No"));
            irdTable.addCell(getIRDCell("Report Date"));
            irdTable.addCell(getIRDCell("1")); // pass Report number
            irdTable.addCell(getIRDCell("")); // pass Report date				

            PdfPTable irhTable = new PdfPTable(3);
            irhTable.setWidthPercentage(100);

            irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
            irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
            irhTable.addCell(getIRHCell("Customer Report", PdfPCell.ALIGN_RIGHT));
            irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
            irhTable.addCell(getIRHCell("", PdfPCell.ALIGN_RIGHT));
            PdfPCell invoiceTable = new PdfPCell(irdTable);
            invoiceTable.setBorder(0);
            irhTable.addCell(invoiceTable);

            PdfPTable billTable = new PdfPTable(8); //one page contains 15 records 
            billTable.setWidthPercentage(100);
            billTable.setWidths(new float[]{3, 3, 2, 3, 2, 2, 2, 2});
            billTable.setSpacingBefore(30.0f);

            billTable.addCell(getBillHeaderCell("Date"));
            billTable.addCell(getBillHeaderCell(" Invoice ID"));
            billTable.addCell(getBillHeaderCell("Sale ID"));
            billTable.addCell(getBillHeaderCell("Customer ID"));
            billTable.addCell(getBillHeaderCell("Cost"));
            billTable.addCell(getBillHeaderCell("Total"));
            billTable.addCell(getBillHeaderCell("Discounts"));
            billTable.addCell(getBillHeaderCell("Profit"));

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM sales  ");
            while (rs.next()) {

                String date = rs.getString("Date");
                String invoiceID = rs.getString("INID");
                String saleID = rs.getString("saleid");
                String cusID = rs.getString("Cid");
                String totCost = rs.getString("Total_Cost");
                String totBill = rs.getString("Total_Bill");
                String discount = rs.getString("Discount");
                String profit = rs.getString("Profit");

                billTable.addCell(getBillRowCell(date));
                billTable.addCell(getBillRowCell(invoiceID));
                billTable.addCell(getBillRowCell(saleID));
                billTable.addCell(getBillRowCell(cusID));
                billTable.addCell(getBillRowCell(totCost));
                billTable.addCell(getBillRowCell(totBill));
                billTable.addCell(getBillRowCell(discount));
                billTable.addCell(getBillRowCell(profit));

            }

//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//
//            billTable.addCell(getBillRowCell(" "));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
//            billTable.addCell(getBillRowCell(""));
            document.open();//PDF document opened........	

//            document.add(image);
            document.add(irhTable);
//			document.add(bill);
//			document.add(name);
//			document.add(contact);
//			document.add(address);			
            document.add(billTable);
//            document.add(describer);

            Rectangle rect = new Rectangle(577, 825, 18, 15); // you can resize rectangle 
            rect.enableBorderSide(1);
            rect.enableBorderSide(2);
            rect.enableBorderSide(4);
            rect.enableBorderSide(8);
            rect.setBorderColor(BaseColor.BLACK);
            rect.setBorderWidth(1);
            document.add(rect);

            document.close();

            file.close();

            System.out.println("Pdf created successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setHeader() {

    }

    public static PdfPCell getIRHCell(String text, int alignment) {
        FontSelector fs = new FontSelector();
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 16);
        /*	font.setColor(BaseColor.GRAY);*/
        fs.addFont(font);
        Phrase phrase = fs.process(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setPadding(5);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    public static PdfPCell getIRDCell(String text) {
        PdfPCell cell = new PdfPCell(new Paragraph(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5.0f);
        cell.setBorderColor(BaseColor.LIGHT_GRAY);
        return cell;
    }

    public static PdfPCell getBillHeaderCell(String text) {
        FontSelector fs = new FontSelector();
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 11);
        font.setColor(BaseColor.GRAY);
        fs.addFont(font);
        Phrase phrase = fs.process(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5.0f);
        return cell;
    }

    public static PdfPCell getBillRowCell(String text) {
        PdfPCell cell = new PdfPCell(new Paragraph(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5.0f);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthTop(0);
        return cell;
    }

    public static PdfPCell getBillFooterCell(String text) {
        PdfPCell cell = new PdfPCell(new Paragraph(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5.0f);
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthTop(0);
        return cell;
    }

    public static PdfPCell getValidityCell(String text) {
        FontSelector fs = new FontSelector();
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
        font.setColor(BaseColor.GRAY);
        fs.addFont(font);
        Phrase phrase = fs.process(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell getAccountsCell(String text) {
        FontSelector fs = new FontSelector();
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
        fs.addFont(font);
        Phrase phrase = fs.process(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setBorderWidthRight(0);
        cell.setBorderWidthTop(0);
        cell.setPadding(5.0f);
        return cell;
    }

    public static PdfPCell getAccountsCellR(String text) {
        FontSelector fs = new FontSelector();
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
        fs.addFont(font);
        Phrase phrase = fs.process(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setBorderWidthLeft(0);
        cell.setBorderWidthTop(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPadding(5.0f);
        cell.setPaddingRight(20.0f);
        return cell;
    }

    public static PdfPCell getdescCell(String text) {
        FontSelector fs = new FontSelector();
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
        font.setColor(BaseColor.GRAY);
        fs.addFont(font);
        Phrase phrase = fs.process(text);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        return cell;
    }

}
