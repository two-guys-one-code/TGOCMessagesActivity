package br.com.tgoc.tgocmessage;

import android.view.View;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public interface TGOCMessageActivityInterface {

    int numberOfItemsInConversation();
    TGOCBubbleInterface messageBubbleAtPosition(int position);
    TGOCAvatarInterface avatarAtPosition(int position);
    TGOCMessageInterface messageDataAtPosition(int position);

    void sendButtonClick(View view);
}
