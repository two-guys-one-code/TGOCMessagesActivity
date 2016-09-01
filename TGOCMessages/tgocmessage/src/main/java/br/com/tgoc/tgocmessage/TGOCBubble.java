package br.com.tgoc.tgocmessage;

import android.graphics.drawable.Drawable;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCBubble implements TGOCBubbleInterface {

    int resource;
    String color;
    Drawable drawable;

    public TGOCBubble(int resource, String color, Drawable drawable) {
        this.resource = resource;
        this.color = color;
        this.drawable = drawable;
    }

    @Override
    public int getLayoutResource() {
        return resource;
    }

    @Override
    public Drawable getDrawable() {
        return drawable;
    }

}
