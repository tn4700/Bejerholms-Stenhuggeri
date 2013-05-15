/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kunde;
import model.Samarbejdspartner;

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
            DBConnection db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "1234");
            System.out.println("" + db.isConnected());
            DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
            
            Kunde kunde = dbhandler.getKunde(28931093);
            System.out.println(kunde.getFornavn()+" "+kunde.getEfternavn()+" "+kunde.getTlf()+" "+kunde.getAdresse()+" "+kunde.getPost_nr().getPost_nr()+" "+kunde.getPost_nr().getByNavn());
                    
             Samarbejdspartner partner = dbhandler.getSamarbejdspartner(12943790);
            System.out.println(partner.getFirmanavn()+" "+partner.getAdresse()+" "+partner.getBank()+" "+partner.getRegistrerings_nr()+" "+partner.getPost_nr().getPost_nr()+" "+partner.getPost_nr().getByNavn());  
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
