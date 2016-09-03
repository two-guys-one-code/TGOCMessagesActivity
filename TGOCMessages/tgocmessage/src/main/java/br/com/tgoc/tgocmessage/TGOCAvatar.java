package br.com.tgoc.tgocmessage;

import android.graphics.Bitmap;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCAvatar implements TGOCAvatarInterface {

    Bitmap avatar;

    public TGOCAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    @Override
    public Bitmap getData() {
        return avatar;
    }
}