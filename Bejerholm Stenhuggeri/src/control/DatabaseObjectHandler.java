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
import model.Vare;
import model.Vare_linje;
import model.Varegruppe;

/**
 *
 * @author Anette
 */
public class DatabaseObjectHandler {

    private DBConnection db;

    public DatabaseObjectHandler(DBConnection db) {
        this.db = db;
    }

//    public ArrayList getPostnummerListe() throws SQLException {
//        ArrayList<Postnummer> postnummerArray = new ArrayList<>();
//        String sql = "select post_nr, by from postnummer";
//
//        ResultSet rs;
//        rs = db.getData(sql);
//
//        while (rs.next()) {
//            Postnummer postnr = new Postnummer(
//                    rs.getInt("post_nr"),
//                    rs.getString("byNavn"));
//            postnummerArray.add(postnr);
//        }
//        rs.close();
//        return postnummerArray;
//    }

//    public ArrayList getKundeListe() throws SQLException {
//        ArrayList<Kunde> kundeArray = new ArrayList<>();
//        String sql = "select kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf, kunde.post_nr, postnummer.bynavn from kunde join postnummer "
//                + "on postnummer.post_nr = kunde.post_nr";
//        ResultSet rs;
//        rs = db.getData(sql);
//
//        while (rs.next()) {
//            Postnummer postnr = new Postnummer(rs.getInt("post_nr"), rs.getString("bynavn"));
//            Kunde kunde = new Kunde(rs.getString("fornavn"), rs.getString("efternavn"), rs.getString("Adresse"), rs.getInt("tlf"), postnr);
//            kundeArray.add(kunde);
//        }
//        rs.close();
//
//        return kundeArray;
//
//    }

    public Postnummer getPostnummer(int post_nr) throws SQLException {
        Postnummer postnr = null;
        String sql = "select post_nr, bynavn from postnummer where post_nr" + post_nr;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            postnr = new Postnummer(
                    rs.getInt("post_nr"),
                    rs.getString("bynavn"));
            rs.close();
        }
        return postnr;
    }

    public Kunde getKunde(int tlf) throws SQLException {
        Kunde kunde = null;
        int post_nr = 0;
        String sql = "select fornavn, efternavn, adresse, tlf, post_nr from kunde where tlf= " + tlf;
        ResultSet rs;


            rs = db.getData(sql);
            if (rs.next()) {
                kunde = new Kunde(
                        rs.getString("fornavn"),
                        rs.getString("efternavn"),
                        rs.getString("adresse"),
                        rs.getInt("tlf"),
                        null);
                post_nr = rs.getInt("post_nr");
            }
            rs.close();
            kunde.setPost_nr(getPostnummer(post_nr));
        
        return kunde;
    }

    public Samarbejdspartner getSamarbejdspartner(int cvr_nr) throws SQLException {
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

    public Tom_linje getTomLinje(int id) throws SQLException {
        Tom_linje tomlinje = null;
        String sql = "select navn, pris, antal, kommentar, id from tom_linje where id =" + id;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            tomlinje = new Tom_linje(
                    rs.getString("navn"),
                    rs.getDouble("pris"),
                    rs.getInt("antal"),
                    rs.getString("kommentar"),
                    rs.getInt("id"));
        }
        rs.close();
        return tomlinje;
    }

//    public ArrayList getTomLinjeListe() throws SQLException {
//        ArrayList<Tom_linje> tomlinjeListe = new ArrayList<>();
//        String sql = "select navn, pris, antal, kommentar, id from tom_linje";
//        ResultSet rs;
//
//        rs = db.getData(sql);
//
//        while (rs.next()) {
//            Tom_linje tl = new Tom_linje(
//                    rs.getString("navn"),
//                    rs.getDouble("pris"),
//                    rs.getInt("antal"),
//                    rs.getString("kommentar"),
//                    rs.getInt("id"));
//            tomlinjeListe.add(tl);
//
//        }
//        rs.close();
//        return tomlinjeListe;
//    }

    public Tegntype getTegntype(int id) throws SQLException {
        Tegntype tegntype = null;
        String sql = "select navn, pris_pr_tegn, id from tegntype where id=" + id;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            tegntype = new Tegntype(
                    rs.getString("navn"),
                    rs.getDouble("pris_pr_tegn"),
                    rs.getInt("id"));
        }
        rs.close();
        return tegntype;
    }

