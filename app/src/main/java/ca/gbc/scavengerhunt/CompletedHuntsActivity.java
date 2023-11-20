package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CompletedHuntsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_hunts);


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