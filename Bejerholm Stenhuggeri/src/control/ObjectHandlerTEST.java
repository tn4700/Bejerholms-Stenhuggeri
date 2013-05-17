/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Faktura;
import model.Ordre;
import model.Tegntype;
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
            DBConnection db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "1234");
            DatabaseObjectHandler dbhandler = new DatabaseObjectHandler(db);
            
            Ordre ordre = dbhandler.getOrdre("00001");
            System.out.println(ordre);
            
            Faktura faktura = dbhandler.getFaktura("0020332836-00001");
            System.out.println(faktura);
            
            
            dbhandler.createTegntype("Anettes tegntype", 152);
            
            Tegntype tegntype = dbhandler.getTegntype(15);
            System.out.println(tegntype);
            
        } catch (SQLException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectHandlerTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
