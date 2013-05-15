/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Inskription {

    private String inskription;
    private Tegntype tegntype;
    private int id;
    private String skrifttype;

    public Inskription(String inskription, Tegntype tegntype, int id, String skrifttype) {
        this.inskription = inskription;
        this.tegntype = tegntype;
        this.id = id;
        this.skrifttype = skrifttype;
    }

    public String getInskription() {
        return inskription;
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

    public void setInskription(String inskription) {
        this.inskription = inskription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inskription{" + "inskription=" + inskription + ", tegntype=" + tegntype + ", id=" + id + ", skrifttype=" + skrifttype + '}';
    }
    
}
