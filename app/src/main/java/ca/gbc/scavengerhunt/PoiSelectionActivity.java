package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import ca.gbc.scavengerhunt.POI.PoiUtils;
import ca.gbc.scavengerhunt.POI.PointOfInterest;


public class PoiSelectionActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_selection);

        ImageButton poiSelectBackButton = findViewById(R.id.poi_select_back_button);
        ImageButton huntDetailsButton = findViewById(R.id.hunt_details_butt);
        ImageButton savedButton = findViewById(R.id.saved_butt);

        poiSelectBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to PoiInfoActivity
                Intent intent = new Intent(PoiSelectionActivity.this, MainActivity.class);
                // Start the PoiInfoActivity
                startActivity(intent);
            }
        });
        huntDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to PoiInfoActivity
                Intent intent = new Intent(PoiSelectionActivity.this, PoiInfoActivity.class);
                // Start the PoiInfoActivity
                startActivity(intent);
            }
        });

        savedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to CompletedHuntsActivity
                Intent intent = new Intent(PoiSelectionActivity.this, CompletedHuntsActivity.class);
                // Start the CompletedHuntsActivity
                startActivity(intent);
            }
        });

        mapView = findViewById(R.id.mapView);
        if(mapView != null){
            mapView.onCreate(savedInstanceState);
            mapView.getMapAsync(this);
            MapsInitializer.initialize(this);
        }



    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        this.googleMap = googleMap;

        //use function I wrote to generate fake POIs
        ArrayList<PointOfInterest> pois = PoiUtils.createSamplePois();

        //add markers for the POIs
        for(PointOfInterest poi : pois){
            googleMap.addMarker(new MarkerOptions()
                    .position(poi.getCoordinates())
                    .title(poi.getName())
                    .snippet(poi.getDescription()));
        }

        if(!pois.isEmpty()){
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pois.get(0).getCoordinates(), 10));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}