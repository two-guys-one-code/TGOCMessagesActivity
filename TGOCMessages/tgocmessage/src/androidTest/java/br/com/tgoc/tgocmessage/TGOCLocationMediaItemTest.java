package br.com.tgoc.tgocmessage;

import android.location.Location;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Rodrigo.Cavalcante on 30/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class TGOCLocationMediaItemTest {

    double lat = -1.0, lng = -48.0;
    LatLng latLng = null;

    @Before
    public void setup() {
        latLng = new LatLng(lat, lng);
    }

    @Test
    public void test_locationFromLocation() {
        Location location = new Location("provider");
        location.setLatitude(lat);
        location.setLongitude(lng);
        TGOCLocationMediaItem media = new TGOCLocationMediaItem(location);

        assertEquals(media.getData(), latLng);
    }

    @Test
    public void test_locationFromLatLng() {
        TGOCLocationMediaItem media = new TGOCLocationMediaItem(latLng);

        assertEquals(media.getData(), latLng);
    }
}
