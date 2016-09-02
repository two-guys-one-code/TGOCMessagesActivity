package br.com.tgoc.tgocmessage;

import java.util.Date;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessage implements TGOCMessageInterface {

    int senderId;
    String senderDisplayName = null;
    Date date;
    String text;
    boolean isMediaMessage = false;
    TGOCMessageMediaInterface media;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TGOCMessage(int senderId, String text, String senderDisplayName, TGOCMessageMediaInterface media) {
        this.senderId = senderId;
        this.text = text;
        this.senderDisplayName = senderDisplayName;
        this.date = new Date();
        this.media = media;
        this.isMediaMessage = true;
    }

    public TGOCMessage(int senderId, String text, String senderDisplayName) {
        this.senderId = senderId;
        this.text = text;
        this.senderDisplayName = senderDisplayName;
        this.date = new Date();
    }

    public TGOCMessage(int senderId, String text) {
        this.senderId = senderId;
        this.text = text;
        this.date = new Date();
    }

    public TGOCMessage() {
        this.date = new Date();
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getSenderDisplayName() {
        return senderDisplayName;
    }

    public void setSenderDisplayName(String senderDisplayName) {
        this.senderDisplayName = senderDisplayName;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean isMediaMessage() {
        return isMediaMessage;
    }

    @Override
    public TGOCMessageMediaInterface getMedia() {
        return media;
    }

    public void setText(String text) {
        this.text = text;
    }
}
