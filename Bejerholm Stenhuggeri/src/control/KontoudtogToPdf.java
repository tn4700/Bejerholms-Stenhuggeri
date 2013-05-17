/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import model.*;

/**
 *
 * @author Oliver
 */
public class KontoudtogToPdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Opretter Timestamp med tiden lige nu
        Date date = new Date();
        Timestamp currentTime = new Timestamp(date.getTime());
        
        //Opretter diverse objekter der er brug for, for at lave et faktura objekt
        Postnummer postnummer = new Postnummer(4700, "Næstved");
        Kunde kunde = new Kunde("Niklas", "Renner", "Gottliebsvej 7", 53545733, postnummer);
        Ordre ordre = new Ordre("00001", true, currentTime, currentTime, "bemærkning", "Leveringsvej 45", "Kirkegården", 13, "Hans afdødesen", 1, 1, 0, true, kunde);

        //Varelinjer til ordren oprettes
        Vare_linje vl1 = null;
        Vare_linje vl2 = null;
        Vare_linje vl3 = null;
        Vare_linje vl4 = null;
        Vare_linje vl5 = null;
        Vare_linje vl6 = null;
        Vare_linje vl7 = null;
        Vare_linje vl8 = null;
        Vare_linje vl9 = null;
        Vare_linje vl10 = null;

        //Varelinjer sættes ind i arrayliste og bliver indsat i ordre objektet
        ArrayList<Vare_linje> vlr = new ArrayList();
        vlr.add(vl1);
        vlr.add(vl2);
        vlr.add(vl3);
        vlr.add(vl4);
        vlr.add(vl5);
        vlr.add(vl6);
        vlr.add(vl7);
        vlr.add(vl8);
        vlr.add(vl9);
        vlr.add(vl10);
        ordre.setVare_linjeListe(vlr);

        //Faktura_nr metode
        String faktura_nr = "00" + kunde.getTlf() + "-" + ordre.getOrdre_nr();

        //Faktura oprettes
        
        Faktura faktura = new Faktura(faktura_nr, currentTime, "Torsten vedrørendesen", "Netto 7 dage", currentTime, "Faktureringsvej 15", true, false, ordre, null);
        Samarbejdspartner bedemand = new Samarbejdspartner("Firmanavn", "Adresse", 12345678, 123456, 6070, 4825318, "Boss Banken", postnummer);
        faktura.setBedemand(bedemand);
        Kontoudtog kontoudtog = new Kontoudtog(123, currentTime, "Vedrørende", currentTime, faktura);
        
         try {
            OpretKontoudtog opretKontoudtog = new OpretKontoudtog(faktura,kontoudtog);
            opretKontoudtog.genererFaktura("test1.pdf");

            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/test1.pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex){
            System.out.println("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

        
        // TODO code application logic here
    }
}
