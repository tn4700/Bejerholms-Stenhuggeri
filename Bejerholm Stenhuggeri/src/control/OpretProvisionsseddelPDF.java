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

import model.Faktura;
import model.Provisionsseddel;


/**
 *
 * @author Anette Stidsing
 */
public class OpretProvisionsseddelPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DBConnection db = null;
            try {
            db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "1234");
        } catch (Exception e) {
        }
        DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
        
        Faktura faktura = null;
        Provisionsseddel provisionsseddel = null;
        try {
            faktura = dbhandler.getFaktura("0028931093-00004");
            provisionsseddel = dbhandler.getProvisionsseddel("00004");
        } catch (Exception e) {
        }
        
         try {
            OpretProvisionsseddel opretProvisionsseddel = new OpretProvisionsseddel(faktura, provisionsseddel);
            opretProvisionsseddel.genererProvisionsseddel("testp.pdf");

            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/testp.pdf");
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

