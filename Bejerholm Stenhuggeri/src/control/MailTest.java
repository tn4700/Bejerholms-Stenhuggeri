/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author NiklasRenner
 */
public class MailTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Mail mail = new Mail(
                    "AnetteStidsing@hotmail.com",
                    "test",
                    "her er beskeden",
                    "ProgrammeringTest@gmail.com",
                    "Hej12345");
            mail.addAttachment("build.xml");
            mail.sendEmail();
        } catch (Exception ex) {
            System.out.println("fejl: " + ex);
        }
    }
}
