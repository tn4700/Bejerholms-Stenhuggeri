/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.DocumentException;
import control.exceptions.ControlException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import model.*;

/**
 *
 *
 * @author Anette Stidsing
 */
public class ObjectHandlerTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            //Opret connection til DB
            DBConnection db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");
            DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
            
            //Timestamp til tiden nu
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            
            //Opret kunde
            Postnummer pn = dbhandler.getPostnummer(4700);
            Kunde k = new Kunde("Morten", "Hansen", "Georgevej 23", 88888888, pn);

            //Opret Ordre
            Ordre ordre = new Ordre(null,true,ts,ts,ts,"Giver ikke en fuck","Ikke en","En stor kirkegård",
                    1,"Mor",1,1,true,k, null);
            
            //Opret vare
            Varegruppe vg = dbhandler.getVareGruppe(1);
            Vare v = new Vare(0,"TestVare 1",56,23,0.50,50.50,"Pas","Ru",false,0,vg);
            dbhandler.createVare(v);
            Vare test = dbhandler.getVare(dbhandler.getMaxVareNr());

            //Opret Inskription
            Tegntype tt = dbhandler.getTegntype(1);
            Inskription inskription = new Inskription(null, tt, 0, "Verdana");
            inskription.addInskription_linje(new Inskription_linje(1, 0, 2, "Niklas Renner Nielsen"));
            inskription.addInskription_linje(new Inskription_linje(2, 0, 2, "2000-2001"));
            inskription.addInskription_linje(new Inskription_linje(3, 0, 1, "Mor"));
            inskription.addInskription_linje(new Inskription_linje(4, 0, 1, "1395-1340"));
            inskription.addInskription_linje(new Inskription_linje(5, 0, 2, "Hvil i fred"));
            
            //Opret tom linje
            Tom_linje tl = new Tom_linje("Fixet noget", 22.50, 1, 0);
            
            //Opret vare_linjer
            ordre.addVare_linje(new Vare_linje(1, null, test, null, null));
            ordre.addVare_linje(new Vare_linje(2, null, null, inskription, null));
            ordre.addVare_linje(new Vare_linje(3, null, null, null, tl));
            
            //Opret ordre i databasen
            String ordre_nr = dbhandler.getNextOrdreNr();
            dbhandler.createOrdre(ordre);
            ordre = dbhandler.getOrdre(ordre_nr);
            System.out.println(ordre);
            
            //Opret bedemand
            Samarbejdspartner bedemand = new Samarbejdspartner("Firma", "adresse", 12345678, 43534545, 2345, "2342342344", "Bank", pn);
            
            //Opret kontoudtog
            Kontoudtog kontoudtog = new Kontoudtog(null, Utility.getCurrentTime(), Utility.getCurrentTime());
            
            //Opret provisionsseddel
            Provisionsseddel provisionsseddel = new Provisionsseddel(null, Utility.getCurrentTime(), kontoudtog);
            
            //Opret faktura
            Faktura faktura = new Faktura(null,
            Utility.getCurrentTime(),
            Utility.getCurrentTime(),
            "Lolvej 7",
            true,
            false,
            ordre,
            bedemand,
            provisionsseddel);
            dbhandler.createFaktura(faktura);
            System.out.println(faktura);
            
            //Opretter ordre pdf
            OpretOrdre opretOrdre = new OpretOrdre(dbhandler.getOrdre(ordre_nr));
            opretOrdre.genererOrdre("OrdreTest.pdf");
            
            
            //Åbner ordre pdf
            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/OrdreTest.pdf");
            desktop.open(file);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        } catch (ControlException ex) {
            ex.printStackTrace();
        }

    }
}
