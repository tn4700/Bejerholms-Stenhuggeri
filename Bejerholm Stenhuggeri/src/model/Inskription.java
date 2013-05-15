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
    private int tegn_id;
    private String skrifttype;

    public Inskription(String inskription, Tegntype tegntype, int tegn_id, String skrifttype) {
        this.inskription = inskription;
        this.tegntype = tegntype;
        this.tegn_id = tegn_id;
        this.skrifttype = skrifttype;
    }

    public String getInskription() {
        return inskription;
    }

    public void setInskription(String inskription) {
        this.inskription = inskription;
    }

    public Tegntype getId() {
        return tegntype;
    }

    public void setId(Tegntype id) {
        this.tegntype = id;
    }

    @Override
    public String toString() {
        return "Inskription{" + "inskription=" + inskription + ", tegntype=" + tegntype + ", tegn_id=" + tegn_id + ", skrifttype=" + skrifttype + '}';
    }
    
}
