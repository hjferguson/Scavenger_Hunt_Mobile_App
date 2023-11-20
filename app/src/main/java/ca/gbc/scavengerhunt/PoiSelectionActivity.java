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
        poiSelectBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to MainActivity
                Intent intent = new Intent(PoiSelectionActivity.this, MainActivity.class);
                // Start the MainActivity
                startActivity(intent);
            }
        });
    }
}