package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public interface TGOCMessageInterface {

    int numberOfItemsInConversation();
    int messageBubbleResAtPosition(int position);
    void bindViewAtPosition(TGOCMessageViewHolder view, int position);
}
