/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Ordre;

/**
 *
 * @author NiklasRenner
 */
public class OpretOrdre {

    //Faktura objekt m.m. som bruges til indholdet i fakturaen
    private Ordre ordre;
    //Skrift til alm. tekst
    private BaseFont tFont;
    //Skrift til fed alm. tekst
    private BaseFont btFont;
    //Skrift til info om virksomheden
    private BaseFont infoFont;
    //Skrift til fed into om virksomheden
    private BaseFont binfoFont;

    public OpretOrdre(Ordre ordre) {
        this.ordre = ordre;
    }

    public void genererOrdre(String filNavn) throws IOException, DocumentException {

        //Opretter nyt dokument til indhold
        Document doc = new Document();
        //Sti'en for pdf'en der oprettes
        String path = "docs/" + filNavn.trim();
        //Opretter writer til at skrive dokumentet til pdf, samt hvilken sti pdf'en skal lægges
        PdfWriter docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
        //Indlæser skrifte
        initializeFonts();
        //Farver
        BaseColor red = new BaseColor(255, 0, 0);
        BaseColor blue = new BaseColor(0, 0, 255);
        BaseColor black = BaseColor.BLACK;
        //Alignment
        int left = PdfContentByte.ALIGN_LEFT;
        int right = PdfContentByte.ALIGN_RIGHT;
        int center = PdfContentByte.ALIGN_CENTER;

        //Indsætter detaljer i PDF'en(Hvem den er oprettet af, hvornår, titel og hvad størrelse siden er)
        doc.addCreator("Bejerholm Stenhuggeri");
        doc.addCreationDate();
        doc.addTitle("Bejerholm Stenhuggeri ordre nr. " + ordre.getOrdre_nr());
        doc.setPageSize(PageSize.LETTER);

        //Start skrivning af dokument
        doc.open();
        PdfContentByte cb = docWriter.getDirectContent();

        //Sæt Logo ind og faktura overskrift
        Image companyLogo = Image.getInstance("images/bejerholm.gif");
        companyLogo.setAbsolutePosition(25, 665);
        companyLogo.scalePercent(25);
        doc.add(companyLogo);

        //Skriv brevhoved højre side
        createContent(cb, binfoFont, 11, black, 575, 760, "Bejerholms Stenhuggeri v/René Bejerholm Poulsen", right);
        createContent(cb, infoFont, 11, black, 575, 748, "Fægangen 8, 4220 Korsør, Tlf. 58 35 00 04", right);
        createContent(cb, infoFont, 11, black, 575, 736, "Nørre Allé 1, 4400 Kalundborg, Tlf. 42 76 00 04", right);
        createContent(cb, infoFont, 11, black, 575, 724, "Fax 58 35 00 33", right);
        createContent(cb, infoFont, 11, blue, 575, 712, "bejerholm.stenhuggeri@gmail.com", right);
        createContent(cb, infoFont, 11, blue, 575, 700, "www.bejerholms-stenhuggeri.dk", right);
        createContent(cb, infoFont, 11, black, 575, 688, "CVR-NR: 32931898", right);
        createContent(cb, binfoFont, 11, black, 575, 676, "Sydbank  -  Reg. nr. 6821", right);
        createContent(cb, binfoFont, 11, black, 575, 664, "Konto 1021974", right);

        //Opret tabel til kundeinfo
        cb.rectangle(25, 580, 275, 80);
        cb.moveTo(25, 640);
        cb.lineTo(300, 640);
        cb.moveTo(25, 620);
        cb.lineTo(300, 620);
        cb.moveTo(25, 600);
        cb.lineTo(300, 600);
        cb.stroke();
        createContent(cb, btFont, 12, black, 29, 644, "Kundeinformation:", left);
        
        //Indsæt data til kundeinfo
        String navn = ordre.getKunde().getFornavn()+" "+ordre.getKunde().getEfternavn();
        createContent(cb, tFont, 12, black, 29, 624, navn, left);
        String adresse = ordre.getKunde().getAdresse();
        createContent(cb, tFont, 12, black, 29, 604, adresse, left);
        String postnrby = ordre.getKunde().getPost_nr().getPost_nr()+" "+ordre.getKunde().getPost_nr().getByNavn();
        createContent(cb, tFont, 12, black, 29, 584, postnrby, left);
        
        //Indsættelse af ordrebekræftigelse-tabel
        createContent(cb, btFont, 16, red, 325, 644, "Ordrebekræftelse:", left);
        createContent(cb, btFont, 12, black, 325, 624, "Dato:", left);
        createContent(cb, btFont, 12, black, 325, 604, "Telefon:", left);
        createContent(cb, btFont, 12, black, 325, 584, "Ordrenr:", left);
        cb.moveTo(325, 620);
        cb.lineTo(575, 620);
        cb.moveTo(325, 600);
        cb.lineTo(575, 600);
        cb.moveTo(325, 580);
        cb.lineTo(575, 580);
        cb.stroke();
        
        //Indsættelse af data i ordrebekræftelse  
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        createContent(cb, btFont, 12, black, 571, 624, timeStamp, right);
        String tlf = ordre.getKunde().getTlf()+"";
        createContent(cb, btFont, 12, black, 571, 604, tlf, right);
        String ordre_nr = ordre.getOrdre_nr();
        createContent(cb, btFont, 12, red, 571, 584, ordre_nr, right);
        
        //Opret info-tabeller
        createContent(cb, btFont, 12, black, 29, 544, "Ny sten(nr.)", left);
        createContent(cb, btFont, 12, black, 29, 524, "Tilføjelse", left);
        createContent(cb, btFont, 12, black, 29, 504, "Kiste/Urne", left);
        cb.rectangle(25, 500, 150, 60);
        cb.moveTo(25, 540);
        cb.lineTo(175, 540);
        cb.moveTo(25, 520);
        cb.lineTo(175, 520);
        cb.moveTo(125, 560);
        cb.lineTo(125, 500);
        cb.stroke();
        createContent(cb, btFont, 12, black, 184, 544, "Afh. dato", left);
        createContent(cb, btFont, 12, black, 184, 524, "Lev. dato", left);
        cb.rectangle(180, 520, 200, 40);
        cb.moveTo(180, 540);
        cb.lineTo(380, 540);
        cb.moveTo(280, 560);
        cb.lineTo(280, 520);
        cb.stroke();
        createContent(cb, btFont, 12, black, 29, 544, "Ny sten(nr.)", left);
        createContent(cb, btFont, 12, black, 29, 524, "Tilføjelse", left);
        createContent(cb, btFont, 12, black, 29, 504, "Kiste/Urne", left);
        cb.rectangle(385, 500, 200, 60);
        cb.moveTo(25, 540);
        cb.lineTo(175, 540);
        cb.moveTo(25, 520);
        cb.lineTo(175, 520);
        cb.moveTo(125, 560);
        cb.lineTo(125, 500);
        cb.stroke();
        
        
        
        //midlertidig flytning
        int tmp = 100;

        //Farv tabel baggrund
        cb.setRGBColorFill(216, 228, 232);
        cb.rectangle(25, 480-tmp, 550, 20);
        cb.rectangle(475, 200-tmp, 100, 300);
        cb.rectangle(475, 140-tmp, 100, 20);
        cb.rectangle(475, 180-tmp, 100, 20);
        cb.fill();
        
        //Tegn tabel
        cb.rectangle(25, 200-tmp, 550, 300);
        cb.moveTo(25, 480-tmp);
        cb.lineTo(575, 480-tmp);
        cb.moveTo(100, 500-tmp);
        cb.lineTo(100, 200-tmp);
        cb.moveTo(375, 500-tmp);
        cb.lineTo(375, 200-tmp);
        cb.moveTo(475, 500-tmp);
        cb.lineTo(475, 200-tmp);
        cb.moveTo(475, 180-tmp);
        cb.lineTo(575, 180-tmp);
        cb.moveTo(475, 160-tmp);
        cb.lineTo(575, 160-tmp);
        cb.rectangle(475, 140-tmp, 100, 60);
        cb.moveTo(475, 120-tmp);
        cb.lineTo(575, 120-tmp);
        cb.moveTo(475, 118-tmp);
        cb.lineTo(575, 118-tmp);
        cb.stroke();
        
        //Indsæt navne på tabel elementer
        createContent(cb, btFont, 12, black, 63, 484-tmp, "ANTAL", center);
        createContent(cb, btFont, 12, black, 238, 484-tmp, "BESKRIVELSE", center);
        createContent(cb, btFont, 12, black, 425, 484-tmp, "ENHEDSPRIS", center);
        createContent(cb, btFont, 12, black, 525, 484-tmp, "BELØB", center);
        createContent(cb, tFont, 12, black, 110, 204-tmp, "Miljøafgift 2,5%", left);
        createContent(cb, tFont, 12, black, 465, 184-tmp, "SUBTOTAL", right);
        createContent(cb, tFont, 12, black, 465, 164-tmp, "MOMS", right);
        createContent(cb, tFont, 12, black, 465, 144-tmp, "SALGSMOMS", right);
        createContent(cb, btFont, 12, black, 465, 124-tmp, "I ALT", right);
        
        //Indsæt data for varelinjer
        int tmpY = 464-tmp;
        double total = 0;
        int quantity = 0;
        double price = 0;
        double itemPrice = 0;
        
        for(int i=1; i<14; i++){

            quantity = i;
            itemPrice = Double.valueOf(Math.random() * 10);
            price = quantity * itemPrice;
            total += price;
            
            createContent(cb, tFont, 12, black, 63, tmpY, ""+quantity, center);
            createContent(cb, tFont, 12, black, 110, tmpY, "BESKRIVELSE "+i, left);
            createContent(cb, tFont, 12, black, 465, tmpY, ""+NumberFormat.getCurrencyInstance().format(itemPrice), right);
            createContent(cb, tFont, 12, black, 565, tmpY, ""+NumberFormat.getCurrencyInstance().format(price), right);
            
            tmpY = tmpY - 20;
        }
        createContent(cb, tFont, 12, black, 565, 204-tmp, ""+NumberFormat.getCurrencyInstance().format(total*+0.025), right);
        total += (total*0.025);
        createContent(cb, tFont, 12, black, 565, 184-tmp, ""+NumberFormat.getCurrencyInstance().format(total), right);
        createContent(cb, tFont, 12, black, 565, 164-tmp, "25,00%", right);
        createContent(cb, tFont, 12, black, 565, 144-tmp, ""+NumberFormat.getCurrencyInstance().format(total*0.25), right);
        total += (total*0.25);
        createContent(cb, tFont, 12, black, 565, 124-tmp, ""+NumberFormat.getCurrencyInstance().format(total), right);
        
        //Lukker dokument og skriver alt det data der er blevet indsat til PDF-filen
        doc.close();

    }

    //Indsættelse af data i PDF-filen ved hjælp af data metoden bliver kaldt med    
    public void createContent(PdfContentByte cb, BaseFont font, int fontSize, BaseColor color, float x, float y, String text, int align) {
        //Start med indsættelsen af data til det enkelte tekst objekt
        cb.beginText();
        //Sætter størrelse af tekst og skrifttype
        cb.setFontAndSize(font, fontSize);
        //Sætter farve
        cb.setColorFill(color);
        //Sætter position af teksten
        cb.showTextAligned(align, text.trim(), x, y, 0);
        //Gemmer alt data til tekstobjektet
        cb.endText();
    }

    //Predefinere skrifte der bruges i dokumentet
    private void initializeFonts() throws DocumentException, IOException {
        btFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        tFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        binfoFont = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        infoFont = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
    }
}
