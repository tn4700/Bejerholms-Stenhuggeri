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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        DBConnection db = null;
        
      
        try {
            db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("fejl: " + ex);
        }
        DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
        



        //Opretter diverse objekter der er brug for, for at lave et faktura objekt
        Postnummer postnummer = new Postnummer(4700, "Næstved");
        Kunde kunde = new Kunde("Niklas", "Renner", "Gottliebsvej 7", 53545733, postnummer);
        Faktura faktura = null;
        System.out.println("d");
        try {
            faktura = dbhandler.getFaktura("0028931093-00004");
            System.out.println("Faktura " + faktura);
            System.out.println("gejl");
           // System.out.println("Provision " + faktura.getProvisionsseddel().getProvisions_nr() + " - Kontoutog" + faktura.getProvisionsseddel().getProvisions_nr());
            
        } catch (SQLException ex) {
            System.out.println("Fejl: " +ex);
        }


        
   
        Kontoudtog kontoudtog = new Kontoudtog("123", Utility.getCurrentTime(), Utility.getCurrentTime());
         Provisionsseddel prov = new Provisionsseddel("123", Utility.getCurrentTime(), kontoudtog);
         faktura.setProvisionsseddel(prov);

        faktura.getProvisionsseddel().setKontoudtog(kontoudtog);

        try {
            System.out.println("asd");
            OpretKontoudtog opretKontoudtog = new OpretKontoudtog(faktura);
            opretKontoudtog.genererFaktura("test1.pdf");

            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/test1.pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }


        // TODO code application logic here
    }
}