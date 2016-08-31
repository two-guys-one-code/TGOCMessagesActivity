package br.com.tgoc.tgocmessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessageViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    public final TextView tgoc_message_text;
    public final ImageView tgoc_avatar;

    public TGOCMessageViewHolder(View view) {
        super(view);
        mView = view;
        tgoc_message_text = (TextView) view.findViewById(R.id.tgoc_message_text);
        tgoc_avatar = (ImageView) view.findViewById(R.id.tgoc_avatar);
    }

    @Override
    public String toString() {
        return super.toString() + " '" + tgoc_message_text.getText();
    }
}
