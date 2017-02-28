package com.crm.managers;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Prigovor on 11.02.2017.
 */
public class EmailManager
{
    private static final EmailManager ourInstance = new EmailManager();

    public static EmailManager getInstance()
    {
        return ourInstance;
    }

    private EmailManager()
    {
    }

    public void sendMessage(final String emailTo, final String subject, final String message)
    {
        new Thread(() ->
        {
            final String username = "company.mini.crm";
            final String password = "HobbitsAreBastards";

            String host = "smtp.gmail.com";

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(username, password);
                }
            });

            String from = "company.mini.crm@gmail.com";

            MimeMessage mimeMessage = new MimeMessage(session);

            try
            {
                mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));

                mimeMessage.setSubject(subject);
                mimeMessage.setText(message);

                Transport.send(mimeMessage);
            }
            catch (AddressException e)
            {

            }
            catch (MessagingException e)
            {

            }
        }).start();
    }
}
