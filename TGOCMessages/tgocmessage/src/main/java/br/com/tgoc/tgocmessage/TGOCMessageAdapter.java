package br.com.tgoc.tgocmessage;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessageAdapter extends RecyclerView.Adapter<TGOCMessageBubbleViewHolder> {

    TGOCMessageActivityInterface tgocMessageActivityInterface;

    public TGOCMessageAdapter(TGOCMessageActivityInterface tgocMessageInterface) {
        this.tgocMessageActivityInterface = tgocMessageInterface;
    }

    @Override
    public TGOCMessageBubbleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(tgocMessageActivityInterface.messageBubbleAtPosition(viewType).getLayoutResource(), parent, false);

        return new TGOCMessageBubbleViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return tgocMessageActivityInterface.numberOfItemsInConversation();
    }

    @Override
    public void onBindViewHolder(TGOCMessageBubbleViewHolder view, int position) {
        TGOCMessageInterface tgocMessageInterface = tgocMessageActivityInterface.messageDataAtPosition(position);
        bindMessageBubble(view, position, tgocMessageInterface);
        tgocMessageActivityInterface.bindViewHolderAtPosition(view, position);
    }

    public void bindMessageBubble(final TGOCMessageBubbleViewHolder view, int position, final TGOCMessageInterface tgocMessageInterface) {
        TGOCBubbleInterface tgocBubbleInterface = tgocMessageActivityInterface.messageBubbleAtPosition(position);
        view.tgoc_bubble_layout.getBackground().setColorFilter(tgocBubbleInterface.getColorFilter());

        if (tgocMessageInterface != null) {
            view.tgoc_message_text.setText(tgocMessageInterface.getText());
            Linkify.addLinks(view.tgoc_message_text, Linkify.ALL);

            if (tgocMessageInterface.getDate() != null) {
                view.tgoc_time_text.setVisibility(View.VISIBLE);
                view.tgoc_time_text.setText(DateFormat.getTimeFormat(view.mView.getContext()).format(tgocMessageInterface.getDate()));
            } else
                view.tgoc_time_text.setVisibility(View.GONE);
        }

        if (tgocMessageInterface.getSenderDisplayName() != null) {
            view.tgoc_sender_display_name.setVisibility(View.VISIBLE);
            view.tgoc_sender_display_name.setText(tgocMessageInterface.getSenderDisplayName());
        } else
            view.tgoc_sender_display_name.setVisibility(View.GONE);

        TGOCAvatarInterface tgocAvatarInterface = tgocMessageActivityInterface.avatarAtPosition(position);
        if (tgocAvatarInterface != null) {
            setRoudedAvatarInView(tgocAvatarInterface.getData(), view.tgoc_avatar);
        } else
            view.tgoc_avatar.setVisibility(View.GONE);

        if (tgocMessageInterface.isMediaMessage()) {
            view.tgoc_content.removeAllViews();

            View content = tgocMessageInterface.getMedia().getView(view.mView.getContext());

            view.tgoc_content.addView(content);

            content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tgocMessageActivityInterface.didSelectMessage(tgocMessageInterface);
                }
            });
        } else {
            view.tgoc_message_text.setOnClickListener(null);
        }
    }

    private void setRoudedAvatarInView(Bitmap bitmap, ImageView tgoc_avatar) {
        tgoc_avatar.setVisibility(View.VISIBLE);
        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(
                tgoc_avatar.getResources(), bitmap);
        circularBitmapDrawable.setCircular(true);
        tgoc_avatar.setImageDrawable(circularBitmapDrawable);
    }
}