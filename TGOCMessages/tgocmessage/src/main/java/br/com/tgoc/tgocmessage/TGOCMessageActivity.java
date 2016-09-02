package br.com.tgoc.tgocmessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class TGOCMessageActivity extends AppCompatActivity {

    protected RecyclerView tgocRecycleView;
    protected TGOCMessageAdapter adapter;
    protected EditText tgocEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tgocmessage);
    }

    public void init(final TGOCMessageActivityInterface tgocMessageActivityInterface) {
        adapter = new TGOCMessageAdapter(tgocMessageActivityInterface);

        tgocRecycleView = (RecyclerView) findViewById(R.id.tgoc_recycleview);
        tgocRecycleView.setItemAnimator(new DefaultItemAnimator());
        tgocRecycleView.setLayoutManager(new LinearLayoutManager(tgocRecycleView.getContext()));
        tgocRecycleView.setAdapter(adapter);

        tgocEditText = (EditText) findViewById(R.id.tgoc_edittext);

        ImageButton tgonSendButton = (ImageButton) findViewById(R.id.tgoc_imagebutton);
        tgonSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tgocMessageActivityInterface.didPressSendButton(view);
            }
        });

        tgocRecycleView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                tgocRecycleView.scrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }

    public void finishSendingMessage() {
        this.tgocEditText.setText("");
        this.adapter.notifyDataSetChanged();
        this.tgocRecycleView.smoothScrollToPosition(this.adapter.getItemCount());
    }
}
