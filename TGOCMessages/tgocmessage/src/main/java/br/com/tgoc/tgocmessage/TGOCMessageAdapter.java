package br.com.tgoc.tgocmessage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessageAdapter extends RecyclerView.Adapter<TGOCMessageViewHolder> {

    TGOCMessageActivityInterface tgocMessageActivityInterface;

    public TGOCMessageAdapter(TGOCMessageActivityInterface kzMessageInterface) {
        this.tgocMessageActivityInterface = kzMessageInterface;
    }

    @Override
    public TGOCMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(tgocMessageActivityInterface.messageBubbleAtPosition(viewType).getResource(), parent, false);

        return new TGOCMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TGOCMessageViewHolder view, int position) {

        TGOCMessageInterface tgocMessageInterface = tgocMessageActivityInterface.messageDataAtPosition(position);

        if(tgocMessageInterface != null) {
            view.tgoc_message_text.setText(tgocMessageInterface.getText());
        }

        Glide.with(view.mView.getContext()).load(tgocMessageActivityInterface.avatarAtPosition(position).getData()).into(view.tgoc_avatar);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return tgocMessageActivityInterface.numberOfItemsInConversation();
    }

}
