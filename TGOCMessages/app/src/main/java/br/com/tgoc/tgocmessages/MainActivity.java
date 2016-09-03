package br.com.tgoc.tgocmessages;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.tgoc.tgocmessage.TGOCMessageAvatar;
import br.com.tgoc.tgocmessage.TGOCMessageAvatarInterface;
import br.com.tgoc.tgocmessage.TGOCBubble;
import br.com.tgoc.tgocmessage.TGOCBubbleFactory;
import br.com.tgoc.tgocmessage.TGOCBubbleInterface;
import br.com.tgoc.tgocmessage.TGOCMessage;
import br.com.tgoc.tgocmessage.TGOCMessageActivity;
import br.com.tgoc.tgocmessage.TGOCMessageActivityInterface;
import br.com.tgoc.tgocmessage.TGOCMessageInterface;
import br.com.tgoc.tgocmessage.TGOCPhotoMediaItem;
import br.com.tgoc.tgocmessage.TGOCMessageBubbleViewHolderInterface;

public class MainActivity extends TGOCMessageActivity implements TGOCMessageActivityInterface{

    int sender_id = 0;

    public List<TGOCMessage> messages = new ArrayList();

    TGOCBubble outgoingBubble = TGOCBubbleFactory.outgoingBubbleWithHexColor("#C7D6DA");
    TGOCBubble incomingBubble = TGOCBubbleFactory.incomingBubbleWithHexColor("#FAFFFF");
    TGOCMessageAvatar outgoingAvatar = new TGOCMessageAvatar(R.drawable.rod);
    TGOCMessageAvatar incomingAvatar = new TGOCMessageAvatar(R.drawable.ed);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.init(this);

        this.messages.add(new TGOCMessage(0, "Hi!", "Rodrigo", new TGOCPhotoMediaItem(R.drawable.rod)));
        this.messages.add(new TGOCMessage(1, "Hello!", "Edgar"));
        this.messages.add(new TGOCMessage(1, "How are you?", "Edgar"));
        this.messages.add(new TGOCMessage(0, "Fine. And you?", "Rodrigo"));
        this.messages.add(new TGOCMessage(1, "Great!", "Edgar"));
        this.messages.add(new TGOCMessage(0, "Lorem ipsum dolor sit amet, ad fabulas adipisci eum, solet voluptatum et cum, at brute maiorum deserunt ius. Ut mel elit delectus, id eum graecis antiopam. His ne aliquid sanctus, vis ex placerat interpretaris. Et quando maiestatis vis, cu amet alterum detracto sit, sit ex etiam legendos. Vim at novum persius hendrerit. Unum cotidieque eu mel.", "Rodrigo"));
        this.messages.add(new TGOCMessage(1, "Ponderum intellegat adipiscing mel cu, meliore patrioque eu mei. An est prima abhorreant. Id quo mediocrem erroribus. Nibh impetus te est, apeirian indoctum sadipscing et eum, et mollis aperiri meliore mel. Ne mundi dicant duo, qui zril definitionem eu", "Edgar"));
        this.messages.add(new TGOCMessage(1, "Call me 541-754-3010 and visit my web site www.website.com or email @ em@il.com", "Edgar"));
        this.messages.add(new TGOCMessage(0, "", "Rodrigo", new TGOCPhotoMediaItem("https://cdn.meme.am/images/1480924.jpg")));

        finishSendingMessage();
    }

    @Override
    public int numberOfItemsInConversation() {
        return this.messages.size();
    }

    @Override
    public TGOCMessageAvatarInterface avatarAtPosition(int position) {
        final TGOCMessage message = this.messages.get(position);

        if (sender_id == message.getSenderId())
            return outgoingAvatar;
        else
            return incomingAvatar;
    }

    @Override
    public TGOCMessageInterface messageDataAtPosition(int position) {
        return this.messages.get(position);
    }

    @Override
    public void bindViewHolderAtPosition(TGOCMessageBubbleViewHolderInterface view, int position) {

        //final TGOCMessage message = this.messages.get(position);

        //if (sender_id == message.getSenderId()) {
        view.getSenderTextView().setTextColor(Color.parseColor("#29353A"));
        view.getTextView().setTextColor(Color.parseColor("#29353A"));
        //}
    }

    @Override
    public void didSelectMessage(TGOCMessageInterface messageInterface) {
        System.out.println(messageInterface.getSenderDisplayName()+": "+messageInterface.getText());
    }

    @Override
    public TGOCBubbleInterface messageBubbleAtPosition(int position) {
        final TGOCMessage message = this.messages.get(position);

        if (sender_id == message.getSenderId())
            return outgoingBubble;
        else
            return incomingBubble;
    }

    @Override
    public void didPressSendButton(View view) {
        this.messages.add(new TGOCMessage(0, this.tgocEditText.getText().toString(), "Rodrigo"));
        this.finishSendingMessage();
    }
}
