package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PoiSelectionActivity extends AppCompatActivity {

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
    }
}