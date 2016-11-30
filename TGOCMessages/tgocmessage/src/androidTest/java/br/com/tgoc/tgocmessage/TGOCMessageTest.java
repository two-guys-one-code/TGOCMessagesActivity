package br.com.tgoc.tgocmessage;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Rodrigo.Cavalcante on 30/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCMessageTest {

    TGOCMessage message = null;

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

        assertEquals(message.senderId, "id");
    }

    @Test
    public void test_nullSenderID() {
        message = new TGOCMessage(null, null);

        assertEquals(message.senderId, null);
    }

    @Test
    public void test_text() {
        message = new TGOCMessage(null, "text");

        assertEquals(message.text, "text");
    }

    @Test
    public void test_nullText() {
        message = new TGOCMessage(null, null);

        assertEquals(message.text, null);
    }

    @Test
    public void test_senderDisplayName() {
        message = new TGOCMessage(null, null, "display name");

        assertEquals(message.senderDisplayName, "display name");
    }

    @Test
    public void test_nullSenderDisplayName() {
        message = new TGOCMessage(null, null, null);

        assertEquals(message.senderDisplayName, null);
    }

    @Test
    public void test_falseIsMediaType() {
        message = new TGOCMessage();

        assertEquals(message.isMediaMessage, false);
    }

    @Test
    public void test_isMediaType() {
        message = new TGOCMessage(null, null, null, null);

        assertEquals(message.isMediaMessage, true);
    }
}
