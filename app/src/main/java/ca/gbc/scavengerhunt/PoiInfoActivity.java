package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class PoiInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataManager.getInstance();
        setContentView(R.layout.activity_poi_info);

        //get poi from previous screen
        PointOfInterest poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");

        TextView poiTitle = findViewById(R.id.poiTitle);
        TextView poiDesc = findViewById(R.id.poiDesc);
        ImageView imageView = findViewById(R.id.imageView);

        ImageButton collectButton = findViewById(R.id.collectButt);
        ImageButton shareButton = findViewById(R.id.shareButt);
        ImageButton cancelButton = findViewById(R.id.cancelButt);

        //inject the poi data into the views
        if (poi != null) {
            poiTitle.setText(poi.getName());
            poiDesc.setText(poi.getDescription());

            if (poi.getPhoto() != null) {
                String imageName = poi.getPhoto();
                int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                imageView.setImageResource(imageResId);
            }
        }

        collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoiInfoActivity.this, CompletedHuntsActivity.class);
                intent.putExtra("POI_DATA", poi);
                startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoiInfoActivity.this, ShareScreenActivity.class);
                intent.putExtra("POI_DATA", poi);
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //returns to previous screen
            }
        });
    }
}