//    public ArrayList getTegntypeListe() throws SQLException {
//        ArrayList<Tegntype> tegntypeListe = new ArrayList<>();
//        String sql = "select navn, pris_pr_tegn, id from tegntype";
//        ResultSet rs;
//
//        rs = db.getData(sql);
//
//        while (rs.next()) {
//            Tegntype tt = new Tegntype(
//                    rs.getString("navn"),
//                    rs.getDouble("pris_pr_tegn"),
//                    rs.getInt("id"));
//            tegntypeListe.add(tt);
//
//        }
//        rs.close();
//        return tegntypeListe;
//    }
    
     public Inskription getInskription(int id) throws SQLException {
        Inskription inskription = null;
        int tegn_id = 0;
        String sql = "select inskription, id, skrifttype,tegn_id from inskription where id="+id;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
          inskription = new Inskription(
                    rs.getString("inskription"),
                    null,
                    rs.getInt("id"),
                    rs.getString("skrifttype"));
          tegn_id = rs.getInt("tegn_id");
}
        rs.close();
        inskription.setTegntype(getTegntype(tegn_id));
        
        return inskription;
    }

//    public ArrayList getInskriptionListe() throws SQLException {
//        ArrayList<Inskription> inskriptionListe = new ArrayList<>();
//        String sql = "select inskription.inskription, inskription.id, inskription.skrifttype, tegntype.navn, inskription.tegn_id, "
//                + "tegntype.pris_pr_tegn from inskription join tegntype on tegntype.id = inskription.tegn_id";
//        ResultSet rs;
//
//        rs = db.getData(sql);
//
//        while (rs.next()) {
//            Tegntype tegntype = new Tegntype(
//                    rs.getString("navn"),
//                    rs.getDouble("pris_pr_tegn"),
//                    rs.getInt("tegn_id"));
//            Inskription inskription = new Inskription(
//                    rs.getString("inskription"),
//                    tegntype,
//                    rs.getInt("id"),
//                    rs.getString("skrifttype"));
//            inskriptionListe.add(inskription);
//
//        }
//        rs.close();
//        return inskriptionListe;
//    }
public Varegruppe getVareGruppe(int grp_nr) throws SQLException {
        Varegruppe varegruppe = null;
        String sql = "select grp_nr, navn from varegruppe where grp_nr="+grp_nr;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            varegruppe = new Varegruppe(
                    rs.getInt("grp_nr"),
                    rs.getString("navn"));
 
        }
        rs.close();

        return varegruppe;
    }

