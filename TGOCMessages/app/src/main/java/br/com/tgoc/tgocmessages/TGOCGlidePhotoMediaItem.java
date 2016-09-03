package br.com.tgoc.tgocmessages;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import br.com.tgoc.tgocmessage.TGOCMessageMediaInterface;

/**
 * Created by rodrigocavalcante on 9/2/16.
 */
public class TGOCGlidePhotoMediaItem implements TGOCMessageMediaInterface {

    int resource = 0;
    String url;
    File file;
    Uri uri;

    public TGOCGlidePhotoMediaItem(File file) {
        this.file = file;
    }

    public TGOCGlidePhotoMediaItem(String url) {
        this.url = url;
    }

    public TGOCGlidePhotoMediaItem(int resource) {
        this.resource = resource;
    }

    public TGOCGlidePhotoMediaItem(Uri uri) {
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
        View view = LayoutInflater.from(context).inflate(br.com.tgoc.tgocmessage.R.layout.tgoc_photo_message_content, null);

        Glide.with(context).load(getData()).into((ImageView) view.findViewById(br.com.tgoc.tgocmessage.R.id.tgoc_message_photo));

        return view;
    }
}

