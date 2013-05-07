package control;

import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 *
 * @author NiklasRenner
 */
public class Mail {
    
    private final String port = "465";
    private final String host = "smtp.gmail.com";

    private String to;
    private String subject;
    private String text;
    private String user;
    private String password;
    
    private MimeMessage message;
    private Session session;
    private Multipart multipart;
    private BodyPart messageBodyPart;

    public Mail (String to,
            String subject,
            String text,
            String user,
            String password) throws MessagingException {

        this.to = to;
        this.subject = subject;
        this.text = text;
        this.user = user;
        this.password = password;
        
        contructMessage();
    }

    public final void contructMessage() throws MessagingException, AddressException {
        Properties properties = new Properties();
        multipart = new MimeMultipart();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.user", user);

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.debug", "false");
        properties.put("mail.smtp.socketFactory.port", port);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        session = Session.getDefaultInstance(properties, null);
        session.setDebug(true);

        message = new MimeMessage(session);
        message.setSubject(subject);
        message.setFrom(new InternetAddress(user));
        message.addRecipient(RecipientType.TO, new InternetAddress(to));
        message.addRecipient(RecipientType.BCC, new InternetAddress(user));

        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(text);
        multipart.addBodyPart(messageBodyPart);
    }

    public final void addAttachment(String filepath) throws MessagingException {
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filepath);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filepath);
        multipart.addBodyPart(messageBodyPart);
    }

    public final void sendEmail() throws MessagingException {
        message.setContent(multipart);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, user, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
