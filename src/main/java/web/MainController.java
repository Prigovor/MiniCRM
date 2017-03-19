package web;

import com.crm.database.entity.client.Client;
import com.crm.database.entity.order.Order;
import com.crm.database.entity.order.OrderStatus;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.database.validation.ValidationException;
import com.crm.managers.EmailManager;
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
@SessionAttributes(types = {Message.class, Client.class})
public class MainController
{
    private Client client;

    @RequestMapping(method = RequestMethod.GET)
    private String start()
    {
        client = new Client();

        return "index";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    private String signUp(String name, String surname, String password, String email, String phone, Message message)
    {
        try
        {
            Client client = new Client();

            client.setName(name);
            client.setSurname(surname);
            client.setPassword(password);
            client.setEmail(email);
            client.setPhone(phone);

            FactoryService.getClientService().saveEntry(client);

            EmailManager.getInstance().sendClientData(client, password);

            this.client = client;

            return "client-page";
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
                this.client = clientEntry;

                return "client-page";
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

    @RequestMapping(value = "/call-me", method = RequestMethod.GET)
    private String callMe()
    {
        Order order = new Order();

        order.setOrderStatus(OrderStatus.CALL_CLIENT);
        order.setClient(client);

        FactoryService.getOrderService().saveEntry(order);

        return "client-page";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    private String exit()
    {
        return "index";
    }

    @RequestMapping(value = "/confirm")
    private String confirm(SessionStatus sessionStatus)
    {
        sessionStatus.setComplete();

        return "index";
    }
}
