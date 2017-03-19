package web;

import com.crm.database.entity.client.Client;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.validation.ValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import web.message.Message;

/**
 * Created by Bohdan on 12.03.2017.
 */
@Controller
@RequestMapping(value = "/")
@SessionAttributes(types = {Message.class})
public class MainController
{
    @RequestMapping(method = RequestMethod.GET)
    private String start()
    {
        return "bootstrap";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    private String signUp(String name, String surname, String password, String email, Message message)
    {
        try
        {
            Client client = new Client();

            client.setName(name);
            client.setSurname(surname);
            client.setPassword(password);
            client.setEmail(email);

            FactoryService.getClientService().saveEntry(client);

            message.setText("Client successfully registered");
        }
        catch (ValidationException e)
        {
            message.setText(e.getMessage());
        }

        return "message";
    }

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    private String logIn(String email, String password, Message message)
    {
        Client clientEntry = FactoryService.getClientService().getEntryByField("email", email);

        if (clientEntry != null)
        {
            if (PasswordManager.getInstance().isPasswordCorrect(password, clientEntry.getPassword()))
            {
                message.setText("Client successfully logged in");
            }
            else
            {
                message.setText("Incorrect email or password");
            }
        }
        else
        {
            message.setText("Incorrect email or password");
        }

        return "message";
    }

    @RequestMapping(value = "/setClientData")
    private String confirm(SessionStatus sessionStatus)
    {
        sessionStatus.setComplete();

        return "index";
    }
}
