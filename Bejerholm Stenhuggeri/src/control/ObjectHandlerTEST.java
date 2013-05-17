/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Inskription;
import model.Kunde;
import model.Ordre;
import model.Samarbejdspartner;
import model.Tegntype;
import model.Tom_linje;
import model.Vare;
import model.Vare_linje;
import model.Varegruppe;

/**
 *
 * @author Anette Stidsing
 */
public class ObjectHandlerTEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DBConnection db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");
            System.out.println("" + db.isConnected());
            DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
            
//            Kunde kunde = dbhandler.getKunde(28931093);
//            System.out.println(kunde.getFornavn()+" "+kunde.getEfternavn()+" "+kunde.getTlf()+" "+kunde.getAdresse()+" "+kunde.getPost_nr().getPost_nr()+" "+kunde.getPost_nr().getByNavn());
//                    
//             Samarbejdspartner partner = dbhandler.getSamarbejdspartner(12943790);
//            System.out.println(partner.getFirmanavn()+" "+partner.getAdresse()+" "+partner.getBank()+" "+partner.getRegistrerings_nr()+" "+partner.getPost_nr().getPost_nr()+" "+partner.getPost_nr().getByNavn());  
//            
//            ArrayList<Vare> vareListe = dbhandler.getVareListe();
//            System.out.println(vareListe);
//            
//            Inskription inskription = dbhandler.getInskription(2);
//            System.out.println(inskription);
            
            Vare vare = dbhandler.getVare(1);
            System.out.println(vare);
       
            Vare_linje varelinje = dbhandler.getVareLinje(1, "00001");
            System.out.println(varelinje);
            
            Inskription inskription = dbhandler.getInskription(2);
            System.out.println(inskription);
            
            Ordre ordre = dbhandler.getOrdre("00001");
            System.out.println(ordre);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
