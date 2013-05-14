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
import model.Faktura;

/**
 *
 * @author NiklasRenner
 */
public class OpretFaktura {

    //Faktura objekt m.m. som bruges til indholdet i fakturaen
    private Faktura faktura;
    //Skrift til alm. tekst
    private BaseFont tFont;
    //Skrift til fed alm. tekst
    private BaseFont btFont;
    //Skrift til info om virksomheden
    private BaseFont infoFont;
    //Skrift til fed into om virksomheden
    private BaseFont binfoFont;

    public OpretFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public void genererFaktura(String filNavn) throws IOException, DocumentException {

        //Opretter nyt dokument til indhold
        Document doc = new Document();
        //Sti'en for pdf'en der oprettes
        String path = "docs/" + filNavn.trim();
        //Opretter writer til at skrive dokumentet til pdf, samt hvilken sti pdf'en skal lægges
        PdfWriter docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
        //Indlæser skrifte
        initializeFonts();
        //Farver
        BaseColor lightblue = new BaseColor(141, 180, 226);
        BaseColor blue = new BaseColor(0, 0, 255);
        BaseColor black = BaseColor.BLACK;
        //Alignment
        int left = PdfContentByte.ALIGN_LEFT;
        int right = PdfContentByte.ALIGN_RIGHT;
        int center = PdfContentByte.ALIGN_CENTER;

        //Indsætter detaljer i PDF'en(Hvem den er oprettet af, hvornår, titel og hvad størrelse siden er)
        doc.addCreator("Bejerholm Stenhuggeri");
        doc.addCreationDate();
        doc.addTitle("Bejerholm Stenhuggeri faktura nr. " + faktura.getFaktura_nr());
        doc.setPageSize(PageSize.LETTER);

        //Start skrivning af dokument
        doc.open();
        PdfContentByte cb = docWriter.getDirectContent();

        //Sæt Logo ind og faktura overskrift
        createContent(cb, btFont, 28, lightblue, 25, 725, "FAKTURA", left);
        Image companyLogo = Image.getInstance("images/bejerholm.gif");
        companyLogo.setAbsolutePosition(375, 675);
        companyLogo.scalePercent(25);
        doc.add(companyLogo);

        //Skriv brevhoved højre side
        createContent(cb, binfoFont, 11, black, 575, 660, "Bejerholms Stenhuggeri v/René Bejerholm Poulsen", right);
        createContent(cb, infoFont, 11, black, 575, 648, "Fægangen 8, 4220 Korsør, Tlf. 58 35 00 04", right);
        createContent(cb, infoFont, 11, black, 575, 636, "Nørre Allé 1, 4400 Kalundborg, Tlf. 42 76 00 04", right);
        createContent(cb, infoFont, 11, black, 575, 624, "Fax 58 35 00 33", right);
        createContent(cb, infoFont, 11, blue, 575, 612, "bejerholm.stenhuggeri@gmail.com", right);
        createContent(cb, infoFont, 11, blue, 575, 600, "www.bejerholms-stenhuggeri.dk", right);
        createContent(cb, infoFont, 11, black, 575, 588, "CVR-NR: 32931898", right);
        createContent(cb, binfoFont, 11, black, 575, 576, "Sydbank  -  Reg. nr. 6821", right);
        createContent(cb, binfoFont, 11, black, 575, 564, "Konto 1021974", right);

        //Indsættelse af data om kundenavn og faktureringsadresse
        createContent(cb, btFont, 12, black, 25, 660, "Faktureres til:", left);
        String navn = faktura.getOrdre().getKunde().getFornavn() + " " + faktura.getOrdre().getKunde().getEfternavn();
        createContent(cb, tFont, 12, black, 25, 644, navn, left);
        String adresse = faktura.getOrdre().getKunde().getAdresse();
        createContent(cb, tFont, 12, black, 25, 628, adresse, left);
        String postnrby = faktura.getOrdre().getKunde().getPost_nr().getPost_nr() + " " + faktura.getOrdre().getKunde().getPost_nr().getByNavn();
        createContent(cb, tFont, 12, black, 25, 612, postnrby, left);

        //Indsættelse af dato og fakturanummer
        createContent(cb, btFont, 12, black, 385, 525, "DATO:", left);
        String timeStamp = new SimpleDateFormat("dd. MMM yyyy").format(Calendar.getInstance().getTime());
        createContent(cb, tFont, 12, black, 575, 525, timeStamp, right);
        createContent(cb, btFont, 12, black, 385, 509, "FAKTURANR:", left);
        String faktura_nr = faktura.getFaktura_nr();
        createContent(cb, tFont, 12, black, 575, 509, faktura_nr, right);

        //Indsættelse af ordrenummer og evt. hvem stenen er vedrørende
        createContent(cb, btFont, 12, black, 25, 541, "Vedrørende:", left);
        String ordre_nr = faktura.getOrdre().getOrdre_nr();
        createContent(cb, tFont, 12, black, 25, 525, "Ordrenummer " + ordre_nr, left);
        String afdødnavn = faktura.getOrdre().getAfdødnavn();
        if (afdødnavn != null) {
            createContent(cb, tFont, 12, black, 25, 509, "Vedr. gravsten til " + afdødnavn, left);
        }

        //Farv tabel baggrund
        cb.setRGBColorFill(216, 228, 232);
        cb.rectangle(25, 480, 550, 20);
        cb.rectangle(475, 200, 100, 300);
        cb.fill();
        
        //Tegn tabel
        cb.rectangle(25, 200, 550, 300);
        cb.moveTo(25, 480);
        cb.lineTo(575, 480);
        cb.moveTo(100, 500);
        cb.lineTo(100, 200);
        cb.moveTo(375, 500);
        cb.lineTo(375, 200);
        cb.moveTo(475, 500);
        cb.lineTo(475, 200);
        
        //Indsæt navne på tabel elementer
        createContent(cb, btFont, 12, black, 63, 484, "ANTAL", center);
        createContent(cb, btFont, 12, black, 238, 484, "BESKRIVELSE", center);
        createContent(cb, btFont, 12, black, 425, 484, "ENHEDSPRIS", center);
        createContent(cb, btFont, 12, black, 525, 484, "BELØB", center);

        cb.stroke();
        
        //Indsæt data for varelinjer
        int tmpY = 464;
        double total = 0;
        int quantity = 0;
        double price;
        for(int i=1; i<=14; i++){
            
            String money = NumberFormat.getCurrencyInstance().format(i);
            quantity = i;
            price = Double.valueOf(NumberFormat.getCurrencyInstance().format(Math.random() * 10));
            
            createContent(cb, tFont, 12, black, 63, tmpY, ""+i, center);
            createContent(cb, tFont, 12, black, 110, tmpY, "BESKRIVELSE "+i, left);
            createContent(cb, tFont, 12, black, 465, tmpY, ""+i, right);
            createContent(cb, tFont, 12, black, 565, tmpY, ""+(i*1000), right);
            
            tmpY = tmpY - 20;
        }
        createContent(cb, tFont, 12, black, 565, 204, ""+NumberFormat.getCurrencyInstance().format(total), left);

        //test
        //cb.moveTo(250, 250);
        //cb.lineTo(250,300);
        //cb.lineTo(275, 250);
        //cb.lineTo(275, 300);
        
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
