package ca.gbc.scavengerhunt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import ca.gbc.scavengerhunt.POI.PointOfInterest;

public class ShareScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_screen_layout);

        // get poi from previous screen
        PointOfInterest poi = (PointOfInterest) getIntent().getSerializableExtra("POI_DATA");

        ImageButton twitterButton = findViewById(R.id.twitterButton);
        ImageButton instagramButton = findViewById(R.id.instagramButton);
        ImageButton facebookButton = findViewById(R.id.facebookButton);
        ImageButton nextHuntButton = findViewById(R.id.nextHuntButton);
        ImageButton backButton = findViewById(R.id.backButton);
        ImageButton emailButton = findViewById(R.id.emailButton); // added email button

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://twitter.com");
            }
        });

        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://instagram.com");
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("https://facebook.com");
            }
        });

        nextHuntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShareScreenActivity.this, PoiSelectionActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert poi != null;
                sendEmail(poi);
            }
        });
    }

    private void openWebPage(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void sendEmail(PointOfInterest poi) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this Point of Interest!");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name: " + poi.getName() + "\nDescription: " + poi.getDescription());
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}

