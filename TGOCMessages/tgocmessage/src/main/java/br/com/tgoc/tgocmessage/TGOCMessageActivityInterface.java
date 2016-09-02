package br.com.tgoc.tgocmessage;

import android.view.View;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public interface TGOCMessageActivityInterface {

    int numberOfItemsInConversation();
    TGOCBubbleInterface messageBubbleAtPosition(int position);
    TGOCMessageAvatarInterface avatarAtPosition(int position);
    TGOCMessageInterface messageDataAtPosition(int position);
    void bindViewHolderAtPosition(TGOCMessageBubbleViewHolderInterface view, int position);
    void didSelectMessage(TGOCMessageInterface messageInterface);
    void didPressSendButton(View view);
}
