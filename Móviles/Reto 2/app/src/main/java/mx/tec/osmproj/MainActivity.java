package mx.tec.osmproj;
// Code Challenge
// Leverage the following code to create a "Panic Button" application.
// In a first activity, you should simply add a button to trigger an alarm.
// In a successive activity, you should obtain your position from the GPS antenna
// and render an OpenStreetMaps and place a marker in your position. Finally
// you should provide the means to feed a destination number to send a pre-defined
// SOS message via SMS Management.

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;


public class MainActivity extends AppCompatActivity implements LocationListener {
    protected LocationManager locationManager;
    protected Context context;
    private MapView map;
    private IMapController mapController;
        @Override public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //Location Based Services require "hot permission granting" upon installing the app
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET}, 1);
            }

            //This prepares OpenStreetMaps
            context = getApplicationContext();
            Configuration.getInstance().load(context, PreferenceManager.getDefaultSharedPreferences(context));

            setContentView(R.layout.activity_main);

            //This renders the Map
            map = findViewById(R.id.mapView);
            map.setTileSource(TileSourceFactory.MAPNIK);
            map.setMultiTouchControls(true);
            mapController = map.getController();
            mapController.setZoom(20.00);
            GeoPoint startPoint = new GeoPoint(20.6133105, -100.4052627); //Hardcoded to Queretaro
            mapController.setCenter(startPoint);

            //This sets a Marker
            Marker startMarker = new Marker(map);
            startMarker.setPosition(startPoint);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            map.getOverlays().add(startMarker);
    }

    @Override
    public void onLocationChanged(Location location) {
        //
    }

    @Override
    public void onProviderDisabled(String provider) {
        //
    }

    @Override
    public void onProviderEnabled(String provider) {
        //
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //
    }

}