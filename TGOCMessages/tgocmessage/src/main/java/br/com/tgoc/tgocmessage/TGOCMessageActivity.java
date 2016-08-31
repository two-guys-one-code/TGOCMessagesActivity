package br.com.tgoc.tgocmessage;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class TGOCMessageActivity extends AppCompatActivity implements TGOCMessageInterface{

    public List<TGOCMessage> messages;
    public RecyclerView tgocRecycleView;
    public TGOCMessageAdapter adapter;
    public EditText tgocEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tgocmessage);

        messages = new ArrayList();

        adapter = new TGOCMessageAdapter(this);

        tgocRecycleView = (RecyclerView) findViewById(R.id.tgoc_recycleview);
        tgocRecycleView.setItemAnimator(new DefaultItemAnimator());
        tgocRecycleView.setLayoutManager(new LinearLayoutManager(tgocRecycleView.getContext()));
        tgocRecycleView.setAdapter(adapter);

        tgocEditText = (EditText) findViewById(R.id.tgoc_edittext);
    }

    @Override
    public int numberOfItemsInConversation() {
        return messages.size();
    }

    @Override
    public void bindViewAtPosition(TGOCMessageViewHolder view, int position) {

    }

    @Override
    public int messageBubbleResAtPosition(int position) {
        return R.layout.tgoc_out_message;
    }

    public void sendButtonClicked(View view) {

    }

    public void finishSendingMessage() {
        this.tgocEditText.setText("");
        this.adapter.notifyDataSetChanged();
        this.tgocRecycleView.smoothScrollToPosition(this.adapter.getItemCount());
    }
}
