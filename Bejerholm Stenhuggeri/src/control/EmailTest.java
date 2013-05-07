/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author NiklasRenner
 */
public class EmailTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Email email = new Email(
                    "AnetteStidsing@hotmail.com",
                    "test",
                    "her er beskeden",
                    "NiklasRennerNielsen@gmail.com",
                    "483602!QuickzEpix");
            email.addAttachment("C:/Users/NiklasRenner/Desktop/2. Semester opgave/1_entiteter.sql");
            email.sendEmail();
        } catch (Exception ex) {
            System.out.println("fejl: " + ex);
        }
    }
}
