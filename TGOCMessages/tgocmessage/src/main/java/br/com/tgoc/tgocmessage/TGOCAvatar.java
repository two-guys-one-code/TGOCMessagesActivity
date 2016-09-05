package br.com.tgoc.tgocmessage;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCAvatar implements TGOCAvatarInterface {

    Bitmap avatar;

    public TGOCAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    @Override
    public <T> T getData() {
        return (T) avatar;
    }

    @Override
    public void bindImageView(ImageView imageView) {
        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(imageView.getResources(), avatar);
        circularBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(circularBitmapDrawable);
    }
}