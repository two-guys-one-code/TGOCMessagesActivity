package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;

/**
 * Created by rodrigocavalcante on 9/1/16.
 */
public class TGOCBubbleFactory {

    public static TGOCBubble incomingBubbleWithColor(Context context, String color) {
        return new TGOCBubble(R.layout.tgoc_in_message, color, forResource(context, R.drawable.msg_in, color));
    }

    public static TGOCBubble outgoingBubbleWithColor(Context context, String color) {
        return new TGOCBubble(R.layout.tgoc_out_message, color, forResource(context, R.drawable.msg_out, color));
    }

    public static Drawable forResource(Context context, int resource, String color) {
        Drawable drawable = context.getResources().getDrawable(resource);
        fillDrawable(drawable, color);

        return drawable;
    }

    public static void fillDrawable(Drawable drawable, String color) {
        int iColor = Color.parseColor(color);

        int red   = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue  = iColor & 0xFF;

        float[] matrix = { 0, 0, 0, 0, red,
                0, 0, 0, 0, green,
                0, 0, 0, 0, blue,
                0, 0, 0, 1, 0 };

        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        drawable.setColorFilter(colorFilter);
    }
}
