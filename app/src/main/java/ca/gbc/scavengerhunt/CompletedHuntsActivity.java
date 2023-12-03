package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class CompletedHuntsActivity extends AppCompatActivity {
    PointOfInterest poi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_hunts);
        poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");
        if (poi != null){
            //get poi from previous screen
            PointOfInterest poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");
            //this is a test, remove when done...
            System.out.println("On the completed hunts... The title: " + poi.getName() + " and the desc: " + poi.getDescription());
        }

        // Relates to returning to MainActivity
        ImageButton returnBtn = findViewById(R.id.mainPageReturn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void onMainPageReturnClick(View view) {
        finish();
    }
}