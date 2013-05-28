/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.mysql.jdbc.NotImplemented;
import control.exceptions.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        String sql = "select post_nr, bynavn from postnummer where post_nr = " + post_nr + ";";
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

    public void createPostnummer(Postnummer postnummer) throws SQLException {
        if (getPostnummer(postnummer.getPost_nr()) == null) {
            db.setData("insert into postnummer(post_nr, byNavn) values ('"
                    + postnummer.getPost_nr() + "','" + postnummer.getByNavn() + "');");
        }
    }

    public void editPostnummer(Postnummer postnummer) throws SQLException {
        db.setData("update postnummer set byNavn = '" + "' where post_nr = '" + postnummer.getPost_nr() + "';");
    }

    public Kunde getKunde(int tlf) throws SQLException {
        Kunde kunde = null;
        int post_nr = 0;
        String sql = "select fornavn, efternavn, adresse, tlf, post_nr from kunde where tlf = " + tlf + ";";
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
            rs.close();
            kunde.setPost_nr(getPostnummer(post_nr));
        }

        return kunde;
    }

    public void createKunde(Kunde kunde) throws SQLException {
        if (getKunde(kunde.getTlf()) == null) {
            createPostnummer(kunde.getPost_nr());
            db.setData("insert into kunde(fornavn, efternavn, adresse, tlf, post_nr) values('"
                    + kunde.getFornavn() + "','" + kunde.getEfternavn() + "','"
                    + kunde.getAdresse() + "','" + kunde.getTlf() + "','"
                    + kunde.getPost_nr().getPost_nr() + "');");
        }
    }

    public void editKunde(Kunde kunde) throws SQLException {
        if (getPostnummer(kunde.getPost_nr().getPost_nr()) == null) {
            createPostnummer(kunde.getPost_nr());
        }
        db.setData("update kunde set fornavn = '" + kunde.getFornavn() + "', efternavn = '"
                + kunde.getEfternavn() + "', adresse = '" + kunde.getAdresse()
                + "', post_nr = " + kunde.getPost_nr().getPost_nr() + "' where tlf = '"
                + kunde.getTlf() + "';");
    }

    public Samarbejdspartner getSamarbejdspartner(int tlf) throws SQLException {
        Samarbejdspartner partner = null;
        ResultSet rs;
        int post_nr = 0;
        String sql = "select firmanavn, adresse, tlf, cvr_nr, registrerings_nr, konto_nr, bank, post_nr"
                + " from samarbejdspartner where samarbejdspartner.tlf = " + tlf + ";";
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

    public void createSamarbejdspartner(Samarbejdspartner samarbejdspartner) throws SQLException {
        if (getSamarbejdspartner(samarbejdspartner.getTlf()) == null) {
            db.setData("insert into samarbejdspartner(firmanavn,adresse,tlf,cvr_nr,registrerings_nr,"
                    + "konto_nr,bank,postnr) "
                    + "values('" + samarbejdspartner.getFirmanavn() + "','"
                    + samarbejdspartner.getAdresse() + "','" + samarbejdspartner.getTlf() + "','"
                    + "" + samarbejdspartner.getCvr_nr() + "','" + samarbejdspartner.getRegistrerings_nr()
                    + "','" + samarbejdspartner.getKonto_nr() + "','" + samarbejdspartner.getBank()
                    + "','" + samarbejdspartner.getPost_nr().getPost_nr() + "');");
            createPostnummer(samarbejdspartner.getPost_nr());
        }
    }

    public void editSamarbejdspartner(Samarbejdspartner samarbejdspartner) throws SQLException {
        if (getPostnummer(samarbejdspartner.getPost_nr().getPost_nr()) == null) {
            createPostnummer(samarbejdspartner.getPost_nr());
        }
        db.setData("update samarbejdspartner set firmanavn = '" + samarbejdspartner.getFirmanavn() + "', adresse = '"
                + samarbejdspartner.getAdresse() + "', cvr_nr = '" + samarbejdspartner.getCvr_nr()
                + "', registrerings_nr = " + samarbejdspartner.getRegistrerings_nr() + "', konto_nr = '"
                + samarbejdspartner.getKonto_nr() + "', bank = '" + samarbejdspartner.getBank()
                + "', post_nr = " + samarbejdspartner.getPost_nr().getPost_nr() + "' where tlf = '"
                + samarbejdspartner.getTlf() + "';");
    }

    public Tom_linje getTomLinje(int id) throws SQLException {
        Tom_linje tomlinje = null;
        String sql = "select navn, pris, antal, id from tom_linje where id =" + id + ";";
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            tomlinje = new Tom_linje(
                    rs.getString("navn"),
                    rs.getDouble("pris"),
                    rs.getInt("antal"),
                    rs.getInt("id"));
        }
        rs.close();
        return tomlinje;
    }

    public int getMaxTomLinjeId() throws SQLException {
        int max = 0;
        String sql = "select max(id) from tom_linje";
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            max = rs.getInt("max(id)");
        }
        return max;
    }

    public void createTomLinje(Tom_linje tom_linje) throws SQLException {
        db.setData("insert into tom_linje(navn,pris,antal) values('"
                + tom_linje.getNavn() + "','" + tom_linje.getPris() + "','"
                + tom_linje.getAntal() + "');");
    }

    public void deleteTomLinje(Tom_linje tom_linje) throws SQLException {
        db.setData("delete from tom_linje where id = '" + tom_linje.getId() + "';");
    }

    public void editTomLinje(Tom_linje tom_linje) throws SQLException {
        db.setData("update tom_linje set navn = '" + tom_linje.getNavn() + "', pris = '"
                + tom_linje.getPris() + "', antal = '" + tom_linje.getAntal()
                + "' where id = '" + tom_linje.getId() + "';");
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

    public void createTegntype(Tegntype tegntype) throws SQLException {
        db.setData("insert into tegntype (navn, pris_pr_tegn) values('" + tegntype.getNavn()
                + "','" + tegntype.getPris_pr_tegn() + "');");
    }

    public void deleteTegntype(Tegntype tegntype) throws SQLException {
        db.setData("delete from tegntype where id = '" + tegntype.getId() + "';");
    }

    public void editTegntype(Tegntype tegntype) throws SQLException {
        db.setData("update tegntype set navn = '" + tegntype.getNavn() + "', pris_pr_tegn = '"
                + tegntype.getPris_pr_tegn() + "' where id = '"
                + tegntype.getId() + "';");
    }

    public int getMaxTegnTypeID() throws SQLException {
        int max = 0;
        String sql = "select max(id) from tegntype;";
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            max = rs.getInt("max(id)");
        }
        return max;
    }

    public Inskription_linje getInskriptionLinje(int linje_nr, int inskription_id) throws SQLException {
        Inskription_linje inskription_linje = null;
        String sql = "select linje_nr, inskription_id, linje_type, inskription from inskription_linje "
                + "where linje_nr = " + linje_nr + " and inskription_id = " + inskription_id + ";";
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            inskription_linje = new Inskription_linje(
                    rs.getInt("linje_nr"),
                    rs.getInt("inskription_id"),
                    rs.getInt("linje_type"),
                    rs.getString("inskription"));
        }
        rs.close();

        return inskription_linje;
    }

    public void createInskriptionLinje(ArrayList<Inskription_linje> inskription_linje_liste, int inskription_id) throws SQLException {
        for (int i = 0; i < inskription_linje_liste.size(); i++) {
            db.setData("insert into inskription_linje(linje_nr, inskription_id, linje_type, "
                    + "inskription)values('" + inskription_linje_liste.get(i).getLinje_nr() + "','"
                    + inskription_id + "','" + inskription_linje_liste.get(i).getLinje_type()
                    + "','" + inskription_linje_liste.get(i).getInskription() + "');");
        }
    }

    public void deleteInskriptionLinjer(ArrayList<Inskription_linje> inskription_linje_liste) throws SQLException {
        db.setData("delete from inskription_linje where inskription_id = '"
                + inskription_linje_liste.get(0).getInskription_id() + "';");
    }

    public void editInskriptionLinjer(ArrayList<Inskription_linje> inskription_linje_liste) throws SQLException {
        for (int i = 0; i < inskription_linje_liste.size(); i++) {
            db.setData("update inskription_linje set linje_nr = '" + inskription_linje_liste.get(i).getLinje_nr()
                    + "', linje_type = '" + inskription_linje_liste.get(i).getLinje_type()
                    + "', inskription = '" + inskription_linje_liste.get(i).getInskription()
                    + "' where inskription_id = '" + inskription_linje_liste.get(i).getInskription_id() + "';");
        }
    }

    public int getMaxInskriptionLinje(int inskription_id) throws SQLException {
        int max = 0;
        String sql = "select max(linje_nr) from inskription_linje where inskription_id =" + inskription_id + ";";
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            max = rs.getInt("max(linje_nr)");
        }
        return max;
    }

    public Inskription getInskription(int id) throws SQLException {
        Inskription inskription = null;
        int tegn_id = 0;
        Inskription_linje inskription_linje;
        String sql = "select id, skrifttype, tegn_id from inskription where id=" + id + ";";
        ResultSet rs;

        rs = db.getData(sql);

        if (rs.next()) {
            inskription = new Inskription(
                    null,
                    null,
                    rs.getInt("id"),
                    rs.getString("skrifttype"));
            tegn_id = rs.getInt("tegn_id");
        }
        rs.close();

        inskription.setTegntype(getTegntype(tegn_id));

        for (int i = 1; i <= getMaxInskriptionLinje(inskription.getId()); i++) {
            if (getInskriptionLinje(i, inskription.getId()) != null) {
                inskription_linje = getInskriptionLinje(i, inskription.getId());
                inskription.addInskription_linje(inskription_linje);
                inskription_linje = null;
            }
        }

        return inskription;
    }

    public void createInskription(Inskription inskription) throws SQLException {
        db.setData("insert into inskription(tegn_id, skrifttype) values ('"
                + inskription.getTegntype().getId() + "','" + inskription.getSkrifttype()
                + "');");
        createInskriptionLinje(inskription.getInskription_linje_liste(), getMaxInskriptionId());
    }

    public void deleteInskription(Inskription inskription) throws SQLException {
        deleteInskriptionLinjer(inskription.getInskription_linje_liste());
        db.setData("delete from inskription where id = '" + inskription.getId() + "';");
    }

    public void editInskription(Inskription inskription) throws SQLException {
        if (getTegntype(inskription.getTegntype().getId()) == null) {
            createTegntype(inskription.getTegntype());
            inskription.getTegntype().setId(getMaxTegnTypeID());
        }
        editInskriptionLinjer(inskription.getInskription_linje_liste());
        db.setData("update inskription set tegn_id = '" + inskription.getTegntype().getId()
                + "', skrifttype = '" + inskription.getSkrifttype() + "' where id = '"
                + inskription.getId() + "';");
    }

    public int getMaxInskriptionId() throws SQLException {
        int max = 0;
        String sql = "select max(id) from inskription;";
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            max = rs.getInt("max(id)");
        }
        return max;
    }

    public ArrayList getVaregruppeListe() throws SQLException {
        String sql = "select grp_nr, navn from varegruppe;";
        ResultSet rs;
        ArrayList<Varegruppe> varegruppeListe = new ArrayList();
        rs = db.getData(sql);

        while (rs.next()) {
            Varegruppe varegruppe = new Varegruppe(rs.getInt("grp_nr"), rs.getString("navn"));
            varegruppeListe.add(varegruppe);
        }
        return varegruppeListe;
    }

    public Varegruppe getVareGruppe(int grp_nr) throws SQLException {
        Varegruppe varegruppe = null;
        String sql = "select grp_nr, navn from varegruppe where grp_nr=" + grp_nr + ";";
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

    public int getMaxGrpNr() throws SQLException {
        int max = 0;
        ResultSet rs;
        rs = db.getData("select MAX(grp_nr) from varegruppe");
        if (rs.next()) {
            max = rs.getInt("MAX(grp_nr)");
        }
        return max;
    }

    public void createVaregruppe(Varegruppe varegruppe) throws SQLException {
        db.setData("insert into varegruppe(navn) values ('" + varegruppe.getNavn() + "');");
    }

    public void deleteVaregruppe(Varegruppe varegruppe) throws SQLException {
        db.setData("delete from varegruppe where grp_nr = '" + varegruppe.getGrp_nr() + "';");
    }

    public void editVaregruppe(Varegruppe varegruppe) throws SQLException {
        db.setData("update varegruppe set navn = '" + varegruppe.getNavn() + "' where grp_nr = '"
                + varegruppe.getGrp_nr() + "';");
    }

    public int getMaxVareNr() throws SQLException {
        int max = 0;
        ResultSet rs;
        rs = db.getData("select MAX(vare_nr) from vare;");
        if (rs.next()) {
            max = rs.getInt("MAX(vare_nr)");
        }
        return max;
    }

    public Vare getVare(int vare_nr) throws SQLException {
        Vare vare = null;
        int grp_nr = 0;
        String sql = "select vare_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn, "
                + "overflade, dekoration, vareStatus, grp_nr from vare where vare_nr=" + vare_nr + ";";
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
                    rs.getInt("vareStatus"),
                    null);
            grp_nr = rs.getInt("grp_nr");
        }
        rs.close();

        vare.setGruppe(getVareGruppe(grp_nr));

        return vare;
    }

    public ArrayList getVareListe(int grp_nr) throws SQLException {
        ArrayList<Vare> vareListe = new ArrayList();
        String sql = "select vare_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn, overflade, "
                + "dekoration, vareStatus, grp_nr from vare where grp_nr=" + grp_nr + ";";
        ResultSet rs;
        Varegruppe varegrp = getVareGruppe(grp_nr);
        rs = db.getData(sql);
        while (rs.next()) {
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
                    rs.getInt("vareStatus"),
                    varegrp);
            vareListe.add(vare);
        }
        rs.close();

        return vareListe;
    }

    public void createVare(Vare vare) throws SQLException {
        db.setData("insert into vare(navn, højde, bredde, indkøbspris, salgspris, typenavn, overflade,"
                + "dekoration, grp_nr, vareStatus) values ('" + vare.getNavn() + "','" + vare.getHøjde() + "','"
                + vare.getBredde() + "','" + vare.getIndkøbspris() + "','" + vare.getSalgspris() + "','"
                + vare.getTypenavn() + "','" + "" + vare.getOverflade() + "','" + boolToInt(vare.getDekoration())
                + "','" + vare.getGruppe().getGrp_nr() + "',0);");
    }

    public void deleteVare(Vare vare) throws SQLException {
        db.setData("delete from vare where vare_nr = '" + vare.getVare_nr() + "';");
    }

    public void editVare(Vare vare) throws SQLException {
        if (getVareGruppe(vare.getGruppe().getGrp_nr()) == null) {
            createVaregruppe(vare.getGruppe());
            vare.getGruppe().setGrp_nr(getMaxGrpNr());
        }
        db.setData("update vare set navn = '" + vare.getNavn() + "', højde = '" + vare.getHøjde()
                + "', bredde = '" + vare.getBredde() + "', indkøbspris = " + vare.getIndkøbspris()
                + "', salgspris = '" + vare.getSalgspris() + "', typenavn = '" + vare.getTypenavn()
                + "', overflade = " + vare.getOverflade() + "', dekoration = "
                + boolToInt(vare.getDekoration()) + "', vareStatus = '" + vare.getVareStatus()
                + "' where vare_nr = '" + vare.getVare_nr() + "';");
    }

    public void updateVareStatus(Vare vare) throws SQLException {
        db.setData("update Vare set vareStatus = " + vare.getVareStatus() + " where vare_nr = "
                + vare.getVare_nr() + ";");
    }

    public int getMaxVareLinje(String ordre_nr) throws SQLException {
        int max = 0;
        String sql = "select max(linje_nr) from vare_linje where ordre_nr = '" + ordre_nr + "';";
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
        String sql = "select tlf, ordre_nr,ordretype,ordredato,leveringdato,afhentningsdato,bemærkning,bemærkning_ekstra,"
                + "kirkegård,afdeling,afdødnavn,række,nummer,gravType from ordre where ordre_nr =" + ordre_nr + ";";
        ResultSet rs;
        rs = db.getData(sql);
        if (rs.next()) {
            ordre = new Ordre(rs.getString("ordre_nr"),
                    rs.getBoolean("ordretype"),
                    rs.getTimestamp("ordredato"),
                    rs.getTimestamp("leveringdato"),
                    rs.getTimestamp("afhentningsdato"),
                    rs.getString("bemærkning"),
                    rs.getString("bemærkning_ekstra"),
                    rs.getString("kirkegård"),
                    rs.getInt("afdeling"),
                    rs.getString("afdødnavn"),
                    rs.getInt("række"),
                    rs.getInt("nummer"),
                    rs.getBoolean("gravType"),
                    null,
                    null);
            tlf = rs.getInt("tlf");
            rs.close();

            ordre.setKunde(getKunde(tlf));
            int max = getMaxVareLinje(ordre.getOrdre_nr());
            for (int i = 0; i <= max; i++) {
                if (getVareLinje(i, ordre.getOrdre_nr()) != null) {
                    vare_linje = getVareLinje(i, ordre.getOrdre_nr());
                    ordre.addVare_linje(vare_linje);
                    vare_linje = null;
                }
            }
        }

        return ordre;
    }

    public String getNextOrdreNr() throws SQLException {
        int max = 0;
        ResultSet rs;
        rs = db.getData("select MAX(ordre_nr) from ordre;");
        if (rs.next()) {
            max = Integer.parseInt(rs.getString("MAX(ordre_nr)"));
        }
        String next = Integer.toString(max + 1);
        int count = 5 - next.length();
        for (int i = 0; i < count; i++) {
            next = "0" + next;
        }
        return next;
    }

    public String createOrdre(Ordre ordre) throws SQLException, ControlException {
        String ordre_nr = getNextOrdreNr();
        createKunde(ordre.getKunde());
        if (getOrdre(ordre_nr) == null) {
            db.setData("insert into ordre(tlf,ordre_nr,ordretype,ordredato,"
                    + "leveringdato,afhentningsdato,bemærkning,"
                    + "bemærkning_ekstra,kirkegård,afdeling,"
                    + "afdødnavn,række,nummer,gravType)"
                    + "values ('" + ordre.getKunde().getTlf() + "','"
                    + ordre_nr + "','" + boolToInt(ordre.getOrdretype()) + "','"
                    + ordre.getOrdredato() + "','" + ordre.getLeveringsdato() + "','"
                    + ordre.getAfhentningsdato() + "','" + ordre.getBemærkning() + "','"
                    + ordre.getBemærkning_ekstra() + "','"
                    + ordre.getKirkegård() + "','" + ordre.getAfdeling() + "','"
                    + ordre.getAfdødnavn() + "','" + ordre.getRække() + "','" + ordre.getNummer()
                    + "','" + boolToInt(ordre.getGravType()) + "');");
        } else {
            throw new ControlException("En ordre med ordrenummeret " + ordre_nr + " findes allerede.");
        }
        for (int i = 0; i < ordre.getVare_linjeListe().size(); i++) {
            createVareLinje(ordre.getVare_linjeListe().get(i), ordre_nr);
        }
        
        
        
        return ordre_nr;
    }

    public void deleteOrdre(Ordre ordre) throws SQLException {
        for (int i = 0; i < ordre.getVare_linjeListe().size(); i++) {
            deleteVareLinje(ordre.getVare_linjeListe().get(i), ordre.getOrdre_nr());
        }
        db.setData("delete from ordre where ordre_nr = '" + ordre.getOrdre_nr() + "';");
        
    }

    public void editOrdre(Ordre ordre) throws SQLException, ControlException {
        //Henter den originale ordre ind og sletter alle vare_linjer fra den
        Ordre gammelOrdre = getOrdre(ordre.getOrdre_nr());
        for (int i = 0; i < gammelOrdre.getVare_linjeListe().size(); i++) {
            deleteVareLinje(gammelOrdre.getVare_linjeListe().get(i), gammelOrdre.getOrdre_nr());
        }
        //Opretter vare_linjer fra det opdaterede ordre objekt
        for (int i = 0; i < ordre.getVare_linjeListe().size(); i++) {
            createVareLinje(ordre.getVare_linjeListe().get(i), ordre.getOrdre_nr());
        }
        if (getKunde(ordre.getKunde().getTlf()) == null) {
            createKunde(ordre.getKunde());
        } else {
            editKunde(ordre.getKunde());
        }
        db.setData("update ordre set tlf = '" + ordre.getKunde().getTlf() + "', ordretype = '" + boolToInt(ordre.getOrdretype())
                + "', ordredato = '" + ordre.getOrdredato() + "', leveringsdato = " + ordre.getLeveringsdato()
                + "', afhentningsdato = '" + ordre.getAfhentningsdato() + "', bemærkning = '" + ordre.getBemærkning()
                + "', bemærkning_ekstra = " + ordre.getBemærkning_ekstra() + "', kirkegård = "
                + ordre.getKirkegård() + "', afdeling = '" + ordre.getAfdeling() + "', afdødnavn = '" + ordre.getAfdødnavn()
                + "', række = " + ordre.getRække() + "', nummer = "
                + ordre.getNummer() + "', gravType = '" + boolToInt(ordre.getGravType())
                + "' where ordre_nr = '" + ordre.getOrdre_nr() + "';");
    }

    public Vare_linje getVareLinje(int linje_nr, String ordre_nr) throws SQLException {
        Vare_linje vare_linje = null;
        int linjeType = 0;
        int id = 0;

        String sql = "select linje_nr, ordre_nr, vare_nr, inskription_id, tom_linje_id "
                + "from vare_linje where linje_nr = " + linje_nr + " and ordre_nr = " + ordre_nr + ";";
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
            rs.close();
            if (linjeType == 1) {
                vare_linje.setVare(getVare(id));
            } else if (linjeType == 2) {
                vare_linje.setInskription(getInskription(id));
            } else if (linjeType == 3) {
                vare_linje.setTom_linje(getTomLinje(id));
            }
        }

        return vare_linje;
    }

    public void createVareLinje(Vare_linje vareLinje, String ordre_nr) throws SQLException, ControlException {
        if (vareLinje.getVare() != null) {
            Vare vare = getVare(vareLinje.getVare().getVare_nr());
            if (vare.getVareStatus() == 0) {
                updateVareStatus(vareLinje.getVare());
                db.setData("insert into vare_linje (linje_nr, vare_nr, ordre_nr)"
                        + "values ('" + vareLinje.getLinje_nr() + "','" + vareLinje.getVare().getVare_nr()
                        + "','" + ordre_nr + "');");
            } else {
                String error = "Ugyldig vareStatus for vare_nr " + vare.getVare_nr() + ".";
                if (vare.getVareStatus() == 1) {
                    error = "Vare er reserveret.";
                } else if (vare.getVareStatus() == 2) {
                    error = "Vare er allerede solgt.";
                }
                throw new ControlException(error);
            }
        } else if (vareLinje.getInskription() != null) {
            createInskription(vareLinje.getInskription());
            int inskription_id = getMaxInskriptionId();
            db.setData("insert into vare_linje (linje_nr, inskription_id, ordre_nr)"
                    + "values ('" + vareLinje.getLinje_nr() + "','" + inskription_id
                    + "','" + ordre_nr + "');");
        } else if (vareLinje.getTom_linje() != null) {
            createTomLinje(vareLinje.getTom_linje());
            int tom_linje_id = getMaxTomLinjeId();
            db.setData("insert into vare_linje (linje_nr, tom_linje_id, ordre_nr)"
                    + "values ('" + vareLinje.getLinje_nr() + "','" + tom_linje_id
                    + "','" + ordre_nr + "');");
        }
    }

    public void deleteVareLinje(Vare_linje vare_linje, String ordre_nr) throws SQLException {
        if (vare_linje.getInskription() != null) {
            deleteInskription(vare_linje.getInskription());
        } else if (vare_linje.getTom_linje() != null) {
            deleteTomLinje(vare_linje.getTom_linje());
        } else if (vare_linje.getVare() != null) {
            vare_linje.getVare().setVareStatus(0);
            updateVareStatus(vare_linje.getVare());
        }
        db.setData("delete from vare_linje where linje_nr = '" + vare_linje.getLinje_nr()
                + "' and ordre_nr = '" + ordre_nr + "';");
    }

    public void editVareLinje(Vare_linje vare_linje, String ordre_nr) {
        //Umulig at lave, brug i stedet deleteVareLinje på alle varelinjer tilhørende
        //ordrenummeret og opret derefter dem igen med createVareLinje
        throw new NotImplementedException();
    }

    public Faktura getFaktura(String faktura_nr) throws SQLException {
        Faktura faktura = null;
        int tlf = 0;
        String ordre_nr = null;
        String provisions_nr = null;
        String sql = "select bedemand_tlf, provisions_nr ordre_nr, faktura_nr, faktureringsdato,"
                + "vedrørende, sendt_dato, faktureringsadresse, fakturatype, betalingsstatus from "
                + "faktura where faktura_nr = '" + faktura_nr + "';";

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
                    null,
                    null);
            provisions_nr = rs.getString("provisions_nr");
            ordre_nr = rs.getString("ordre_nr");
            tlf = rs.getInt("bedemand_tlf");
        }
        rs.close();

        faktura.setOrdre(getOrdre(ordre_nr));
        if (faktura.getFakturatype()) {
            faktura.setBedemand(getSamarbejdspartner(tlf));
            faktura.setProvisionsseddel(getProvisionsseddel(provisions_nr));
        }
        return faktura;
    }

    public void createFaktura(Faktura faktura) throws SQLException, ControlException {
        String faktura_nr = "00" + faktura.getOrdre().getKunde().getTlf() + "-" + faktura.getOrdre().getOrdre_nr();

        if (faktura.getFakturatype()) {
            if (faktura.getBedemand() != null && faktura.getProvisionsseddel() != null) {
                createSamarbejdspartner(faktura.getBedemand());
                createProvisionsseddel(faktura.getProvisionsseddel());
            } else {
                throw new ControlException("Ugylige fakturaoplysninger(bedemandsordre men ingen samarbejdspartner og/eller provisionsseddel valgt");
            }
            db.setData("insert into faktura (ordre_nr, faktura_nr, bedemand_tlf, faktureringsdato,"
                    + "vedrørende,sendt_dato,faktureringsadresse,fakturatype,betalingsstatus)values('"
                    + faktura.getOrdre().getOrdre_nr() + "','" + faktura_nr + "','"
                    + faktura.getBedemand().getTlf() + "','"
                    + faktura.getFaktureringsdato() + "','" + faktura.getVedrørende() + "','"
                    + faktura.getSendt_dato() + "','" + faktura.getFaktureringsadresse() + "','"
                    + boolToInt(faktura.getFakturatype()) + "','" + boolToInt(faktura.getBetalingsstatus())
                    + "');");
        } else {
            db.setData("insert into faktura (ordre_nr, faktura_nr,faktureringsdato,"
                    + "vedrørende,sendt_dato,faktureringsadresse,fakturatype,betalingsstatus)values('"
                    + faktura.getOrdre().getOrdre_nr() + "','" + faktura_nr + "','"
                    + faktura.getFaktureringsdato() + "','" + faktura.getVedrørende() + "','"
                    + faktura.getSendt_dato() + "','" + faktura.getFaktureringsadresse() + "','"
                    + boolToInt(faktura.getFakturatype()) + "','" + boolToInt(faktura.getBetalingsstatus())
                    + "');");
        }
    }

    public void deleteFaktura(Faktura faktura) throws SQLException {
        if (faktura.getFakturatype()) {
            if (getProvisionsseddel(faktura.getProvisionsseddel().getProvisions_nr()) != null) {
                deleteProvisionsseddel(faktura.getProvisionsseddel());
            }
        }
        db.setData("delete from faktura where faktura_nr = '" + faktura.getFaktura_nr() + "';");
    }

    public void editFaktura(Faktura faktura) throws SQLException, ControlException {
        Faktura oldFaktura = getFaktura(faktura.getFaktura_nr());
        deleteFaktura(oldFaktura);
        if (getKunde(faktura.getBedemand().getTlf()) == null) {
            createSamarbejdspartner(faktura.getBedemand());
        } else {
            editSamarbejdspartner(faktura.getBedemand());
        }
        createFaktura(faktura);
    }

    public String getNextKontoudtogNr() throws SQLException {
        int max = 0;
        ResultSet rs;
        rs = db.getData("select MAX(kontoudtog_nr) from kontoudtog;");
        if (rs.next()) {
            max = Integer.parseInt(rs.getString("MAX(kontoudtog_nr)"));
        }
        String next = Integer.toString(max + 1);
        int count = 5 - next.length();
        for (int i = 0; i < count; i++) {
            next = "0" + next;
        }
        return next;
    }

    public Kontoudtog getKontoudtog(String kontoudtog_nr) throws SQLException {
        Kontoudtog kontoudtog = null;
        ResultSet rs;
        rs = db.getData("Select kontoudtog_nr,dato,sendt_dato from Kontoudtog where "
                + "kontoudtog_nr = '" + kontoudtog_nr + "';");
        if (rs.next()) {
            kontoudtog = new Kontoudtog(rs.getString("kontoudtog_nr"),
                    rs.getTimestamp("dato"),
                    rs.getTimestamp("sendt_dato"));
            rs.close();
        }
        return kontoudtog;
    }

    public void createKontoudtog(Kontoudtog kontoudtog) throws SQLException, ControlException {
        String kontoudtog_nr = getNextKontoudtogNr();
        if (getKontoudtog(kontoudtog_nr) == null) {
            db.setData("Insert into Kontoudtog(kontoudtog_nr, dato, sendt_dato) values('"
                    + kontoudtog_nr + "','" + kontoudtog.getDato() + "','"
                    + kontoudtog.getSendt_dato() + "');");
        } else {
            throw new ControlException("Et kontoudtog med kontoudtog_nr " + kontoudtog_nr + " findes allerede.");
        }
    }

    public void deleteKontoudtog(Kontoudtog kontoudtog) throws SQLException {
        db.setData("delete from kontoudtog where kontoudtog_nr = '" + kontoudtog.getKontoudtog_nr() + "';");
    }

    public Provisionsseddel getProvisionsseddel(String provisions_nr) throws SQLException {
        Provisionsseddel provisionsseddel = null;
        ResultSet rs;
        rs = db.getData("Select provisions_nr, kontoudtog_nr, dato from Provisionsseddel where "
                + "provisions_nr = '" + provisions_nr + "';");
        if (rs.next()) {
            provisionsseddel = new Provisionsseddel(rs.getString("provisions_nr"),
                    rs.getTimestamp("dato"),
                    null);
            rs.close();
            String kontoudtog_nr = rs.getString("kontoudtog_nr");
            Kontoudtog kontoudtog = getKontoudtog(kontoudtog_nr);
            provisionsseddel.setKontoudtog(kontoudtog);
        }
        return provisionsseddel;
    }

    public String getNextProvisionsNr() throws SQLException {
        int max = 0;
        ResultSet rs;
        rs = db.getData("select MAX(provisions_nr) from provisionsseddel;");
        if (rs.next()) {
            max = Integer.parseInt(rs.getString("MAX(provisions_nr)"));
        }
        String next = Integer.toString(max + 1);
        int count = 5 - next.length();
        for (int i = 0; i < count; i++) {
            next = "0" + next;
        }
        return next;
    }

    public void createProvisionsseddel(Provisionsseddel provisionsseddel) throws SQLException, ControlException {
        String provisions_nr = getNextProvisionsNr();
        if (getProvisionsseddel(provisions_nr) == null) {
            if (provisionsseddel.getKontoudtog() != null) {
                createKontoudtog(provisionsseddel.getKontoudtog());
            } else {
                throw new ControlException("Ugyldigt provisionsseddel objekt, intet kontoudtog er oprettet.");
            }
            db.setData("Insert into Provisionsseddel(provisions_nr, kontoudtog_nr, dato) values('"
                    + provisions_nr + "','" + provisions_nr + "','"
                    + provisionsseddel.getDato() + "');");
        } else {
            throw new ControlException("En provisionsseddel med provisions_nr " + provisions_nr + " findes allerede.");
        }
    }

    public void deleteProvisionsseddel(Provisionsseddel provisionsseddel) throws SQLException {
        if (getKontoudtog(provisionsseddel.getKontoudtog().getKontoudtog_nr()) != null) {
            deleteKontoudtog(provisionsseddel.getKontoudtog());
        }
        db.setData("delete from provisionsseddel where provisions_nr = '"
                + provisionsseddel.getProvisions_nr() + "';");
    }

    public User getUser(String username) throws SQLException {
        ResultSet rs;
        User user = null;
        rs = db.getData("Select brugernavn, pw from user where brugernavn = '" + username + "';");

        if (rs.next()) {
            user = new User(
                    rs.getString("brugernavn"),
                    rs.getString("pw"));
        }
        return user;
    }

    public void createUser(User user) throws SQLException, ControlException {
        if (getUser(user.getUsername()) == null) {
            db.setData("insert into user(brugernavn,pw)values('" + user.getUsername()
                    + "','" + user.getPassword() + "');");
        } else {
            throw new ControlException("Bruger findes allerede.");
        }
    }

    public void deleteUser(User user) throws SQLException {
        db.setData("delete from user where brugernavn = " + user.getUsername() + ";");
    }

    public void editUser(User user) throws SQLException {
        db.setData("update table user set pw = " + user.getPassword() + " where brugernavn = " + user.getUsername() + ";");
    }

    public int boolToInt(boolean b) {
        int result = 0;
        if (b) {
            result = 1;
        }
        return result;

    }
}
