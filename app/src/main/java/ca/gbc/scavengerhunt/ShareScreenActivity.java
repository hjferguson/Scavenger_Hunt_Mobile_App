package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class ShareScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataManager.getInstance();
        setContentView(R.layout.share_screen_layout);

        //get poi from previous screen
        PointOfInterest poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");
        //this is a test, remove when done...
        System.out.println("On share screen... The title: " + poi.getName() + " and the desc: " + poi.getDescription());


        ImageButton twitterButton = findViewById(R.id.twitterButton);
        ImageButton instagramButton = findViewById(R.id.instagramButton);
        ImageButton facebookButton = findViewById(R.id.facebookButton);
        ImageButton nextHuntButton = findViewById(R.id.nextHuntButton);
        ImageButton backButton = findViewById(R.id.backButton);

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        nextHuntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}

