package br.com.tgoc.tgocmessage;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCBubble implements TGOCBubbleInterface {

    int resource;
    String color;

    public TGOCBubble(int resource, String color) {
        this.resource = resource;
        this.color = color;
    }

    @Override
    public int getLayoutResource() {
        return this.resource;
    }

    @Override
    public ColorFilter getColorFilter() {
        if (this.color == null || this.color.isEmpty()) {
            return null;
        }

        try {
            int iColor = Color.parseColor(this.color);

            int red = (iColor & 0xFF0000) / 0xFFFF;
            int green = (iColor & 0xFF00) / 0xFF;
            int blue = iColor & 0xFF;

            float[] matrix = {0, 0, 0, 0, red,
                    0, 0, 0, 0, green,
                    0, 0, 0, 0, blue,
                    0, 0, 0, 1, 0};

            return new ColorMatrixColorFilter(matrix);
        } catch (IllegalArgumentException expection) {
            return null;
        }
    }
}
