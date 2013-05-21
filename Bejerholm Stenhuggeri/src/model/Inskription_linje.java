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
public class Inskription_linje {

    private ArrayList<Inskription> inskription_liste;
    private Tegntype tegntype;
    private int id;
    private String skrifttype;

    public Inskription_linje(ArrayList<Inskription> inskription_linje_liste, Tegntype tegntype, int id, String skrifttype) {
        inskription_linje_liste = new ArrayList();
        this.inskription_liste = inskription_linje_liste;
        this.tegntype = tegntype;
        this.id = id;
        this.skrifttype = skrifttype;
    }
    
    public void addInskription_linje(Inskription inskription){
        inskription_liste.add(inskription);
    }

    public ArrayList<Inskription> getInskription_linje_liste() {
        return inskription_liste;
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

    public void setInskription(ArrayList<Inskription> inskription_liste) {
        this.inskription_liste = inskription_liste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inskription_linje{" + "inskription_liste=" + inskription_liste + ", tegntype=" + tegntype + ", id=" + id + ", skrifttype=" + skrifttype + '}';
    }
    
}
