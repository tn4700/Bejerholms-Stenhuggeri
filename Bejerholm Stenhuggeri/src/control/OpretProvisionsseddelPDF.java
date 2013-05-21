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
import java.util.Date;
import model.Faktura;
import model.Kunde;
import model.Ordre;
import model.Postnummer;
import model.Provisionsseddel;
import model.Samarbejdspartner;

/**
 *
 * @author Anette Stidsing
 */
public class OpretProvisionsseddelPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
                  //Opretter Timestamp med tiden lige nu
        Date date = new Date();
        Timestamp currentTime = new Timestamp(date.getTime());
        
        //Opretter diverse objekter der er brug for, for at lave et faktura objekt
        Postnummer postnummer = new Postnummer(4700, "Næstved");
        Kunde kunde = new Kunde("Niklas", "Renner", "Gottliebsvej 7", 53545733, postnummer);
        Ordre ordre = new Ordre("00001", true, currentTime, currentTime, "bemærkning","Ekstra bemærkning", "Leveringsvej 45", "Kirkegården", 13, "Hans afdødesen", 1, 1, 0, true, kunde);
        //Faktura_nr metode
        String faktura_nr = "00" + kunde.getTlf() + "-" + ordre.getOrdre_nr();

        //Faktura oprettes
        
        Faktura faktura = new Faktura(faktura_nr, currentTime, "Torsten vedrørendesen", currentTime, "Faktureringsvej 15", true, false, ordre, null);
        Samarbejdspartner bedemand = new Samarbejdspartner("Bedemand Jensen", "Bellisvej 1", 12345678, 123456, 6070, 4825318, "Danske Bank", postnummer);
        faktura.setBedemand(bedemand);
        
        Provisionsseddel provisionsseddel = new Provisionsseddel(11, currentTime, faktura_nr, "Dags Dato", faktura);
        
         try {
            OpretProvisionsseddel opretKontoudtog = new OpretProvisionsseddel(faktura, provisionsseddel);
            opretKontoudtog.genererProvisionsseddel("test1.pdf");

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

    }
    }

