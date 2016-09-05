package br.com.tgoc.tgocmessage;

import android.widget.ImageView;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public interface TGOCAvatarInterface {
    <T> T getData();
    void bindImageView(ImageView imageView);
}