//    public ArrayList getVareGruppeListe() throws SQLException {
//        ArrayList<Varegruppe> varegruppeListe = new ArrayList<>();
//        String sql = "select grp_nr, navn from varegruppe";
//        ResultSet rs;
//
//        rs = db.getData(sql);
//
//        while (rs.next()) {
//            Varegruppe varegruppe = new Varegruppe(
//                    rs.getInt("grp_nr"),
//                    rs.getString("navn"));
//            varegruppeListe.add(varegruppe);
//
//        }
//        rs.close();
//
//        return varegruppeListe;
//    }
public Vare getVare(int vare_nr) throws SQLException {
        Vare vare = null;
        int grp_nr = 0;
        String sql = "select vare_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn, "
                + "overflade, dekoration, grp_nr from vare where vare_nr="+vare_nr;
        ResultSet rs;
        rs = db.getData(sql);

        if (rs.next()) {
            vare = new Vare(
                    rs.getInt("vare_nr"),
                    rs.getString("navn"),
                    rs.getInt("højde"),
                    rs.getInt("bredde"),
                    rs.getDouble("indkøbspris"),
                    rs.getDouble("salgspris"),
                    rs.getString("typenavn"),
                    rs.getString("overflade"),
                    rs.getBoolean("dekoration"),
                    null);
            grp_nr = rs.getInt("grp_nr");
  }
        rs.close();
        vare.setGruppe(getVareGruppe(grp_nr));
        return vare;
    }


    public ArrayList getVareListe() throws SQLException {
        ArrayList<Vare> vareListe = new ArrayList<>();
        String sql = "select vare.vare_nr, vare.navn, vare.højde, vare.bredde, vare.indkøbspris, vare.salgspris, vare.typenavn, vare.overflade, vare.dekoration, vare.grp_nr, varegruppe.navn from vare join varegruppe on varegruppe.grp_nr = vare.grp_nr";
        ResultSet rs;

        rs = db.getData(sql);

        while (rs.next()) {
            Varegruppe varegruppe = new Varegruppe(
                    rs.getInt("grp_nr"),
                    rs.getString("varegruppe.navn"));
            Vare vare = new Vare(
                    rs.getInt("vare_nr"),
                    rs.getString("navn"),
                    rs.getInt("højde"),
                    rs.getInt("bredde"),
                    rs.getDouble("indkøbspris"),
                    rs.getDouble("salgspris"),
                    rs.getString("typenavn"),
                    rs.getString("overflade"),
                    rs.getBoolean("dekoration"),
                    varegruppe);
            vareListe.add(vare);

        }
        rs.close();
        return vareListe;
    }

    public ArrayList getVareLinjeListe(ArrayList<Tom_linje> tomlinjeliste, ArrayList<Vare> vareliste, ArrayList<Inskription> inskriptionliste) throws SQLException {
        ArrayList<Vare_linje> varelinjeListe = new ArrayList();

        ResultSet rs;
        String sql = "select vare_linje.linje_nr, vare_linje.vare_nr, vare_linje.tom_linje_id, vare_linje.inskription_id, vare_linje.ordre_nr from vare_linje";

        rs = db.getData(sql);

        while (rs.next()) {
            Vare_linje varelinje = null;
            if (rs.getInt("vare_linje.vare_nr") > 0) {
                for (int i = 0; i < vareliste.size(); i++) {
                    if (vareliste.get(i).getVare_nr() == rs.getInt("vare_linje.vare_nr")) {
                        Vare vare = vareliste.get(i);
                        i = vareliste.size() + 1;
                        varelinje = new Vare_linje(rs.getInt("vare_linje.linje_nr"), rs.getString("vare_linje.ordre_nr"), vare);
                    }
                }
            } else if (rs.getInt("vare_linje.tom_linje_id") > 0) {
                for (int i = 0; i < tomlinjeliste.size(); i++) {
                    if (tomlinjeliste.get(i).getId() == rs.getInt("vare_linje.tom_linje_id")) {
                        Tom_linje tomlinje = tomlinjeliste.get(i);
                        i = tomlinjeliste.size() + 1;
                        varelinje = new Vare_linje(rs.getInt("vare_linje.linje_nr"), rs.getString("vare_linje.ordre_nr"), tomlinje);
                    }
                }
            } else if (rs.getInt("vare_linje.inskription_id") > 0) {
                for (int i = 0; i < inskriptionliste.size(); i++) {
                    if (inskriptionliste.get(i).getId() == rs.getInt("vare_linje.inskription_id")) {
                        Inskription inskription = inskriptionliste.get(i);
                        i = inskriptionliste.size() + 1;
                        varelinje = new Vare_linje(rs.getInt("vare_linje.linje_nr"), rs.getString("vare_linje.ordre_nr"), inskription);
                    }
                }
            } else {
                throw new NullPointerException();
            }
            varelinjeListe.add(varelinje);
        }
        return varelinjeListe;
    }

    public Ordre getOrdre(int ordre_nr) throws SQLException {
        Ordre ordre = null;
        ResultSet rs;



        return ordre;
    }
}
