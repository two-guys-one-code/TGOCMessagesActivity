package br.com.tgoc.tgocmessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rodrigocavalcante on 9/5/16.
 */
public class TGOCTypingViewHolder extends RecyclerView.ViewHolder {

    protected final View mView;
    protected final TextView tgoc_message_text;
    protected final LinearLayout tgoc_bubble_layout;
    protected final ImageView tgoc_avatar;

    public TGOCTypingViewHolder(View view) {
        super(view);
        mView = view;
        tgoc_message_text = (TextView) view.findViewById(R.id.tgoc_message_text);
        tgoc_bubble_layout = (LinearLayout) view.findViewById(R.id.tgoc_bubble_layout);
        tgoc_avatar = (ImageView) view.findViewById(R.id.tgoc_avatar);
    }

    public TextView getTextView() {
        return tgoc_message_text;
    }

    public ImageView getAvatar() {
        return tgoc_avatar;
    }
}
