/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kunde;
import model.Postnummer;

/**
 *
 * @author Anette
 */
public class DatabaseObjectHandler {

    private DBConnection db;

    public DatabaseObjectHandler(DBConnection db) {
        this.db = db;
    }

    public ArrayList getPostnumre() throws SQLException {
        ArrayList<Postnummer> postnummerArray = new ArrayList<Postnummer>();
        String sql = "select post_nr, by from postnumre";

        ResultSet rs;
        rs = db.getData(sql);

        while (rs.next()) {
            Postnummer postnr = new Postnummer(
                    rs.getInt("post_nr"),
                    rs.getString("byNavn"));
            postnummerArray.add(postnr);
        }
        return postnummerArray;
    }



    public Kunde getKunde(int tlf) throws SQLException {
        Kunde kunde = null;
        Postnummer postnr = null;

        ResultSet rs;
        ResultSet rs2;

        String sql = "select fornavn, efternavn, adresse, tlf, post_nr from Kunde where tlf =" + tlf;
        String sql2 = "select kunde.post_nr from kunde inner join postnummer.post_nr where kunde.tlf=" + tlf;
        
        try {

            rs = db.getData(sql);
            rs2 = db.getData(sql2);
           

            if (rs.next()) {
                postnr = new Postnummer(
                        rs2.getInt("post_nr"),
                        rs2.getString("byNavn"));
                kunde = new Kunde(
                        rs.getString("fornavn"),
                        rs.getString("efternavn"),
                        rs.getString("adresse"),
                        rs.getInt("tlf"),
                        postnr);
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("fejl: " + e);
        }
        return kunde;
    }

    
    
}
