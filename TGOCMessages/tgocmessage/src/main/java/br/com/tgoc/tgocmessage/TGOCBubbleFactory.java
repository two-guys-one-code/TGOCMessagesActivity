package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 9/1/16.
 */
public class TGOCBubbleFactory {

    public static TGOCBubble incomingBubbleWithHexColor(String color) {
        return new TGOCBubble(R.layout.tgoc_in_message, color);
    }

    public static TGOCBubble outgoingBubbleWithHexColor(String color) {
        return new TGOCBubble(R.layout.tgoc_out_message, color);
    }
}
