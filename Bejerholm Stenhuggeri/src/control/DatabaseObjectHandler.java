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
        String sql = "select post_nr, by from postnummer";

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

        String sql = "select kunde.post_nr, kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf "
                + "from kunde inner join postnummer on postnummer.post_nr = kunde.post_nr where kunde.tlf=" + tlf;

        try {
            rs = db.getData(sql);


            if (rs.next()) {
                postnr = new Postnummer(
                        rs.getInt("post_nr"),
                        rs.getString("byNavn"));
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
