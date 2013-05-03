/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Martin
 */
public class Ordre {
    
    private int ordre_nr;
    private boolean ordretype;
    private Timestamp ordredato;
    private int ordrestatus;
    private Timestamp leveringsdato;
    private Timestamp afhentmningsdato;
    private String bemærkning;
    private String leveringsadresse;
    private String kirkegård;
    private int afdeling;
    private String afdødnavn;
    private int række;
    private int nummer;
    private int plads_navne;
    private boolean gravType;
    private Kunde kunde;
    
    
}
