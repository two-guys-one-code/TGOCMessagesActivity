package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by rodrigocavalcante on 9/2/16.
 */
public class TGOCPhotoMediaItem implements TGOCMessageMediaInterface{

    Bitmap bitmap;

    Drawable drawable;

    int resource;

    public TGOCPhotoMediaItem(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public TGOCPhotoMediaItem(Drawable drawable) { this.drawable = drawable; }

    public TGOCPhotoMediaItem(int resource) { this.resource = resource; }

    @Override
    public <T> T getData() {
        if(bitmap != null)
            return (T) bitmap;

        if(drawable != null)
            return (T) drawable;

        if(resource != 0)
            return (T) Integer.valueOf(resource);

        return null;
    }

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tgoc_photo_message_content, null);

        ImageView tgoc_image = (ImageView) view.findViewById(R.id.tgoc_message_photo);

        if(bitmap != null) {
            tgoc_image.setImageBitmap(bitmap);
        } else if(drawable != null) {
            tgoc_image.setImageDrawable(drawable);
        } else if(resource != 0) {
            tgoc_image.setImageResource(resource);
        }

        return view;
    }
}
