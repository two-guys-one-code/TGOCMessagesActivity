package br.com.tgoc.tgocmessage;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by rodrigocavalcante on 9/3/16.
 */
public class TGOCLocationMediaItem implements TGOCMessageMediaInterface, OnMapReadyCallback {

    LatLng latLng;

    public TGOCLocationMediaItem(Location location) {
        this.latLng = new LatLng(location.getLatitude(), location.getLongitude());
    }

    public TGOCLocationMediaItem(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tgoc_location_message_content, null);

        MapView mapView = (MapView) view.findViewById(R.id.tgoc_map);
        mapView.onCreate(null);
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public <T> T getData() {
        return (T) latLng;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if(googleMap != null) {
            googleMap.clear();
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(this.latLng, 15f));
            googleMap.addMarker(new MarkerOptions().position(this.latLng));
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }
}
