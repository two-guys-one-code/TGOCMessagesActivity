package br.com.tgoc.tgocmessage;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rodrigo.Cavalcante on 30/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCMessageTest {

    TGOCMessage message;

    @Before
    public void setup() {}

    @Test
    public void test_date() {
        message = new TGOCMessage();

        assertNotEquals(message.getDate(), null);
    }

    @Test
    public void test_senderID() {
        message = new TGOCMessage("id", null);

        assertEquals(message.getSenderId(), "id");
    }

    @Test
    public void test_nullSenderID() {
        message = new TGOCMessage(null, null);

        assertEquals(message.getSenderId(), null);
    }

    @Test
    public void test_text() {
        message = new TGOCMessage(null, "text");

        assertEquals(message.getText(), "text");
    }

    @Test
    public void test_nullText() {
        message = new TGOCMessage(null, null);

        assertEquals(message.getText(), null);
    }

    @Test
    public void test_senderDisplayName() {
        message = new TGOCMessage(null, null, "display name");

        assertEquals(message.getSenderDisplayName(), "display name");
    }

    @Test
    public void test_nullSenderDisplayName() {
        message = new TGOCMessage(null, null, null);

        assertEquals(message.getSenderDisplayName(), null);
    }

    @Test
    public void test_falseIsMediaType() {
        message = new TGOCMessage();

        assertFalse(message.isMediaMessage());
    }

    @Test
    public void test_nullMedia() {
        message = new TGOCMessage(null, null, null, null);

        assertFalse(message.isMediaMessage());
    }
}
