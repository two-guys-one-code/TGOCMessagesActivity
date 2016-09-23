package chat.tgoc.com.tgocfirebase;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.tgoc.tgocmessage.BubbleType;
import br.com.tgoc.tgocmessage.TGOCAvatarInterface;
import br.com.tgoc.tgocmessage.TGOCBubble;
import br.com.tgoc.tgocmessage.TGOCBubbleFactory;
import br.com.tgoc.tgocmessage.TGOCBubbleInterface;
import br.com.tgoc.tgocmessage.TGOCMessageActivity;
import br.com.tgoc.tgocmessage.TGOCMessageActivityInterface;
import br.com.tgoc.tgocmessage.TGOCMessageBubbleViewHolderInterface;
import br.com.tgoc.tgocmessage.TGOCMessageInterface;

public class ChatActivity extends TGOCMessageActivity implements TGOCMessageActivityInterface {

    String sender_id = FirebaseAuth.getInstance().getCurrentUser().getUid();

    public List<TGOCMessageInterface> messages = new ArrayList<>();

    TGOCBubble outgoingBubble;
    TGOCBubble incomingBubble;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference messageRef;
    DatabaseReference userIsTypingRef;
    Query usersTypingQuery;

    private boolean localTyping = false;

    public void setTyping(boolean typing) {
        localTyping = typing;
        userIsTypingRef.setValue(typing);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageRef = ref.child("messages");
        setTitle("TGOCFirebase");

        super.init(this);

        this.tgocEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setTyping(charSequence.length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        initBubbleMessages();
        this.tgocRecycleView.setBackgroundColor(Color.WHITE);
    }

    public void initBubbleMessages() {
        outgoingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.OUTGOING, "#3F51B5");
        incomingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.INCOMING, "#FAFFFF");

        this.typingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.TYPING, "#FAFFFF");
    }

    @Override
    protected void onStart() {
        super.onStart();
        observeMessages();
        observeTyping();
    }

    @Override
    public int numberOfItemsInConversation() {
        return messages.size();
    }

    @Override
    public TGOCBubbleInterface messageBubbleAtPosition(int i) {
        final TGOCMessageInterface message = this.messages.get(i);

        if (sender_id.matches(message.getSenderId()))
            return outgoingBubble;
        else
            return incomingBubble;
    }

    @Override
    public TGOCAvatarInterface avatarAtPosition(int i) {
        return null;
    }

    @Override
    public TGOCMessageInterface messageDataAtPosition(int i) {
        return messages.get(i);
    }

    @Override
    public void bindViewHolderAtPosition(TGOCMessageBubbleViewHolderInterface tgocMessageBubbleViewHolderInterface, int i) {
        final TGOCMessageInterface message = this.messages.get(i);

        if (sender_id.matches(message.getSenderId()))
            tgocMessageBubbleViewHolderInterface.getTextView().setTextColor(Color.parseColor("#ffffff"));
        else
            tgocMessageBubbleViewHolderInterface.getTextView().setTextColor(Color.parseColor("#29353A"));
    }

    @Override
    public void didSelectMessage(TGOCMessageInterface tgocMessageInterface) {

    }

    @Override
    public void didPressSendButton(View view) {
        DatabaseReference itemRef = messageRef.push();

        Message m = new Message();
        m.setSenderId(sender_id);
        m.setText(this.tgocEditText.getText().toString());

        itemRef.setValue(m);
        setTyping(false);
        finishSendingMessage();
    }

    private void observeMessages() {
        Query recentPostsQuery = messageRef.limitToLast(25);
        recentPostsQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message message = dataSnapshot.getValue(Message.class);
                messages.add(message);
                finishReceivingMessage();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void observeTyping() {
        DatabaseReference typingIndicatorRef = ref.child("typingIndicator");
        userIsTypingRef = typingIndicatorRef.child(sender_id);
        userIsTypingRef.onDisconnect().removeValue();

        usersTypingQuery = typingIndicatorRef.orderByValue().equalTo(true);

        usersTypingQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.getChildrenCount() == 1 && localTyping) {
                    return;
                }

                setShowTypingIndicator(dataSnapshot.getChildrenCount() > 0);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
