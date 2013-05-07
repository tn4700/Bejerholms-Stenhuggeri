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
                    "ProgrammeringTest@gmail.com",
                    "Hej12345");
            email.addAttachment("database/1_entiteter.sql");
            email.sendEmail();
        } catch (Exception ex) {
            System.out.println("fejl: " + ex);
        }
    }
}
