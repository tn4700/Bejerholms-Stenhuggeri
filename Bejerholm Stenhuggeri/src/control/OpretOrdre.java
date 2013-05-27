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
import java.util.ArrayList;
import model.Inskription;
import model.Inskription_linje;
import model.Ordre;
import model.Vare_linje;

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
        String navn = ordre.getKunde().getFornavn() + " " + ordre.getKunde().getEfternavn();
        createContent(cb, tFont, 12, black, 29, 624, navn, left);
        String adresse = ordre.getKunde().getAdresse();
        createContent(cb, tFont, 12, black, 29, 604, adresse, left);
        String postnrby = ordre.getKunde().getPost_nr().getPost_nr() + " " + ordre.getKunde().getPost_nr().getByNavn();
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
        createContent(cb, btFont, 12, black, 571, 624, Utility.formatTimestampToString(ordre.getOrdredato()), right);
        String tlf = ordre.getKunde().getTlf() + "";
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
        createContent(cb, btFont, 12, black, 389, 544, "Kirkegård", left);
        createContent(cb, btFont, 12, black, 389, 524, "Afdeling", left);
        createContent(cb, btFont, 12, black, 389, 504, "Række + Nr.", left);
        cb.rectangle(385, 500, 190, 60);
        cb.moveTo(385, 560);
        cb.lineTo(575, 560);
        cb.moveTo(385, 540);
        cb.lineTo(575, 540);
        cb.moveTo(385, 520);
        cb.lineTo(575, 520);
        cb.moveTo(475, 560);
        cb.lineTo(475, 500);
        cb.moveTo(475, 120);
        cb.lineTo(575, 120);
        cb.moveTo(475, 100);
        cb.lineTo(575, 100);
        cb.moveTo(475, 80);
        cb.lineTo(575, 80);
        cb.moveTo(475, 78);
        cb.lineTo(575, 78);
        cb.stroke();

        //Indsæt data til info-tabeller
        if (ordre.getOrdretype()) {
            createContent(cb, tFont, 12, black, 150, 544, "" + 1, center);
            cb.rectangle(125, 520, 50, 20);
            cb.fill();
        } else {
            cb.rectangle(125, 540, 50, 20);
            cb.fill();
            createContent(cb, tFont, 12, black, 150, 524, "X", center);
        }
        if (ordre.getGravType()) {
            createContent(cb, tFont, 12, black, 150, 504, "Kiste", center);
        } else {
            createContent(cb, tFont, 12, black, 150, 504, "Urne", center);
        }
        if (!ordre.getOrdretype()) {
            createContent(cb, tFont, 12, black, 330, 544, Utility.formatTimestampToString(ordre.getAfhentningsdato()), center);
        } else {
            cb.rectangle(280, 540, 100, 20);
            cb.fill();
        }
        if (ordre.getOrdretype()) {
            createContent(cb, tFont, 12, black, 330, 524, Utility.formatTimestampToString(ordre.getLeveringsdato()), center);
        } else {
            cb.rectangle(280, 520, 100, 20);
            cb.fill();
        }
        if (ordre.getKirkegård() != null) {
            createContent(cb, tFont, 12, black, 525, 544, ordre.getKirkegård(), center);
        }
        if (ordre.getAfdeling() != 0) {
            createContent(cb, tFont, 12, black, 525, 524, "" + ordre.getAfdeling(), center);
        }
        if (ordre.getNummer() != 0 && ordre.getRække() != 0) {
            String rk_nr = "Ræ. " + ordre.getRække() + " Nr. " + ordre.getNummer();
            createContent(cb, tFont, 12, black, 525, 504, rk_nr, center);
        }

        //Indsættelse af inskriptions-overskrift
        createContent(cb, btFont, 12, black, 300, 484, "Inskription:", center);

        //Indsættelse af inskriptions-tekst
        ArrayList<Inskription_linje> inskription_linje_liste = null;
        Inskription inskription = null;
        for (int i = 0; i < ordre.getVare_linjeListe().size(); i++) {
            if (ordre.getVare_linjeListe().get(i).getInskription() != null) {
                inskription_linje_liste = ordre.getVare_linjeListe().get(i).getInskription().getInskription_linje_liste();
                inskription = ordre.getVare_linjeListe().get(i).getInskription();
            }
        }
        int inskriptionY = 454;
        if (inskription_linje_liste == null) {
            createContent(cb, infoFont, 14, black, 300, 464, "ingen inskription", center);
        } else {
            for (int i = 0; i < inskription_linje_liste.size(); i++) {
                if (inskription_linje_liste.get(i).getLinje_type() == 1) {
                    createContent(cb, infoFont, 14, black, 300, inskriptionY, inskription_linje_liste.get(i).getInskription(), center);
                } else if (inskription_linje_liste.get(i).getLinje_type() == 2) {
                    createContent(cb, infoFont, 14, red, 300, inskriptionY, inskription_linje_liste.get(i).getInskription(), center);
                } else if (inskription_linje_liste.get(i).getLinje_type() == 3) {
                    createContent(cb, infoFont, 14, black, 300, inskriptionY, "(PLADS)", center);
                } else {
                }
                inskriptionY -= 20;
            }
        }
        
        //Indsættelse af skrifttype linje
        createContent(cb, btFont, 12, black, 425, 344, "Skrifttype:", center);
        if(inskription!=null){
        createContent(cb, tFont, 12, black, 525, 344, inskription.getSkrifttype(), center);
        }
        
        //Tegn tabel
        cb.rectangle(25, 140, 550, 200);
        int tabelY = 320;
        for (int i = 1; i < 11; i++) {
        cb.moveTo(25, tabelY);
        cb.lineTo(575, tabelY);
        tabelY -= 20;
        }
        cb.moveTo(100, 340);
        cb.lineTo(100, 140);
        cb.moveTo(475, 340);
        cb.lineTo(475, 140);
        cb.stroke();

        //Indsæt navne på tabel elementer
        createContent(cb, btFont, 12, black, 63, 324, "Antal:", center);
        createContent(cb, btFont, 12, black, 287, 324, "Vare:", center);
        createContent(cb, btFont, 12, black, 525, 324, "Pris:", center);
        createContent(cb, tFont, 12, black, 110, 144, "Miljøafgift 2,5%", left);
        createContent(cb, btFont, 12, black, 465, 124, "Pris", right);
        createContent(cb, btFont, 12, black, 465, 104, "Moms(25%)", right);
        createContent(cb, btFont, 12, black, 465, 84, "Total", right);

        //Indsæt data for varelinjer
        int tmpY = 304;
        int antal = 0;
        double enhedsPris = 0;
        double pris = 0;
        double total = 0;
        String beskrivelse = "";
        
        for(int i=0; i<ordre.getVare_linjeListe().size(); i++){
            Vare_linje vare_linje = ordre.getVare_linjeListe().get(i);
            
            if(vare_linje.getVare()!=null){
                beskrivelse = vare_linje.getVare().getNavn();
                antal = 1;
                enhedsPris = vare_linje.getVare().getSalgspris();
            } else if(vare_linje.getInskription()!=null){
                antal = vare_linje.getInskription().getAntalTegn();
                enhedsPris = vare_linje.getInskription().getTegntype().getPris_pr_tegn();
                beskrivelse = vare_linje.getInskription().getTegntype().getNavn();
            } else if(vare_linje.getTom_linje()!=null){
                beskrivelse = vare_linje.getTom_linje().getNavn();
                antal = vare_linje.getTom_linje().getAntal();
                enhedsPris = vare_linje.getTom_linje().getPris();
            }  
            pris = antal*enhedsPris;
            total += pris;
            
            createContent(cb, tFont, 12, black, 63, tmpY, ""+antal, center);
            createContent(cb, tFont, 12, black, 110, tmpY, beskrivelse, left);
            createContent(cb, tFont, 12, black, 465, tmpY, ""+Utility.formatDoubleToKr(enhedsPris), right);
            createContent(cb, tFont, 12, black, 565, tmpY, ""+Utility.formatDoubleToKr(pris), right);
            
            tmpY = tmpY - 20;
        }
        createContent(cb, tFont, 12, black, 565, 144, ""+Utility.formatDoubleToKr(Math.floor(total*+0.025)), right);
        total += Math.floor((total*0.025));
        createContent(cb, tFont, 12, black, 565, 124, ""+Utility.formatDoubleToKr(total), right);
        createContent(cb, tFont, 12, black, 565, 104, ""+Utility.formatDoubleToKr(total*0.25), right);
        total += (total*0.25);
        total = Math.floor(total+0.5);
        createContent(cb, tFont, 12, black, 565, 84, ""+Utility.formatDoubleToKr(total), right);
        
        //Indsættelse af bemærkning tabel
        createContent(cb, btFont, 12, black, 29, 64, "Bemærkninger:", left);
        cb.rectangle(25, 20, 550, 40);
        cb.stroke();
        
        //Indsættelse af bemærkninger
        createContent(cb, tFont, 12, black, 29, 44, ordre.getBemærkning(), left);
        createContent(cb, tFont, 12, black, 29, 24, ordre.getBemærkning_ekstra(), left);

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
