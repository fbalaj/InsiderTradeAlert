package org.main;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.*;

public class EmailAlert {
    // Sender email account info. Left blank for github
    final String username = "";
    final String password = "";


    protected Properties properties = new Properties();
    protected Session session;
    protected Message message;

    // Set properties according to the sender email client
    public void setUp() throws MessagingException, IOException {
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls.enable", "true");
        this.properties.put("mail.smtp.host", "smtp.office365.com");
        this.properties.put("mail.smtp.port", "587");

        this.session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        this.message = new MimeMessage(session);
        this.message.setFrom(new InternetAddress(username));

        // Recipient email address. Left blank for github
        this.message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(""));

    }
}
