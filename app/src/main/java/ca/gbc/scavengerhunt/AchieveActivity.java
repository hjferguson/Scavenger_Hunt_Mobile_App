package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class AchieveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achieve);
        DataManager.getInstance();
        DataManager DM = DataManager.getInstance();
        int completedHunt = 0;
        ArrayList<PointOfInterest> poiArray = DM.getMyArrayList();
        if (poiArray != null && !poiArray.isEmpty()) {
            for (int i = 0; i < poiArray.size(); i++) {
                completedHunt++;
            }
        }
        if (completedHunt >= 1) {
            TextView achievement1 = findViewById(R.id.achievement1);
            achievement1.setText("1 POI Completed!");
            achievement1.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        }

        if (completedHunt >= 3) {
            TextView achievement2 = findViewById(R.id.achievement2);
            achievement2.setText("3 POI Completed!");
            achievement2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        }

        if (completedHunt >= 5) {
            TextView achievement3 = findViewById(R.id.achievement3);
            achievement3.setText("5 POI Completed!");
            achievement3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        }



        ImageButton achieve_back_button = findViewById(R.id.achieve_back_button);

        achieve_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AchieveActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
