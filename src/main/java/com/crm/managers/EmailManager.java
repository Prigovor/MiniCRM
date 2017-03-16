package com.crm.managers;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.client.Client;
import com.crm.database.service.FactoryService;

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
                e.printStackTrace();
            }
            catch (MessagingException e)
            {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendAccountData(Account account, String generatedPassword)
    {
        if (FactoryService.getAccountService().getEntryByField("login", account.getLogin()) != null)
        {
            sendMessage(account.getEmail(), "Your login and password from mini.crm account",
                    String.format("Login: %s, Password: %s", account.getLogin(), generatedPassword));
        }
    }

    public void sendClientData(Client client, String generatedPassword)
    {
        if (FactoryService.getClientService().getEntryByField("email", client.getEmail()) != null)
        {
            sendMessage(client.getEmail(), "Your password from mini.crm account",
                    String.format("Password: %s", generatedPassword));
        }
    }
}
