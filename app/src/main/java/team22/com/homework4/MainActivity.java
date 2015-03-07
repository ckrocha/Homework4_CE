package team22.com.homework4;

import android.content.Intent;
import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends Activity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main);
        //onMapReady(googleMap);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

/*
        LatLng sydney = new LatLng(-33.867, 151.206);*/

       // googleMap.setMyLocationEnabled(true);
     //  googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
            //  .getMap();
       // setUpMapIfNeeded();
      // googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
    }

/*
    @Override
    protected void onResume() {
        super.onResume();
       // setUpMapIfNeeded();
        mGoogleApiClient.connect();
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            //LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }*/

    //USed for a test of finding a specific point on the map
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-33.867, 151.206);
        LatLng UT = new LatLng(30.280654,-97.732764);
        LatLng LA = new LatLng(34.052234,-118.243685);

       //googleMap.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UT, 13));

        map.addMarker(new MarkerOptions()
                .title("Sydney")
                .snippet("The most populous city in Australia.")
                .position(sydney));

        map.addMarker(new MarkerOptions()
                .title("UT Austin")
                .snippet("The best school ever!")
                .position(UT));

        map.addMarker(new MarkerOptions()
                .title("Boeing Satellite Headquarters")
                .snippet("My new home!")
                .position(LA));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
   private void setUpMapIfNeeded() {
    // Do a null check to confirm that we have not already instantiated the map.
    if (googleMap == null) {
    // Try to obtain the map from the SupportMapFragment.
        googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
        // Check if we were successful in obtaining the map.
        if (googleMap != null) {setUpMap();}
        }
    }
*/
    private void setUpMap() {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
