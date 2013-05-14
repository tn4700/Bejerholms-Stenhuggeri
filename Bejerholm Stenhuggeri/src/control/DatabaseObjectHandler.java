/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kunde;
import model.Postnumre;

/**
 *
 * @author Anette
 */
public class DatabaseObjectHandler {
    private DBConnection db;
    
    public DatabaseObjectHandler(DBConnection db){
        this.db = db;
    }
    
     public ArrayList getPostnumre() throws SQLException {
        ArrayList<Postnumre> postnummerArray = new ArrayList<Postnumre>();
        String sql = "select post_nr, by from postnumre";

        ResultSet rs;
        rs = db.getData(sql);

        while (rs.next()) {
            Postnumre postnr = new Postnumre(
                    rs.getInt("post_nr"),
                    rs.getString("byNavn"));
            postnummerArray.add(postnr);
        }
        return postnummerArray;
    }

    
    
    public Kunde getKunde(int tlf) throws SQLException {
        Kunde kunde = null;
        ResultSet rs;
//        Mangler at tilknytte postnummer
        String sql = "select fornavn, efternavn, adresse, tlf, post_nr from Kunde where tlf =" + tlf;
        


//        try {
//            rs = db.getData(sql);
//            if (rs.next()) {
//                kunde = new Kunde(
//                        rs.getString("fornavn"),
//                        rs.getString("efternavn"),
//                        rs.getString("adresse"),
//                        rs.getInt("tlf"),
//                        postnr);
//                rs.close();
//            }
//        }catch(Exception e){
//            System.out.println("fejl: "+e);
//        }
        return kunde;
    }
}
