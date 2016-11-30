package br.com.tgoc.tgocmessage;

import android.content.Context;
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
public class TGOCPhotoMediaItemTest {

    Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void test_nullPhotoFromResources() {
        TGOCPhotoMediaItem photo = new TGOCPhotoMediaItem(context.getResources(), R.drawable.ic_send_black_24dp);

        assertNotEquals(photo.getData(), null);
    }

    @Test
    public void test_nullPhotoFromBitmap() {
        TGOCPhotoMediaItem photo = new TGOCPhotoMediaItem(null);

        assertEquals(photo.getData(), null);
    }

    @Test
    public void test_photoView() {
        TGOCPhotoMediaItem photo = new TGOCPhotoMediaItem(context.getResources(), R.drawable.ic_send_black_24dp);

        assertNotEquals(photo.getView(context), null);
    }
}
