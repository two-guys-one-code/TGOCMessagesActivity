package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by edgarcardoso on 30/10/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCAvatarTest {

    Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void test_nullAvatarFromResources() {
        TGOCAvatar avatar = new TGOCAvatar(null, 0);

        assertEquals(avatar.getData(), null);
    }

    @Test
    public void test_nullAvatarWithBitmap() {
        TGOCAvatar avatar = new TGOCAvatar(null);

        assertEquals(avatar.getData(), null);
    }

    @Test
    public void test_avatarFromResources() {
        TGOCAvatar avatar = new TGOCAvatar(context.getResources(), R.drawable.ic_account_circle_black_36dp);

        assertNotEquals(avatar.getData(), null);
    }

    @Test
    public void test_avatarFromBitmap() {
        Bitmap image = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_account_circle_black_36dp);
        TGOCAvatar avatar = new TGOCAvatar(image);

        assertNotEquals(avatar.getData(), null);
    }

    @Test
    public void test_nullImageView() {
        TGOCAvatar avatar = new TGOCAvatar(null, 0);
        ImageView imageView = null;
        avatar.bindImageView(imageView);
    }

    @Test
    public void test_ImageView() {
        TGOCAvatar avatar = new TGOCAvatar(null, 0);
        ImageView imageView = new ImageView(context);
        avatar.bindImageView(imageView);
    }
}
