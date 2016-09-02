package br.com.tgoc.tgocmessage;

import java.util.Date;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public interface TGOCMessageInterface {
    int getSenderId();
    String getSenderDisplayName();
    Date getDate();
    String getText();
    boolean isMediaMessage();
    TGOCMessageMediaInterface getMedia();
}
