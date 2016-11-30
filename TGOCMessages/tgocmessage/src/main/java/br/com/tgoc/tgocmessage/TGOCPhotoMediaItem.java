package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by rodrigocavalcante on 9/2/16.
 */
public class TGOCPhotoMediaItem implements TGOCMessageMediaInterface{

    Bitmap bitmap;

    public TGOCPhotoMediaItem(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public TGOCPhotoMediaItem(Resources res, int resource) {
        bitmap = BitmapFactory.decodeResource(res, resource);
    }

    @Override
    public <T> T getData() {
        return (T) bitmap;
    }

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tgoc_photo_message_content, null);

        ImageView tgoc_image = (ImageView) view.findViewById(R.id.tgoc_message_photo);

        if(bitmap != null) {
            tgoc_image.setImageBitmap(bitmap);
        }

        return view;
    }
}
