package br.com.tgoc.tgocmessage;

import java.util.Date;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessage implements TGOCMessageInterface {

    String senderId;
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

    public TGOCMessage(String senderId, String text, String senderDisplayName, TGOCMessageMediaInterface media) {
        this.senderId = senderId;
        this.text = text;
        this.senderDisplayName = senderDisplayName;
        this.date = new Date();
        this.media = media;
        this.isMediaMessage = true;
    }

    public TGOCMessage(String senderId, String text, String senderDisplayName) {
        this.senderId = senderId;
        this.text = text;
        this.senderDisplayName = senderDisplayName;
        this.date = new Date();
    }

    public TGOCMessage(String senderId, String text) {
        this.senderId = senderId;
        this.text = text;
        this.date = new Date();
    }

    public TGOCMessage() {
        this.date = new Date();
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
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
