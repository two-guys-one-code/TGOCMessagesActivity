package br.com.tgoc.tgocmessages;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import br.com.tgoc.tgocmessage.TGOCAvatarInterface;

/**
 * Created by rodrigocavalcante on 9/5/16.
 */
public class TGOCGlideAvatar implements TGOCAvatarInterface{

    String url;
    Context context;

    public TGOCGlideAvatar(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    public <T> T getData() {
        if(url != null)
            return (T) url;

        return null;
    }

    @Override
    public void bindImageView(final ImageView imageView) {
        Glide.with(context).load(url).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
