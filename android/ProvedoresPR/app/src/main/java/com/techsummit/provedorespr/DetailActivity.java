package com.techsummit.provedorespr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class DetailActivity extends ActionBarActivity {


    String mName, mSpeciality, mState, mCounty, mPhone, mAdress,
            mLat, mLon, mSuperSpeciality;

    Button callButton;

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //fetch extras from intent first.
        prepareExtras(getIntent());

        //headers
        getSupportActionBar().setTitle(mName);
        getSupportActionBar().setSubtitle(mSpeciality);

        //google maps
        setUpMapIfNeeded();

        callButton = (Button) findViewById(R.id.callButton);
        callButton.setText("Llamar " + mPhone);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + mPhone));
                startActivity(callIntent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        mMap = null;
        super.onDestroy();

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        setUpMapIfNeeded();
    }

    private void prepareExtras(Intent intent) {
        mName = intent.getStringExtra("name");
        mLat = intent.getStringExtra("lat");
        mLon = intent.getStringExtra("lon");
        mSpeciality = intent.getStringExtra("speciality");
        mAdress = intent.getStringExtra("address");
        mCounty = intent.getStringExtra("county");
        mPhone = intent.getStringExtra("phone");
        mState = intent.getStringExtra("state");
        mSuperSpeciality = intent.getStringExtra("superSpeciality");
        //array of coords
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            shareProvider();
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareProvider() {
        String shareBody = mSpeciality + " " + mAdress + " " + mPhone;
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, mName);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMap() {
        double lat = Double.parseDouble(mLat);
        double lon = Double.parseDouble(mLon);

        LatLng latLng = new LatLng(lat, lon);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
        mMap.addMarker(new MarkerOptions()
                .position(latLng).title(mName + " - " + mSpeciality));

    }
}
