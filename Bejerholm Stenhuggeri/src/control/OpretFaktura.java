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
    public final Font tFont = new Font(Font.FontFamily.HELVETICA  , 12, Font.NORMAL, BaseColor.BLACK);
    //Skrift til fed alm. tekst
    public final Font btFont = new Font(Font.FontFamily.HELVETICA  , 12, Font.BOLD, BaseColor.BLACK);
    //Skrift til faktura overskrift
    public final Font fakturaFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.CYAN);
    
    public OpretFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public void genererFaktura(String filNavn) throws IOException, DocumentException{

        //Opretter nyt dokument til indhold
        Document doc = new Document();
        //Sti'en for pdf'en der oprettes
        String path = "docs/" + filNavn.trim();
        //Opretter writer til at skrive dokumentet til pdf, samt hvilken sti pdf'en skal lægges
        PdfWriter docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
        
        //Indsætter detaljer i PDF'en(Hvem den er oprettet af, hvornår, titel og hvad størrelse siden er)
        doc.addCreator("Bejerholm Stenhuggeri");
        doc.addCreationDate();
        doc.addTitle("Bejerholm Stenhuggeri faktura nr. "+faktura.getFaktura_nr());
        doc.setPageSize(PageSize.A4);

        doc.open();
        PdfContentByte cb = docWriter.getDirectContent();

        BaseFont.

    }

}
