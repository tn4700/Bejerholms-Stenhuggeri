/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NiklasRenner
 */
public class Inskription {

    private int linje_nr;
    private int inskription_id;
    private int linje_type;
    private String inskription;

    public Inskription(int linje_nr, int inskription_id, int linje_type, String inskription) {
        this.linje_nr = linje_nr;
        this.inskription_id = inskription_id;
        this.linje_type = linje_type;
        this.inskription = inskription;
    }

    public int getLinje_nr() {
        return linje_nr;
    }

    public void setLinje_nr(int linje_nr) {
        this.linje_nr = linje_nr;
    }

    public int getInskription_id() {
        return inskription_id;
    }

    public void setInskription_id(int inskription_id) {
        this.inskription_id = inskription_id;
    }

    public int getLinje_type() {
        return linje_type;
    }

    public void setLinje_type(int linje_type) {
        this.linje_type = linje_type;
    }

    public String getInskription() {
        return inskription;
    }

    public void setInskription(String inskription) {
        this.inskription = inskription;
    }

    @Override
    public String toString() {
        return "Inskription_linje{" + "linje_nr=" + linje_nr + ", inskription_id=" + inskription_id + ", linje_type=" + linje_type + ", inskription=" + inskription + '}';
    }
    
}
