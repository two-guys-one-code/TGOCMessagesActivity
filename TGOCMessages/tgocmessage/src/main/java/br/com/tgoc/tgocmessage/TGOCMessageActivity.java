package br.com.tgoc.tgocmessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class TGOCMessageActivity extends AppCompatActivity implements TGOCMessageActivityTypingInterface{

    protected RecyclerView tgocRecycleView;
    protected TGOCMessageAdapter adapter;
    protected EditText tgocEditText;

    protected String typingText = "Is typing...";
    private boolean showTypingIndicator = false;
    protected TGOCBubbleInterface typingBubble;
    protected TGOCAvatarInterface typingAvatar;

    public void setShowTypingIndicator(boolean showTypingIndicator) {
        this.showTypingIndicator = showTypingIndicator;

        if(this.adapter != null)
            this.adapter.notifyDataSetChanged();
        this.tgocRecycleView.smoothScrollToPosition(this.adapter.getItemCount());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tgocmessage);
        typingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.TYPING, "#FAFFFF");
    }

    public void init(TGOCMessageActivityInterface tgocMessageActivityInterface) {
        setRecyclerView(tgocMessageActivityInterface);
        setSendButton(tgocMessageActivityInterface);

        tgocEditText = (EditText) findViewById(R.id.tgoc_edittext);
    }

    public void setRecyclerView(TGOCMessageActivityInterface tgocMessageActivityInterface) {
        adapter = new TGOCMessageAdapter(tgocMessageActivityInterface, this);
        tgocRecycleView = (RecyclerView) findViewById(R.id.tgoc_recycleview);
        tgocRecycleView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager manager = new LinearLayoutManager(tgocRecycleView.getContext());
        manager.setStackFromEnd(true);
        tgocRecycleView.setLayoutManager(manager);
        tgocRecycleView.setAdapter(adapter);
    }

    public void setSendButton(final TGOCMessageActivityInterface tgocMessageActivityInterface) {
        ImageButton tgonSendButton = (ImageButton) findViewById(R.id.tgoc_imagebutton);
        tgonSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tgocMessageActivityInterface.didPressSendButton(view);
            }
        });
    }

    public void finishSendingMessage() {
        this.tgocEditText.setText("");
        this.adapter.notifyDataSetChanged();
        this.tgocRecycleView.smoothScrollToPosition(this.adapter.getItemCount());
    }

    public void finishReceivingMessage() {
        this.setShowTypingIndicator(false);
        this.adapter.notifyDataSetChanged();
        this.tgocRecycleView.smoothScrollToPosition(this.adapter.getItemCount());
    }

    @Override
    public boolean isTyping() {
        return showTypingIndicator;
    }

    @Override
    public TGOCBubbleInterface typingBubble() {
        return typingBubble;
    }

    @Override
    public String typingText() {
        return typingText;
    }

    @Override
    public TGOCAvatarInterface typingAvatar() {
        return typingAvatar;
    }
}
