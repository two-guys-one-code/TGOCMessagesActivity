package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 8/31/16.
 */
public class TGOCBubble implements TGOCBubbleInterface {

    int resource;

    public TGOCBubble(int resource) {
        this.resource = resource;
    }

    public TGOCBubble() {
        this.resource = 0;
    }

    @Override
    public int getResource() {
        return resource;
    }
}
