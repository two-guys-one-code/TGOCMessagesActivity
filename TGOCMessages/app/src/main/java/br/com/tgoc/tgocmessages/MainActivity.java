package br.com.tgoc.tgocmessages;

import android.os.Bundle;
import android.view.View;

import br.com.tgoc.tgocmessage.TGOCMessage;
import br.com.tgoc.tgocmessage.TGOCMessageActivity;
import br.com.tgoc.tgocmessage.TGOCMessageViewHolder;

public class MainActivity extends TGOCMessageActivity {

    int sender_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.messages.add(new TGOCMessage(0, "Hi!"));
        this.messages.add(new TGOCMessage(1, "Hello!"));
        this.messages.add(new TGOCMessage(1, "How are you?"));
        this.messages.add(new TGOCMessage(0, "Fine, and you?"));
        this.messages.add(new TGOCMessage(1, "Great!"));
        this.messages.add(new TGOCMessage(0, "Lorem ipsum dolor sit amet, ad fabulas adipisci eum, solet voluptatum et cum, at brute maiorum deserunt ius. Ut mel elit delectus, id eum graecis antiopam. His ne aliquid sanctus, vis ex placerat interpretaris. Et quando maiestatis vis, cu amet alterum detracto sit, sit ex etiam legendos. Vim at novum persius hendrerit. Unum cotidieque eu mel."));
        this.messages.add(new TGOCMessage(1, "Ponderum intellegat adipiscing mel cu, meliore patrioque eu mei. An est prima abhorreant. Id quo mediocrem erroribus. Nibh impetus te est, apeirian indoctum sadipscing et eum, et mollis aperiri meliore mel. Ne mundi dicant duo, qui zril definitionem eu"));

        finishSendingMessage();
    }

    @Override
    public void bindViewAtPosition(TGOCMessageViewHolder view, int position) {
        super.bindViewAtPosition(view, position);

        final TGOCMessage message = this.messages.get(position);

        view.tgoc_message_text.setText(message.getText());

        if (sender_id == message.getSender_id())
            view.tgoc_avatar.setImageResource(R.drawable.rod);
        else
            view.tgoc_avatar.setImageResource(R.drawable.ed);
    }

    @Override
    public int messageBubbleResAtPosition(int position) {
        final TGOCMessage message = this.messages.get(position);

        if (sender_id == message.getSender_id())
            return R.layout.tgoc_out_message;
        else
            return R.layout.tgoc_in_message;
    }

    @Override
    public void sendButtonClicked(View view) {
        this.messages.add(new TGOCMessage(0, this.tgocEditText.getText().toString()));
        this.finishSendingMessage();
    }
}
