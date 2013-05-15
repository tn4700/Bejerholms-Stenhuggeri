/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Inskription;
import model.Kunde;
import model.Ordre;
import model.Postnummer;
import model.Samarbejdspartner;
import model.Tegntype;
import model.Tom_linje;

/**
 *
 * @author Anette
 */
public class DatabaseObjectHandler {

    private DBConnection db;

    public DatabaseObjectHandler(DBConnection db) {
        this.db = db;
    }

    public ArrayList getPostnummerListe() throws SQLException {
        ArrayList<Postnummer> postnummerArray = new ArrayList<>();
        String sql = "select post_nr, by from postnummer";

        ResultSet rs;
        rs = db.getData(sql);

        while (rs.next()) {
            Postnummer postnr = new Postnummer(
                    rs.getInt("post_nr"),
                    rs.getString("byNavn"));
            postnummerArray.add(postnr);
        }rs.close();
        return postnummerArray;
    }

    public ArrayList getKundeListe() throws SQLException {
        ArrayList<Kunde> kundeArray = new ArrayList<>();
        String sql = "select kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf, kunde.post_nr, postnummer.bynavn from kunde join postnummer "
                + "on postnummer.post_nr = kunde.post_nr";
        ResultSet rs;
        rs = db.getData(sql);
        
        while(rs.next()){
            Postnummer postnr = new Postnummer(rs.getInt("post_nr"), rs.getString("bynavn"));
            Kunde kunde = new Kunde(rs.getString("fornavn"), rs.getString("efternavn"), rs.getString("Adresse"), rs.getInt("tlf"), postnr);
            kundeArray.add(kunde);
        }rs.close();
                
        return kundeArray;

    }

    public Kunde getKunde(int tlf) throws SQLException {
        Kunde kunde = null;
        
        String sql = "select kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf, kunde.post_nr, postnummer.bynavn "
                + "from kunde join postnummer on postnummer.post_nr = kunde.post_nr where kunde.tlf = " + tlf;
        ResultSet rs;
        
        try {
            rs = db.getData(sql);
            if (rs.next()) {
                Postnummer postnr = new Postnummer(
                        rs.getInt("post_nr"),
                        rs.getString("byNavn"));
                kunde = new Kunde(
                        rs.getString("fornavn"),
                        rs.getString("efternavn"),
                        rs.getString("adresse"),
                        rs.getInt("tlf"),
                        postnr);
                
            }rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kunde;
    }
    
    public Samarbejdspartner getSamarbejdspartner(int cvr_nr) throws SQLException{
        Samarbejdspartner partner = null;
        ResultSet rs;
        String sql = "select  samarbejdspartner.firmanavn, samarbejdspartner.adresse, samarbejdspartner.tlf, samarbejdspartner.cvr_nr, "
                + "samarbejdspartner.registrerings_nr, samarbejdspartner.konto_nr, samarbejdspartner.bank, samarbejdspartner.post_nr, postnummer.bynavn "
                + "from samarbejdspartner join postnummer on postnummer.post_nr = samarbejdspartner.post_nr where samarbejdspartner.cvr_nr=" + cvr_nr;
        rs = db.getData(sql);
        try {

            if (rs.next()) {
                Postnummer postnr = new Postnummer(
                        rs.getInt("post_nr"),
                        rs.getString("byNavn"));
                partner = new Samarbejdspartner(
                        rs.getString("firmanavn"),
                        rs.getString("adresse"),
                        rs.getInt("tlf"),
                        rs.getInt("cvr_nr"),
                        rs.getInt("registrerings_nr"),
                        rs.getInt("konto_nr"),
                        rs.getString("bank"),
                        postnr);
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("fejl: " + e);
        }
        return partner;
    }
    
    public ArrayList getTomLinjeListe() throws SQLException{
        ArrayList<Tom_linje> tomlinjeListe = new ArrayList<>();
        String sql = "select navn, pris, antal, kommentar, id from tom_linje";
        ResultSet rs;
        
        rs = db.getData(sql);
        
        while(rs.next()){
            Tom_linje tl = new Tom_linje(
                    rs.getString("navn"),
                    rs.getDouble("pris"), 
                    rs.getInt("antal"), 
                    rs.getString("kommentar"),
                    rs.getInt("id"));
            tomlinjeListe.add(tl);
        
        }
        rs.close();
        return tomlinjeListe;
    }
    
        public ArrayList getTegntypeListe() throws SQLException{
        ArrayList<Tegntype> tegntypeListe = new ArrayList<>();
        String sql = "select navn, pris_pr_tegn, id from tegntype";
        ResultSet rs;
        
        rs = db.getData(sql);
        
        while(rs.next()){
            Tegntype tt = new Tegntype(
                    rs.getString("navn"),
                    rs.getDouble("pris_pr_tegn"), 
                    rs.getInt("id"));
            tegntypeListe.add(tt);
        
        }
        rs.close();
        return tegntypeListe;
    }
        
        public ArrayList getInskriptionListe() throws SQLException{
        ArrayList<Inskription> inskriptionListe = new ArrayList<>();
        String sql = "select inskription.inskription, inskription.tegn_id, inskription.skrifttype, tegntype.navn, "
                + "tegntype.pris_pr_tegn from inskription join tegntype on tegntype.id = inskription.tegn_id";
        ResultSet rs;
        
        rs = db.getData(sql);
        
        while(rs.next()){
            Tegntype tegntype = new Tegntype(
                    rs.getString("navn"),
                    rs.getDouble("pris_pr_tegn"), 
                    rs.getInt("tegn_id"));
            Inskription inskription = new Inskription(
                    rs.getString("inskription"),
                    tegntype, 
                    rs.getInt("tegn_id"),
                    rs.getString("skrifttype"));
            inskriptionListe.add(inskription);
        
        }
        rs.close();
        return inskriptionListe;
    }
       
 
    public Ordre getOrdre(int ordre_nr) throws SQLException{
        Ordre ordre = null;
        ResultSet rs;
        
        
        
        return ordre;
    }
}


