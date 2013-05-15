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
            DBConnection db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "1234");
            System.out.println("" + db.isConnected());
            DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
            
            Kunde kunde = dbhandler.getKunde(28931093);
            System.out.println(kunde.getFornavn()+" "+kunde.getEfternavn()+" "+kunde.getTlf()+" "+kunde.getAdresse()+" "+kunde.getPost_nr().getPost_nr()+" "+kunde.getPost_nr().getByNavn());
                    
             Samarbejdspartner partner = dbhandler.getSamarbejdspartner(12943790);
            System.out.println(partner.getFirmanavn()+" "+partner.getAdresse()+" "+partner.getBank()+" "+partner.getRegistrerings_nr()+" "+partner.getPost_nr().getPost_nr()+" "+partner.getPost_nr().getByNavn());  
            
            ArrayList<Kunde> kundeliste = dbhandler.getKundeListe();
            System.out.println(kundeliste);
            
            ArrayList<Tom_linje> tomlinjeliste = dbhandler.getTomLinjeListe();
            System.out.println(tomlinjeliste);
            
            ArrayList<Tegntype> tegntypeliste = dbhandler.getTegntypeListe();
            System.out.println(tegntypeliste);
            
            ArrayList<Inskription> inskriptionliste = dbhandler.getInskriptionListe();
            System.out.println(inskriptionliste);
            
            ArrayList<Varegruppe> varegrpListe = dbhandler.getVareGruppeListe();
            System.out.println(varegrpListe);
            
            ArrayList<Vare> vareListe = dbhandler.getVareListe();
            System.out.println(vareListe);
            
            ArrayList<Vare_linje> vareLinjeListe = dbhandler.getVareLinjeListe(tomlinjeliste, vareListe, inskriptionliste);
            for (int i = 0; i < vareLinjeListe.size(); i++) {
                System.out.println(vareLinjeListe.get(i));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
