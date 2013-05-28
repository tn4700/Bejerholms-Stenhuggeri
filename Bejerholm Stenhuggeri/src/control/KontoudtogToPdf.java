/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.DocumentException;
import control.exceptions.ControlException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import model.*;

/**
 *
 * @author Oliver
 */
public class KontoudtogToPdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ControlException {
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
       
        try {
            faktura = dbhandler.getFaktura("0028931093-00004");
      
            
        } catch (SQLException ex) {
            System.out.println("Fedsadjl: " +ex);
        }


        
   


        try {
        
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