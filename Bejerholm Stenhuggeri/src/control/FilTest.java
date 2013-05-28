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
import model.Faktura;
/**
 *
 * @author NiklasRenner
 */
public class FilTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DBConnection db = null;
        Faktura faktura = null;
        
        try {
        db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");
        DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
        faktura = dbhandler.getFaktura("0020332836-00001");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ExportToCSV.export(db);
            
            OpretFaktura opretFaktura = new OpretFaktura(faktura);
            opretFaktura.genererFaktura("FakturaTest.pdf");

            OpretOrdre opretOrdre = new OpretOrdre(faktura.getOrdre());
            opretOrdre.genererOrdre("OrdreTest.pdf");

            double tmp = faktura.getOrdre().getTotal();
            System.out.println("Total: "+tmp);
            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/OrdreTest.pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
