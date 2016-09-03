package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 9/1/16.
 */
public class TGOCBubbleFactory {

    public static TGOCBubble bubbleWithHexColor(BubbleType type, String color) {
        if (type == BubbleType.INCOMING)
            return new TGOCBubble(R.layout.tgoc_in_message, color);
        else
            return new TGOCBubble(R.layout.tgoc_out_message, color);
    }
}
