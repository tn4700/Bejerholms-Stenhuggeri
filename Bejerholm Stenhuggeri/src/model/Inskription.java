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

    public Inskription(String inskription, Tegntype tegntype) {
        this.inskription = inskription;
        this.tegntype = tegntype;
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
}
