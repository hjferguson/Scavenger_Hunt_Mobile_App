package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class PoiInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_info);

        PointOfInterest poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");
        System.out.println("Poi in the more details: " + poi.getName() + " " + poi.getDescription()); //delete after testing

        ImageButton collectButton = findViewById(R.id.collectButt);
        ImageButton shareButton = findViewById(R.id.shareButt);
        ImageButton cancelButton = findViewById(R.id.cancelButt);

        collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoiInfoActivity.this, PoiSelectionActivity.class);
                startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoiInfoActivity.this, ShareScreenActivity.class);
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoiInfoActivity.this, PoiSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
