package br.com.tgoc.tgocmessage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessageAdapter extends RecyclerView.Adapter<TGOCMessageViewHolder> {

    TGOCMessageInterface tgocMessageInterface;

    public TGOCMessageAdapter(TGOCMessageInterface kzMessageInterface) {
        this.tgocMessageInterface = kzMessageInterface;
    }

    @Override
    public TGOCMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(tgocMessageInterface.messageBubbleResAtPosition(viewType), parent, false);

        return new TGOCMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TGOCMessageViewHolder holder, int position) {
        tgocMessageInterface.bindViewAtPosition(holder, position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return tgocMessageInterface.numberOfItemsInConversation();
    }

}
