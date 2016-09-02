package br.com.tgoc.tgocmessage;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rodrigocavalcante on 9/1/16.
 */
public interface TGOCMessageBubbleViewHolderInterface {
    TextView getSenderTextView();
    TextView getTextView();
    TextView getTimeTextView();
    ImageView getAvatar();
}
