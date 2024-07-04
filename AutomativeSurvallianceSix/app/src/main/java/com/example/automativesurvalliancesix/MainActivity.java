package com.example.automativesurvalliancesix;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button sendAlertButton;
    private Button sendImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendAlertButton = findViewById(R.id.sendAlertButton);
        sendImageButton = findViewById(R.id.sendImageButton);

        sendAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertSender.sendAlert(MainActivity.this, "This is a test alert");
            }
        });

        sendImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace with actual image data
                String base64Image = "base64EncodedImageData";
                ImageSender.sendImage(MainActivity.this, base64Image);
            }
        });
    }
}
