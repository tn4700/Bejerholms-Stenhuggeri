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
import model.Faktura;
import model.Kunde;
import model.Ordre;
import model.Postnummer;
import model.Vare_linje;

/**
 *
 * @author NiklasRenner
 */
public class FilTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Faktura faktura = null;
        try {
        DBConnection db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");
        DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
        faktura = dbhandler.getFaktura("0020332836-00001");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
                //Faktura laves til pdf
        try {
            OpretFaktura opretFaktura = new OpretFaktura(faktura);
            opretFaktura.genererFaktura("FakturaTest.pdf");

            //OpretOrdre opretOrdre = new OpretOrdre(faktura.getOrdre);
            //opretOrdre.genererOrdre("OrdreTest.pdf");

            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/FakturaTest.pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

    }
}
