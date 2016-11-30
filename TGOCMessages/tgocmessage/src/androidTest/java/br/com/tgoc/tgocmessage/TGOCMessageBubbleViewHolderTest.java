package br.com.tgoc.tgocmessage;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.LayoutInflater;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by Rodrigo.Cavalcante on 30/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCMessageBubbleViewHolderTest {

    TGOCMessageBubbleViewHolder holder;

    @Before
    public void setup() {
        View view = LayoutInflater.from(InstrumentationRegistry.getContext()).inflate(R.layout.tgoc_in_message, null);
        holder = new TGOCMessageBubbleViewHolder(view);
    }

    @Test
    public void test_textView() {
        assertNotEquals(holder.getTextView(), null);
    }

    @Test
    public void test_avatarView() {
        assertNotEquals(holder.getAvatar(), null);
    }

    @Test
    public void test_bubbleLayout() {
        assertNotEquals(holder.tgoc_bubble_layout, null);
    }

    @Test
    public void test_contentLayout() {
        assertNotEquals(holder.tgoc_content, null);
    }

    @Test
    public void test_senderDisplayNameView() {
        assertNotEquals(holder.getSenderTextView(), null);
    }

    @Test
    public void test_timeTextView() {
        assertNotEquals(holder.getTimeTextView(), null);
    }

}
