package br.com.tgoc.tgocmessage;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by edgarcardoso on 30/10/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCBubbleTest {

    @Test
    public void test_getColorFilterEmptyStringColor() {
        TGOCBubble bubble = new TGOCBubble(0, "");
        bubble.getColorFilter();
    }

    @Test
    public void test_getColorFilterNullColor() {
        TGOCBubble bubble = new TGOCBubble(0, null);
        bubble.getColorFilter();
    }

    @Test
    public void test_getColorFilterNonColorString() {
        TGOCBubble bubble = new TGOCBubble(0, "r32r3fhwoe");
        bubble.getColorFilter();
    }

    @Test
    public void test_getColorFilter() {
        TGOCBubble bubble = new TGOCBubble(0, "#FFFFFF");
        bubble.getColorFilter();
    }
}
