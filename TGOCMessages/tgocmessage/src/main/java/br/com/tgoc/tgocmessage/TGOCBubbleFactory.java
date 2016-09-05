package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 9/1/16.
 */
public class TGOCBubbleFactory {

    public static TGOCBubble bubbleWithHexColor(BubbleType type, String color) {

        switch (type) {
            case INCOMING: {
                return new TGOCBubble(R.layout.tgoc_in_message, color);
            }

            case OUTGOING: {
                return new TGOCBubble(R.layout.tgoc_out_message, color);
            }

            case TYPING: {
                return new TGOCBubble(R.layout.tgoc_typing_indicator, color);
            }

            default: {
                return null;
            }
        }
    }
}
