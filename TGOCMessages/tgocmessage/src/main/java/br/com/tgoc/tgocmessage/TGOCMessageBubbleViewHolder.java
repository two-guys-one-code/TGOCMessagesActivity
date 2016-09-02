package br.com.tgoc.tgocmessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessageBubbleViewHolder extends RecyclerView.ViewHolder implements TGOCMessageBubbleViewHolderInterface {

    protected final View mView;
    protected final ImageView tgoc_avatar;
    protected final TextView tgoc_sender_display_name;
    protected final LinearLayout tgoc_bubble_layout;
    protected final TextView tgoc_time_text;
    protected final LinearLayout tgoc_content;
    protected final TextView tgoc_message_text;

    public TGOCMessageBubbleViewHolder(View view) {
        super(view);
        mView = view;
        tgoc_avatar = (ImageView) view.findViewById(R.id.tgoc_avatar);
        tgoc_sender_display_name = (TextView) view.findViewById(R.id.tgoc_sender_display_name);
        tgoc_bubble_layout = (LinearLayout) view.findViewById(R.id.tgoc_bubble_layout);
        tgoc_time_text = (TextView) view.findViewById(R.id.tgoc_message_time);
        tgoc_content = (LinearLayout) view.findViewById(R.id.tgoc_content);
        tgoc_message_text = (TextView) view.findViewById(R.id.tgoc_message_text);
    }

    @Override
    public TextView getSenderTextView() {
        return tgoc_sender_display_name;
    }

    @Override
    public TextView getTextView() {
        return tgoc_message_text;
    }

    @Override
    public TextView getTimeTextView() {
        return tgoc_time_text;
    }

    @Override
    public ImageView getAvatar() {
        return tgoc_avatar;
    }
}
