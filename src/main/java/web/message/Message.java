package web.message;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 12.03.2017.
 */
@Getter @Setter
public class Message
{
    private String text;

    public void setText(String text) {
        this.text = text;
    }
}
