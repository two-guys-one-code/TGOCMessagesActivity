package br.com.tgoc.tgocmessage;

import java.io.File;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCMessageAvatar implements TGOCMessageAvatarInterface {

    int resource;
    String url;
    File file;

    public TGOCMessageAvatar(int resource) {
        this.resource = resource;
    }

    public TGOCMessageAvatar(String url) {
        this.url = url;
    }

    public TGOCMessageAvatar(File file) {
        this.file = file;
    }

    public TGOCMessageAvatar() {
        this.resource = 0;
    }

    @Override
    public <T> T getData() {
        if(url != null)
            return (T) url;

        if(file != null)
            return (T) file;

        if(resource != 0)
            return (T) Integer.valueOf(resource);

        return null;
    }
}
