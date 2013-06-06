/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.ControlException;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Faktura;
import model.Faktureringsadresse;
import model.Kunde;
import model.Ordre;
import model.Postnummer;
import model.Samarbejdspartner;
import model.Tom_linje;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T
 */
public class DatabaseObjectHandlerTest {

    private DatabaseObjectHandler dbhandler;
    private DBConnection db;

    public DatabaseObjectHandlerTest() {
        try {
            db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");
        } catch (Exception ex) {
            System.out.println("fejl: " + ex);
        }

        if (db.isConnected() == false) {
        }
        dbhandler = new DatabaseObjectHandler(db);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   
    @Test
    public void getPostnummer() throws SQLException {
        System.out.println("Hent Postnummer");
        Postnummer postnr = dbhandler.getPostnummer(4700);

        int expResult = 4700;
        int result = postnr.getPost_nr();
        assertEquals("Hent Postnr", expResult, result);

        String ExpResultString = "Næstved";
        String resultString = postnr.getByNavn();
        assertEquals("Hent Bynavn", ExpResultString, resultString);

    }

    @Test
    public void createPostnummer() throws SQLException {
        System.out.println("Opret Postnr");
        Postnummer nytpostnr = new Postnummer(2000, "Frederiksberg");
        dbhandler.createPostnummer(nytpostnr);

        Postnummer postnr = dbhandler.getPostnummer(2000);

        int expResult = 2000;
        int result = postnr.getPost_nr();
        assertEquals("Hent Postnr", expResult, result);

        String ExpResultString = "Frederiksberg";
        String resultString = postnr.getByNavn();
        assertEquals("Hent Bynavn", ExpResultString, resultString);


    }

    @Test
    public void editPostnummer() throws SQLException {
        System.out.println("Rediger Post Nr");
        Postnummer postnr = dbhandler.getPostnummer(4684);

        postnr.setPost_nr(2760);
        postnr.setByNavn("Søborg");

        dbhandler.editPostnummer(postnr);
        dbhandler.getPostnummer(2760);

        int expResult = 2760;
        int result = postnr.getPost_nr();
        assertEquals("Hent Postnr", expResult, result);

        String ExpResultString = "Søborg";
        String resultString = postnr.getByNavn();
        assertEquals("Hent Bynavn", ExpResultString, resultString);





    }

    @Test
    public void getFaktureringsadresse() throws SQLException {
        System.out.println("Hent Fakturingsadresse");
        Faktureringsadresse faktadresse = dbhandler.getFaktureringsadresse(1);

        String expResult = "Gottliebsvej 7";
        String result = faktadresse.getAdresse();
        assertEquals("Hent Fakturerings Adresse", expResult, result);

        int expResultInt = 4700;
        Postnummer postnr = faktadresse.getPost_nr();
        int resultInt = postnr.getPost_nr();
        assertEquals("Hent Fakturerings Adresse", expResultInt, resultInt);

    }

    @Test
    public void createFaktureringsadresse() throws SQLException {
        System.out.println("Opret Faktureringsadresse");
        Postnummer postnummer = dbhandler.getPostnummer(4700);
        Faktureringsadresse nyFakAdresse = new Faktureringsadresse(0, "Testvej 4", postnummer);
        dbhandler.createFaktureringsadresse(nyFakAdresse);
        int maxFakId = dbhandler.getMaxAdresseId();
        Faktureringsadresse fakAdresse = dbhandler.getFaktureringsadresse(maxFakId);

        String expResult = "Testvej 4";
        String result = fakAdresse.getAdresse();
        assertEquals("Hent Oprettet Fakturings adresse", expResult, result);

        postnummer = fakAdresse.getPost_nr();

        int expResultInt = 4700;
        int resultInt = postnummer.getPost_nr();
        assertEquals("Hent nyoprettet postnr", expResultInt, resultInt);

        expResult = "Næstved";
        result = postnummer.getByNavn();
        assertEquals("Hent Bynavn", expResult, result);


    }

    @Test
    public void editFaktureringsadresse() throws SQLException {
        System.out.println("Rediger FaktureringsAdresse");

        Faktureringsadresse fakAdresse = dbhandler.getFaktureringsadresse(3);
        fakAdresse.setAdresse("Hvedevænget 5");
        Postnummer postnr = dbhandler.getPostnummer(4300);
        fakAdresse.setPost_nr(postnr);
        dbhandler.editFaktureringsadresse(fakAdresse);


        fakAdresse = dbhandler.getFaktureringsadresse(3);

        String expResult = "Hvedevænget 5";
        String result = fakAdresse.getAdresse();
        assertEquals("Test af Adresse", expResult, result);

        postnr = fakAdresse.getPost_nr();
        int expResultInt = 4300;
        int resultInt = postnr.getPost_nr();
        assertEquals(expResultInt, resultInt);

    }

    @Test
    public void getKunde() throws SQLException {
        System.out.println("Hent Kunde");
        int tlf = 50111211;
        Kunde kunde = dbhandler.getKunde(tlf);

        String expResult = "Thomas";
        String result = kunde.getFornavn();
        assertEquals("Hent Kunde Fornavn", expResult, result);


        expResult = "Nielsen";
        result = kunde.getEfternavn();
        assertEquals("Hende Kunde Efternavn", expResult, result);

        expResult = "Østre Ringvej 49 2. TV";
        result = kunde.getAdresse();
        assertEquals("Hent Kunde adresse", expResult, result);

        Postnummer postnr = kunde.getPost_nr();
        int expResultInt = 4700;
        int resultInt = postnr.getPost_nr();
        assertEquals("Hent kundepostnr", expResultInt, resultInt);


    }

    @Test
    public void createKunde() throws SQLException {
        System.out.println("Opret Kunde");
        Postnummer postnr = dbhandler.getPostnummer(4700);
        Kunde kunde = new Kunde("Krølle", "Bølle", "Skovvej 12", 12345678, postnr);
        dbhandler.createKunde(kunde);

        kunde = null;
        kunde = dbhandler.getKunde(12345678);
        String expResult = "Krølle";
        String result = kunde.getFornavn();
        assertEquals("Tjek Fornavn", expResult, result);

        expResult = "Bølle";
        result = kunde.getEfternavn();
        assertEquals("Tjek Efternavn", expResult, result);

        expResult = "Skovvej 12";
        result = kunde.getAdresse();
        assertEquals("Tjek Adresse", expResult, result);

        int expResultInt = 4700;
        int resultInt = kunde.getPost_nr().getPost_nr();
        assertEquals("Tjek Postnr", expResultInt, resultInt);

    }
// Redigere en kunde hvor telefon nr også ændres

    @Test
    public void editKundeUndenTelefon() throws SQLException {
        System.out.println("Rediger Kunde og telefon nr");

        Kunde kunde = dbhandler.getKunde(12345678);
        kunde.setFornavn("Jørgen");
        kunde.setEfternavn("Hansen");
        kunde.setAdresse("Vesterhave 3");
        kunde.setTlf(28851681);
        Postnummer postnr = dbhandler.getPostnummer(4200);
        kunde.setPost_nr(postnr);
        dbhandler.editKunde(kunde);

        kunde = null;
        kunde = dbhandler.getKunde(28851681);
        String expResult = "Jørgen";
        String result = kunde.getFornavn();
        assertEquals("Tjek Fornavn", expResult, result);

        expResult = "Hansen";
        result = kunde.getEfternavn();
        assertEquals("Tjek Efternavn", expResult, result);

        expResult = "Vesterhave 3";
        result = kunde.getAdresse();
        assertEquals("Tjek Adresse", expResult, result);

        int expResultInt = 4200;
        int resultInt = kunde.getPost_nr().getPost_nr();
        assertEquals(expResultInt, resultInt);

    }
//ændre kunde uden telefonr

    @Test
    public void editKunde() throws SQLException {
        System.out.println("Rediger Kunde uden telefonnr");

        Kunde kunde = dbhandler.getKunde(20332836);
        kunde.setFornavn("Jørgen");
        kunde.setEfternavn("Hansen");
        kunde.setAdresse("Vesterhave 3");

        Postnummer postnr = dbhandler.getPostnummer(4200);
        kunde.setPost_nr(postnr);
        dbhandler.editKunde(kunde);


        kunde = dbhandler.getKunde(20332836);
        String expResult = "Jørgen";
        String result = kunde.getFornavn();
        assertEquals("Tjek Fornavn", expResult, result);

        expResult = "Hansen";
        result = kunde.getEfternavn();
        assertEquals("Tjek Efternavn", expResult, result);

        expResult = "Vesterhave 3";
        result = kunde.getAdresse();
        assertEquals("Tjek Adresse", expResult, result);

        int expResultInt = 4200;
        int resultInt = kunde.getPost_nr().getPost_nr();
        assertEquals(expResultInt, resultInt);

    }

    @Test
    public void getSamarbejdspartner() throws SQLException {
        System.out.println("Hent Samarbejdspartner");
        Samarbejdspartner partner = dbhandler.getSamarbejdspartner(11112222);

        String expResult = "Bedemand Berner";
        String result = partner.getFirmanavn();
        assertEquals("Hent Firmanavn", expResult, result);

        expResult = "Fiktivvej 666";
        result = partner.getAdresse();
        assertEquals("Hent FirmaAdresse", expResult, result);

        int expResultInt = 16276483;
        int resultInt = partner.getCvr_nr();
        assertEquals("Hent CVR Nummer", expResultInt, resultInt);

        expResultInt = 1233;
        resultInt = partner.getRegistrerings_nr();
        assertEquals("Hent Registrerings nr", expResultInt, resultInt);

        expResult = "6070123458";
        result = partner.getKonto_nr();
        assertEquals("Hent Kontonr", expResult, result);

        expResult = "BankenC";
        result = partner.getBank();
        assertEquals("Hent Bank", expResult, result);

        expResultInt = 4700;
        resultInt = partner.getPost_nr().getPost_nr();
        assertEquals("Hent Postnr", expResultInt, resultInt);
    }

    @Test
    public void createSamarbejdspartner() throws SQLException {
        System.out.println("Opret Samarbejdspartner");
        Postnummer postnr = dbhandler.getPostnummer(4700);
        Samarbejdspartner partner = new Samarbejdspartner("Bedeman Thomas", "Gågade 3", 20925064, 01010101, 001, "0004825318", "MaxBank", postnr);
        dbhandler.createSamarbejdspartner(partner);

        partner = null;
        partner = dbhandler.getSamarbejdspartner(20925064);
        String expResult = "Bedeman Thomas";
        String result = partner.getFirmanavn();
        assertEquals("Hent Firmanavn", expResult, result);

        expResult = "Gågade 3";
        result = partner.getAdresse();
        assertEquals("Hent FirmaAdresse", expResult, result);

        int expResultInt = 01010101;
        int resultInt = partner.getCvr_nr();
        assertEquals("Hent CVR Nummer", expResultInt, resultInt);

        expResultInt = 001;
        resultInt = partner.getRegistrerings_nr();
        assertEquals("Hent Registrerings nr", expResultInt, resultInt);

        expResult = "0004825318";
        result = partner.getKonto_nr();
        assertEquals("Hent Kontonr", expResult, result);

        expResult = "MaxBank";
        result = partner.getBank();
        assertEquals("Hent Bank", expResult, result);

        expResultInt = 4700;
        resultInt = partner.getPost_nr().getPost_nr();
        assertEquals("Hent Postnr", expResultInt, resultInt);

    }

    @Test
    public void editSamarbejdspartner() throws SQLException {
        System.out.println("Rediger Samarbejdspartner");
        Postnummer postnr = dbhandler.getPostnummer(4200);
        Samarbejdspartner partner = dbhandler.getSamarbejdspartner(11112226);
        partner.setFirmanavn("Bedemand Skurk");
        partner.setAdresse("Skurkvej 10");
        partner.setBank("SkurkBank");
        partner.setCvr_nr(12345678);
        partner.setKonto_nr("0101010101");
        partner.setRegistrerings_nr(4321);
        partner.setPost_nr(postnr);
        dbhandler.editSamarbejdspartner(partner);

        partner = dbhandler.getSamarbejdspartner(11112226);

        String expResult = "Bedemand Skurk";
        String result = partner.getFirmanavn();
        assertEquals("Hent Firmanavn", expResult, result);

        expResult = "Skurkvej 10";
        result = partner.getAdresse();
        assertEquals("Hent FirmaAdresse", expResult, result);

        int expResultInt = 12345678;
        int resultInt = partner.getCvr_nr();
        assertEquals("Hent CVR Nummer", expResultInt, resultInt);

        expResultInt = 4321;
        resultInt = partner.getRegistrerings_nr();
        assertEquals("Hent Registrerings nr", expResultInt, resultInt);

        expResult = "0101010101";
        result = partner.getKonto_nr();
        assertEquals("Hent Kontonr", expResult, result);

        expResult = "SkurkBank";
        result = partner.getBank();
        assertEquals("Hent Bank", expResult, result);

        expResultInt = 4200;
        resultInt = partner.getPost_nr().getPost_nr();
        assertEquals("Hent Postnr", expResultInt, resultInt);

    }

    @Test
    public void getTomLinje() throws SQLException {
        System.out.println("Hent TomLinje");
        Tom_linje tomlinje = dbhandler.getTomLinje(1);

        String expResult = "Navn1";
        String result = tomlinje.getNavn();
        assertEquals("Hent Navn", expResult, result);

        double expResultDouble = 1000;
        double resultDouble = tomlinje.getPris();
        assertEquals("Hent Pris", expResultDouble, resultDouble, 01);

        int expResultInt = 1;
        int resultInt = tomlinje.getAntal();
        assertEquals("Hent Antal", expResultInt, resultInt);


    }

    @Test
    public void getOrdre() throws SQLException {
        System.out.println("Hent Ordre");
        String ordrenr = "00001";
        String expResult;
        int expResultInt;
        String result;
        int resultInt;
        boolean expResultBool;
        boolean resultBool;

        Ordre ordre = dbhandler.getOrdre(ordrenr);
        expResultBool = true;
        resultBool = ordre.getOrdretype();
        assertEquals("Hent OrdreType", expResultBool, resultBool);

        Timestamp expResultTimestamp = new Timestamp(113, 03, 30, 12, 50, 32, 00);
        Timestamp resultTimestamp = ordre.getOrdredato();
        assertEquals("Hent Ordredato", expResultTimestamp, resultTimestamp);

        expResultTimestamp = new Timestamp(113, 04, 10, 12, 50, 32, 00);
        resultTimestamp = ordre.getLeveringsdato();
        assertEquals("Hent Leveringsdato", expResultTimestamp, resultTimestamp);

        expResultTimestamp = new Timestamp(113, 04, 15, 12, 50, 32, 00);
        resultTimestamp = ordre.getafhentningsdato();
        assertEquals("Hent Afhentningsdato", expResultTimestamp, resultTimestamp);

        expResult = "Bemærkning";
        result = ordre.getBemærkning();
        assertEquals("Hent Bemærkning", expResult, result);

        expResult = "Bemærkning_ekstra";
        result = ordre.getBemærkning_ekstra();
        assertEquals("Hent bemærkning ekstra", expResult, result);

        expResult = "Gunner";
        result = ordre.getAfdødnavn();
        assertEquals("Hent Afdødnavn", expResult, result);

        expResultInt = 10;
        resultInt = ordre.getRække();
        assertEquals("Hent Række Nummer", expResultInt, resultInt);

        expResultInt = 1;
        resultInt = ordre.getNummer();
        assertEquals("Hent Nummer", expResultInt, resultInt);

        expResultBool = true;
        resultBool = ordre.getGravType();
        assertEquals("Hent Gravtype", expResultBool, resultBool);






    }
    
    public void getFaktura() throws SQLException, ControlException{
        System.out.println("Hent faktura");
        Faktura faktura = dbhandler.getFaktura("0050111211-00002");

        Timestamp expResultTimestamp = new Timestamp(113,03,30,14,50,32,00);
        Timestamp resultTimestamp = faktura.getFaktureringsdato();
        assertEquals("Hent Faktureringsdato", expResultTimestamp, resultTimestamp);
        
        expResultTimestamp = new Timestamp(113,03,01,14,50,32,00);
        resultTimestamp = faktura.getSendt_dato();
        assertEquals("Hent Sendtdato", expResultTimestamp, resultTimestamp);
        
        boolean expResultBool = true;
        boolean resultBool = faktura.getFakturatype();
        assertEquals("Hent Fakturatype",expResultBool, resultBool);
        
        expResultBool = false;
        resultBool = faktura.getBetalingsstatus();
        assertEquals("Hent Betalingsstatus",expResultBool, resultBool);

        int expectedResultInt = 58350001;
        int resultInt = faktura.getBedemand().getTlf();
        assertEquals("Samarbejdspartner",expectedResultInt, resultInt);
        
        String expectedResult = "00004";
        String result = faktura.getOrdre().getOrdre_nr();
        assertEquals("Hent Ordrenr",expectedResult, result);
        
        expectedResult = "00004";
        result = faktura.getProvisionsseddel().getProvisions_nr();
        assertEquals("Hent Provisionsnr",expectedResult, result);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}