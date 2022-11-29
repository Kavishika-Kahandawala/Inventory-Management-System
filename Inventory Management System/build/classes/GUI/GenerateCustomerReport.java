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
import com.sun.tools.javac.Main;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
//import static com.pdf.InvoiceGenerator.getBillRowCell;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;

public class GenerateCustomerReport {

    public static void main(String[] args) {

        String pdfFilename = System.getProperty("user.home") + "/Documents/CustomerReport.pdf";
        GenerateCustomerReport generateInvoice = new GenerateCustomerReport();

        generateInvoice.createPDF(pdfFilename);

    }

    private void createPDF(String pdfFilename) {

        try {

            OutputStream file = new FileOutputStream(new File(pdfFilename));
            Document document = new Document();
            PdfWriter.getInstance(document, file);


   

//            Inserting Image in PDF
//            Image image = Image.getInstance("res/logo.png");//Header Image
//           
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

            PdfPTable billTable = new PdfPTable(7); //one page contains 15 records 
            billTable.setWidthPercentage(100);
            billTable.setWidths(new float[]{2, 3, 5, 4, 6, 2, 3});
            billTable.setSpacingBefore(30.0f);
//			billTable.addCell(getBillHeaderCell("Index"));
            billTable.addCell(getBillHeaderCell("ID"));
            billTable.addCell(getBillHeaderCell(" Date"));
            billTable.addCell(getBillHeaderCell("Name"));
            billTable.addCell(getBillHeaderCell("Telephone No"));
            billTable.addCell(getBillHeaderCell("Email"));
            billTable.addCell(getBillHeaderCell("Points"));
            billTable.addCell(getBillHeaderCell("Discounts"));

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM Customer  ");
            while (rs.next()) {

//                itemcount = rs.getString("COUNT(pid)");
                String cusid = rs.getString("Cid");
                String date = rs.getString("Reg_Date");
                String cusfname = rs.getString("Customer_FirstName");
                String cuslname = rs.getString("Customer_LastName");
                String custp = rs.getString("Customer_TP");
                String cusemail = rs.getString("Customer_Email");
                String cuspoints = rs.getString("Loyalty_Points");
                String custotdiscounts = rs.getString("Total_Discounts");

                billTable.addCell(getBillRowCell(cusid));
                billTable.addCell(getBillRowCell(date));
                billTable.addCell(getBillRowCell(cusfname + " " + cuslname));
                billTable.addCell(getBillRowCell(custp));
                billTable.addCell(getBillRowCell(cusemail));
                billTable.addCell(getBillRowCell(cuspoints));
                billTable.addCell(getBillRowCell(custotdiscounts));

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
