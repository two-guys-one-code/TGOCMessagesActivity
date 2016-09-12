package chat.tgoc.com.tgocfirebase;

import java.util.Date;

import br.com.tgoc.tgocmessage.TGOCMessageInterface;
import br.com.tgoc.tgocmessage.TGOCMessageMediaInterface;

/**
 * Created by rodrigocavalcante on 9/12/16.
 */
public class Message implements TGOCMessageInterface {

    String senderId;
    String text;

    public String getSenderId() {
        return senderId;
    }

    @Override
    public String getSenderDisplayName() {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean isMediaMessage() {
        return false;
    }

    @Override
    public TGOCMessageMediaInterface getMedia() {
        return null;
    }

    public void setText(String text) {
        this.text = text;
    }
}
