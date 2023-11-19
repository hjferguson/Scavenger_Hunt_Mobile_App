package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        // Set a delay for the splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start main activity
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);


                finish();
            }
        }, 5000); // 5 sec
    }
}
