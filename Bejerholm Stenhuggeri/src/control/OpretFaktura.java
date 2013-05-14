/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import model.Faktura;

/**
 *
 * @author NiklasRenner
 */
public class OpretFaktura {

    //Faktura objekt som bruges til indholdet i fakturaen
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

        //Indsætter detaljer i PDF'en(Hvem den er oprettet af, hvornår, titel og hvad størrelse siden er)
        doc.addCreator("Bejerholm Stenhuggeri");
        doc.addCreationDate();
        doc.addTitle("Bejerholm Stenhuggeri faktura nr. " + faktura.getFaktura_nr());
        doc.setPageSize(PageSize.LETTER);

        //Start skrivning af dokument
        doc.open();
        PdfContentByte cb = docWriter.getDirectContent();

        //Test af tekst
        cb.beginText();
        cb.setFontAndSize(btFont, 28);
        cb.setColorFill(BaseColor.CYAN);
        cb.setTextMatrix(25, 700);
        cb.showText("FAKTURA");
        cb.endText();
        
        doc.close();

    }

    private void initializeFonts() throws DocumentException, IOException {
        btFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        tFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        binfoFont = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        infoFont = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
    }
}
