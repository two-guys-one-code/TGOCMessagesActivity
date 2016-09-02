package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by rodrigocavalcante on 9/2/16.
 */
public class TGOCPhotoMediaItem implements TGOCMessageMediaInterface{

    int resource = 0;
    String url;
    File file;
    Uri uri;

    public TGOCPhotoMediaItem(File file) {
        this.file = file;
    }

    public TGOCPhotoMediaItem(String url) {
        this.url = url;
    }

    public TGOCPhotoMediaItem(int resource) {
        this.resource = resource;
    }

    public TGOCPhotoMediaItem(Uri uri) {
        this.uri = uri;
    }

    @Override
    public <T> T getData() {
        if(url != null)
            return (T) url;

        if(file != null)
            return (T) file;

        if(resource != 0)
            return (T) Integer.valueOf(resource);

        if(uri != null)
            return (T) uri;

        return null;
    }

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tgoc_photo_message_content, null);

        Glide.with(context).load(getData()).into((ImageView) view.findViewById(R.id.tgoc_message_photo));

        return view;
    }
}
