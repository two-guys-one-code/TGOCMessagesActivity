package br.com.tgoc.tgocmessage;

import android.support.test.runner.AndroidJUnit4;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by edgarcardoso on 30/10/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCBubbleFactoryTest {

    @Test
    public void test_incomingMessage() {
        TGOCBubble bubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.INCOMING, "");

        assertEquals(bubble.getLayoutResource(),R.layout.tgoc_in_message);
    }

    @Test
    public void test_outgoingMessage() {
        TGOCBubble bubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.OUTGOING, "");

        assertEquals(bubble.getLayoutResource(),R.layout.tgoc_out_message);
    }

    @Test
    public void test_typingMessage() {
        TGOCBubble bubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.TYPING, "");

        assertEquals(bubble.getLayoutResource(),R.layout.tgoc_typing_indicator);
    }

    @Test
    public void test_nullBubbleType() {
        TGOCBubble bubble = TGOCBubbleFactory.bubbleWithHexColor(null, "");

        assertEquals(bubble,null);
    }
}