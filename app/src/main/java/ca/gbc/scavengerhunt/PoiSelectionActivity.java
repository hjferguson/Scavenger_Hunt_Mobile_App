package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLngBounds;
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
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        ArrayList<PointOfInterest> pois = PoiUtils.createSamplePois();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        // Add markers for the POIs and include them in the bounds
        for (PointOfInterest poi : pois) {
            googleMap.addMarker(new MarkerOptions()
                    .position(poi.getCoordinates())
                    .title(poi.getName())
                    .snippet(poi.getDescription()));

            builder.include(poi.getCoordinates());
        }

        // Set up a ViewTreeObserver to wait for the layout
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // Older versions of Android (before API level 16)
                    mapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    adjustCameraPosition(builder);
                }
            });
        } else {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    adjustCameraPosition(builder);
                }
            });
        }
    }

    private void adjustCameraPosition(LatLngBounds.Builder builder) {
        LatLngBounds bounds = builder.build();
        int padding = 100; // Offset from edges of the map in pixels
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
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