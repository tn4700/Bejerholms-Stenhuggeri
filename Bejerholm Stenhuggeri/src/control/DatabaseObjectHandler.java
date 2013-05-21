/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Faktura;
import model.Inskription_linje;
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

    public Postnummer getPostnummer(int post_nr) throws SQLException {
        Postnummer postnr = null;
        String sql = "select post_nr, bynavn from postnummer where post_nr = " + post_nr;
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

    public void createPostnummer(int post_nr, String bynavn) throws SQLException {
        if (getPostnummer(post_nr) == null) {
            db.setData("insert into postnummer(post_nr, byNavn) values ('" + post_nr + "','" + bynavn + "');");
        }
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

    public void createKunde(String fornavn, String efternavn, String adresse, int tlf, Postnummer postnr) throws SQLException {

        if (getKunde(tlf) == null) {
            db.setData("insert into kunde(fornavn, efternavn, adresse, tlf, post_nr) values('" + fornavn + "','" + efternavn + "','" + adresse + "','" + tlf + "','" + postnr + "');");
        }


    }

    public Samarbejdspartner getSamarbejdspartner(int tlf) throws SQLException {
        Samarbejdspartner partner = null;
        ResultSet rs;
        int post_nr = 0;
        String sql = "select firmanavn, adresse, tlf, cvr_nr, registrerings_nr, konto_nr, bank, post_nr"
                + " from samarbejdspartner where samarbejdspartner.tlf = " + tlf;
        rs = db.getData(sql);

        if (rs.next()) {
            partner = new Samarbejdspartner(
                    rs.getString("firmanavn"),
                    rs.getString("adresse"),
                    rs.getInt("tlf"),
                    rs.getInt("cvr_nr"),
                    rs.getInt("registrerings_nr"),
                    rs.getInt("konto_nr"),
                    rs.getString("bank"),
                    null);
            post_nr = rs.getInt("post_nr");
        }
        rs.close();
        partner.setPost_nr(getPostnummer(post_nr));
        return partner;
    }

    public void createSamarbejdspartner(String firmanavn, String adresse, int tlf, int cvr_nr, int registrerings_nr, int konto_nr, String bank, int postnr) throws SQLException {
        if (getSamarbejdspartner(tlf) == null) {
            db.setData("insert into samarbejdspartner(firmanavn,adresse,tlf,cvr_nr,registrerings_nr,konto_nr,bank,postnr) "
                    + "values('" + firmanavn + "','" + adresse + "','" + tlf + "','"
                    + "" + cvr_nr + "','" + registrerings_nr + "','" + konto_nr + "','" + bank + "','" + postnr + "');");
        }
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

    public void createTegntype(String navn, double pris_pr_tegn) throws SQLException {
        db.setData("insert into tegntype (navn, pris_pr_tegn) values('" + navn + "','" + pris_pr_tegn + "');");
    }

    public Inskription getInskription(int linje_nr, int inskription_id) throws SQLException {
        Inskription inskription = null;
        String sql = "select linje_nr, inskription_id, linje_type, inskription from inskription "
                + "where linje_nr = " + linje_nr + " and inskription_id = " + inskription_id;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            inskription = new Inskription(
                    rs.getInt("linje_nr"),
                    rs.getInt("inskription_id"),
                    rs.getInt("linje_type"),
                    rs.getString("inskription"));
        }
        rs.close();

        return inskription;
    }

    public int getMaxInskriptionLinje(int inskription_id) throws SQLException {
        int max = 0;
        String sql = "select max(linje_nr) from inskription where inskription_id =" + inskription_id;
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            max = rs.getInt("max(linje_nr)");
        }
        return max;
    }

    public Inskription_linje getInskriptionLinje(int id) throws SQLException {
        Inskription_linje inskription_linje = null;
        int tegn_id = 0;
        Inskription inskription;
        String sql = "select id, skrifttype, tegn_id from inskription_linje where id=" + id;
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            inskription_linje = new Inskription_linje(
                    null,
                    null,
                    rs.getInt("id"),
                    rs.getString("skrifttype"));
            tegn_id = rs.getInt("tegn_id");
        }
        rs.close();

        inskription_linje.setTegntype(getTegntype(tegn_id));

        for (int i = 1; i <= getMaxInskriptionLinje(inskription_linje.getId()); i++) {
            inskription = getInskription(i, inskription_linje.getId());
            inskription_linje.addInskription_linje(inskription);
            inskription = null;
        }

        return inskription_linje;
    }

    public Varegruppe getVareGruppe(int grp_nr) throws SQLException {
        Varegruppe varegruppe = null;
        String sql = "select grp_nr, navn from varegruppe where grp_nr=" + grp_nr;
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

    public void createVaregruppe(int grp_nr, String navn) throws SQLException {
        db.setData("insert into varegruppe(navn) values ('" + navn + "');");
    }

    public Vare getVare(int vare_nr) throws SQLException {
        Vare vare = null;
        int grp_nr = 0;
        String sql = "select vare_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn, "
                + "overflade, dekoration, grp_nr from vare where vare_nr=" + vare_nr;
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

    public void createVare(String navn, int højde, int bredde, double indkøbspris, double salgspris, String typenavn, String overflade, boolean dekoration, int gruppe_nr) throws SQLException {
        db.setData("insert into vare(navn, højde, bredde, indkøbspris, salgspris, typenavn, overflade,"
                + "dekoration, gruppe_nr) values ('" + navn + "','" + højde + "','" + bredde + "','" + indkøbspris + "','" + salgspris + "','" + typenavn + "','"
                + "" + overflade + "','" + dekoration + "','" + gruppe_nr + "');");
    }

    public int getMaxVareLinje(String ordre_nr) throws SQLException {
        int max = 0;
        String sql = "select max(linje_nr) from vare_linje where ordre_nr = '" + ordre_nr + "'";
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            max = rs.getInt("max(linje_nr)");
        }
        return max;
    }

    public Ordre getOrdre(String ordre_nr) throws SQLException {
        Ordre ordre = null;
        Vare_linje vare_linje = null;
        int tlf = 0;
        String sql = "select tlf, ordre_nr,ordretype,ordredato,ordrestatus,leveringdato,afhentningsdato,bemærkning,bemærkning_ekstra,"
                + "leveringsadresse,kirkegård,afdeling,afdødnavn,række,nummer,plads_navne,gravType from ordre where ordre_nr =" + ordre_nr;
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            ordre = new Ordre(rs.getString("ordre_nr"),
                    rs.getBoolean("ordretype"),
                    rs.getTimestamp("leveringdato"),
                    rs.getTimestamp("afhentningsdato"),
                    rs.getString("bemærkning"),
                    rs.getString("bemærkning_ekstra"),
                    rs.getString("leveringsadresse"),
                    rs.getString("kirkegård"),
                    rs.getInt("afdeling"),
                    rs.getString("afdødnavn"),
                    rs.getInt("række"),
                    rs.getInt("nummer"),
                    rs.getInt("plads_navne"),
                    rs.getBoolean("gravType"),
                    null);
            tlf = rs.getInt("tlf");
        }
        rs.close();
        ordre.setKunde(getKunde(tlf));
        int max = getMaxVareLinje(ordre.getOrdre_nr());
        for (int i = 1; i <= max; i++) {
            vare_linje = getVareLinje(i, ordre.getOrdre_nr());
            ordre.addVare_linje(vare_linje);
            vare_linje = null;
        }
        return ordre;
    }

    public void createOrdre(int tlf, String ordre_nr, boolean ordretype, ordredato, ordrestatus, leveringdato, afhentningsdato, bemærkning, leveringsadresse, kirkegård, afdeling, afdødnavn, række, nummer, plads_navne, gravType) {
    }

    public Vare_linje getVareLinje(int linje_nr, String ordre_nr) throws SQLException {
        Vare_linje vare_linje = null;
        int linjeType = 0;
        int id = 0;

        String sql = "select linje_nr, ordre_nr, vare_nr, inskription_id, tom_linje_id "
                + "from vare_linje where linje_nr = " + linje_nr + " and ordre_nr = " + ordre_nr;
        ResultSet rs = db.getData(sql);

        if (rs.next()) {
            vare_linje = new Vare_linje(rs.getInt("linje_nr"),
                    rs.getString("ordre_nr"),
                    null,
                    null,
                    null);

            if (rs.getInt("vare_nr") > 0) {
                linjeType = 1;
                id = rs.getInt("vare_nr");
            } else if (rs.getInt("inskription_id") > 0) {
                linjeType = 2;
                id = rs.getInt("inskription_id");
            } else if (rs.getInt("tom_linje_id") > 0) {
                linjeType = 3;
                id = rs.getInt("tom_linje_id");
            }
        }
        rs.close();

        if (linjeType == 1) {
            vare_linje.setVare(getVare(id));
        } else if (linjeType == 2) {
            vare_linje.setInskription_linje(getInskriptionLinje(id));
        } else if (linjeType == 3) {
            vare_linje.setTom_linje(getTomLinje(id));
        }

        return vare_linje;
    }

    public Faktura getFaktura(String faktura_nr) throws SQLException {
        Faktura faktura = null;
        int tlf = 0;
        String ordre_nr = "";
        String sql = "select bedemand_tlf, ordre_nr, faktura_nr, faktureringsdato, vedrørende, "
                + "sendt_dato, faktureringsadresse, fakturatype, betalingsstatus from faktura "
                + "where faktura_nr = '" + faktura_nr + "';";

        ResultSet rs = db.getData(sql);

        if (rs.next()) {
            faktura = new Faktura(rs.getString("faktura_nr"),
                    rs.getTimestamp("faktureringsdato"),
                    rs.getString("vedrørende"),
                    rs.getTimestamp("sendt_dato"),
                    rs.getString("faktureringsadresse"),
                    rs.getBoolean("fakturatype"),
                    rs.getBoolean("betalingsstatus"),
                    null,
                    null);
            ordre_nr = rs.getString("ordre_nr");
            tlf = rs.getInt("bedemand_tlf");
        }
        rs.close();

        faktura.setOrdre(getOrdre(ordre_nr));
        if (tlf != 0) {
            faktura.setBedemand(getSamarbejdspartner(tlf));
        }
        return faktura;
    }
}
