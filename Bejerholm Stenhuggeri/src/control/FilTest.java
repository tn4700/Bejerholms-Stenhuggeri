/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Timestamp;
import java.util.Date;
import model.Faktura;
import model.Kunde;
import model.Ordre;
import model.Postnumre;

/**
 *
 * @author NiklasRenner
 */
public class FilTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Opretter Timestamp med tiden lige nu
        Date date = new Date();
        Timestamp currentTime = new Timestamp(date.getTime());

        //Opretter diverse objekter der er brug for, for at lave et faktura objekt
        Postnumre postnummer = new Postnumre(4700, "Næstved");
        Kunde kunde = new Kunde("Niklas", "Renner", "Gottliebsvej 7", 53545733, postnummer);
        Ordre ordre = new Ordre(000001, true, currentTime, currentTime, "bemærkning", "Leveringsvej 45", "Kirkegården", 13, "Hans Afdødesen", 1, 1, 0, true, kunde);
        
        //Faktura_nr metode
        String faktura_nr = "00"+kunde.getTlf()+"-"+ordre.getOrdre_nr();
        
        //Faktura oprettes
        Faktura faktura = new Faktura(faktura_nr, currentTime, "Torsten vedrørendesen", "betalingsbetingelser", currentTime, "Faktureringsvej 15", true, false, ordre, null);
        
        //Faktura laves til pdf
        OpretFaktura opretFaktura = new OpretFaktura(faktura);
        opretFaktura.genererFaktura("test.pdf");

    }
}
