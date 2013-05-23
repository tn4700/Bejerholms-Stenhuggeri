/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class Inskription {

    private ArrayList<Inskription_linje> inskription_linje_liste;
    private Tegntype tegntype;
    private int id;
    private String skrifttype;

    public Inskription(ArrayList<Inskription_linje> inskription_linje_liste, Tegntype tegntype, int id, String skrifttype) {
        inskription_linje_liste = new ArrayList();
        this.inskription_linje_liste = inskription_linje_liste;
        this.tegntype = tegntype;
        this.id = id;
        this.skrifttype = skrifttype;
    }
    
    public void addInskription_linje(Inskription_linje inskription){
        inskription_linje_liste.add(inskription);
    }

    public ArrayList<Inskription_linje> getInskription_linje_liste() {
        return inskription_linje_liste;
    }

    public Tegntype getTegntype() {
        return tegntype;
    }

    public void setTegntype(Tegntype tegntype) {
        this.tegntype = tegntype;
    }

    public String getSkrifttype() {
        return skrifttype;
    }

    public void setSkrifttype(String skrifttype) {
        this.skrifttype = skrifttype;
    }

    public void setInskription(ArrayList<Inskription_linje> inskription_linje_liste) {
        this.inskription_linje_liste = inskription_linje_liste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
