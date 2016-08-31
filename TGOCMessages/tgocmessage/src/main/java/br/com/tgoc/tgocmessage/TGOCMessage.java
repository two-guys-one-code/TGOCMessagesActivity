package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessage {

    int sender_id;
    String text;

    public TGOCMessage(int sender_id, String text) {
        this.sender_id = sender_id;
        this.text = text;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
