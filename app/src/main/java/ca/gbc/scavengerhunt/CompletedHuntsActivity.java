package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class CompletedHuntsActivity extends AppCompatActivity {
    PointOfInterest poi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_hunts);
        poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");
        DataManager DM = DataManager.getInstance();
        ArrayList<PointOfInterest> poiArray = DM.getMyArrayList();
        if (poi != null) {
            //get poi from previous screen
            if (poiArray.isEmpty()) {
                poiArray.add(poi);
            } else {
                boolean nameExists = false;
                for (int i = 0; i < poiArray.size(); i++) {
                    if (poiArray.get(i).getName().equals(poi.getName())) {
                        nameExists = true;
                        break;
                    }
                }
                if (!nameExists) {
                    poiArray.add(poi);
                }
            }

        }
        if(!poiArray.isEmpty()) {
            if (poiArray.get(0) != null) {
                TextView completedHunt1 = findViewById(R.id.completedHunt1);
                completedHunt1.setText(poiArray.get(0).getName());
            }
            if (poiArray.size() > 1 && poiArray.get(1) != null) {
                TextView completedHunt2 = findViewById(R.id.completedHunt2);
                completedHunt2.setText(poiArray.get(1).getName());
            }
            if (poiArray.size() > 2 && poiArray.get(2) != null) {
                TextView completedHunt3 = findViewById(R.id.completedHunt3);
                completedHunt3.setText(poiArray.get(2).getName());
            }
            if (poiArray.size() > 3 && poiArray.get(3) != null) {
                TextView completedHunt4 = findViewById(R.id.completedHunt4);
                completedHunt4.setText(poiArray.get(3).getName());
            }
            if (poiArray.size() > 4 && poiArray.get(4) != null) {
                TextView completedHunt5 = findViewById(R.id.completedHunt5);
                completedHunt5.setText(poiArray.get(4).getName());
            }
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