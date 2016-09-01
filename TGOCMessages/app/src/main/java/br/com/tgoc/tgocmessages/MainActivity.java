package br.com.tgoc.tgocmessages;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.tgoc.tgocmessage.TGOCAvatar;
import br.com.tgoc.tgocmessage.TGOCAvatarInterface;
import br.com.tgoc.tgocmessage.TGOCBubble;
import br.com.tgoc.tgocmessage.TGOCBubbleInterface;
import br.com.tgoc.tgocmessage.TGOCMessage;
import br.com.tgoc.tgocmessage.TGOCMessageActivity;
import br.com.tgoc.tgocmessage.TGOCMessageActivityInterface;
import br.com.tgoc.tgocmessage.TGOCMessageInterface;

public class MainActivity extends TGOCMessageActivity implements TGOCMessageActivityInterface{

    int sender_id = 0;

    public List<TGOCMessage> messages = new ArrayList();

    TGOCBubble outgoingBubble = new TGOCBubble(R.layout.tgoc_out_message);
    TGOCBubble incomingBubble = new TGOCBubble(R.layout.tgoc_in_message);
    TGOCAvatar outgoingAvatar = new TGOCAvatar(R.drawable.rod);
    TGOCAvatar incomingAvatar = new TGOCAvatar(R.drawable.ed);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.init(this);

        this.messages.add(new TGOCMessage(0, "<b>Hi!</b>", "Rodrigo"));
        this.messages.add(new TGOCMessage(1, "Hello!", "Edgar"));
        this.messages.add(new TGOCMessage(1, "How are you?"));
        this.messages.add(new TGOCMessage(0, "Fine. And you?", "Rodrigo"));
        this.messages.add(new TGOCMessage(1, "Great!"));
        this.messages.add(new TGOCMessage(0, "Lorem ipsum dolor sit amet, ad fabulas adipisci eum, solet voluptatum et cum, at brute maiorum deserunt ius. Ut mel elit delectus, id eum graecis antiopam. His ne aliquid sanctus, vis ex placerat interpretaris. Et quando maiestatis vis, cu amet alterum detracto sit, sit ex etiam legendos. Vim at novum persius hendrerit. Unum cotidieque eu mel.", "Rodrigo"));
        this.messages.add(new TGOCMessage(1, "Ponderum intellegat adipiscing mel cu, meliore patrioque eu mei. An est prima abhorreant. Id quo mediocrem erroribus. Nibh impetus te est, apeirian indoctum sadipscing et eum, et mollis aperiri meliore mel. Ne mundi dicant duo, qui zril definitionem eu"));
        this.messages.add(new TGOCMessage(1, "Call me 988888888 and visit my web site www.website.com"));

        finishSendingMessage();
    }

    @Override
    public int numberOfItemsInConversation() {
        return this.messages.size();
    }

    @Override
    public TGOCAvatarInterface avatarAtPosition(int position) {
        final TGOCMessage message = this.messages.get(position);

        if (sender_id == message.getSenderId())
            return null;
        else
            return incomingAvatar;
    }

    @Override
    public TGOCMessageInterface messageDataAtPosition(int position) {
        return this.messages.get(position);
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
    public void sendButtonClick(View view) {
        this.messages.add(new TGOCMessage(0, this.tgocEditText.getText().toString()));
        this.finishSendingMessage();
    }

}
