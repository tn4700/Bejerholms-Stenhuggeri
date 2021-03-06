/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vare;
import model.Varegruppe;

/**
 *
 * @author Oliver
 */
public class OpretRevisorSeddel {

 
    DatabaseObjectHandler dbhandler;
    private BaseFont tFont;
    //Skrift til fed alm. tekst
    private BaseFont btFont;
    //Skrift til info om virksomheden
    private BaseFont infoFont;
    //Skrift til fed into om virksomheden
    private BaseFont binfoFont;
    private int år;
    private String dato;

    public OpretRevisorSeddel(String dato,int år, DatabaseObjectHandler dbhandler) {
        this.år = år;
        this.dato = dato;
        this.dbhandler = dbhandler;
    }

    public void genererRevisorseddel(String filNavn) throws IOException, DocumentException {
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
        doc.addTitle("Bejerholm Stenhuggeri Lageropgørelsee");
        doc.setPageSize(PageSize.LETTER);

//Start skrivning af dokument
        doc.open();
        PdfContentByte cb = docWriter.getDirectContent();

        //Sæt Logo ind og faktura overskrift
        createContent(cb, btFont, 28, lightblue, 25, 725, "Lageropgørelse", left);
        createContent(cb, btFont, 18, black, 35, 700, "For året " + år, left);
         createContent(cb, infoFont, 11, black, 35, 510, "Opgjort den " + dato, left);

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





        //Tegn tabel
        cb.rectangle(25, 200, 550, 300);
        // Denne linje er under overskrfterne
        cb.moveTo(25, 480);
        cb.lineTo(575, 480);
        // Den her er varegruppe boksen
        cb.moveTo(275, 500);
        cb.lineTo(275, 200);
        // det her er antal varer
        cb.moveTo(375, 500);
        cb.lineTo(375, 200);
        cb.moveTo(475, 500);
        cb.lineTo(475, 200);



        cb.stroke();
        int x = 464;
        ArrayList<Varegruppe> grupper = new ArrayList();
        ArrayList<Vare> vare = new ArrayList();
        //Indsæt navne på tabel elementer
        createContent(cb, btFont, 12, black, 150, 484, "Varegruppe", center);
        createContent(cb, btFont, 12, black, 325, 484, "Antal varer", center);
        createContent(cb, btFont, 12, black, 425, 484, "Købspris", center);
        createContent(cb, btFont, 12, black, 525, 484, "Salgspris", center);
        try {
            grupper = dbhandler.getVaregruppeListe();
        } catch (SQLException ex) {
            System.out.println("Der skete en fejl ved udtræk af maxvaregrp" + ex);
        }

        for (int i = 0; i < grupper.size(); i++) {

            double grupværdi = 0;
            double grupværdi1 = 0;
            try {
                vare = dbhandler.getVareListe(grupper.get(i).getGrp_nr());
            } catch (SQLException ex) {
                Logger.getLogger(OpretRevisorSeddel.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int j = 0; j < vare.size(); j++) {
                grupværdi = grupværdi + vare.get(j).getIndkøbspris();
                grupværdi1 = grupværdi1 + vare.get(j).getSalgspris();

            }

            createContent(cb, tFont, 12, black, 110, x,  grupper.get(i).getNavn(), left);
            createContent(cb, tFont, 12, black, 330, x, "" + vare.size(), center);
            createContent(cb, tFont, 12, black, 465, x, "" + NumberFormat.getCurrencyInstance().format(grupværdi), right);
            createContent(cb, tFont, 12, black, 565, x, "" + NumberFormat.getCurrencyInstance().format(grupværdi1), right);
            x = x - 20;
        }


        doc.close();
    }

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

    private void initializeFonts() throws DocumentException, IOException {
        btFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        tFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        binfoFont = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        infoFont = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
    }
}
