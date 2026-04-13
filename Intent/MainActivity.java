package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnInstagram, btnSnapchat, btnYouTube, btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInstagram = findViewById(R.id.btnInstagram);
        btnSnapchat = findViewById(R.id.btnSnapchat);
        btnYouTube = findViewById(R.id.btnYouTube);
        btnDial = findViewById(R.id.btnDial);

        // Instagram
        btnInstagram.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.instagram.com"));
            startActivity(intent);
        });

        // Snapchat
        btnSnapchat.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.snapchat.com"));
            startActivity(intent);
        });

        // YouTube
        btnYouTube.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com"));
            startActivity(intent);
        });

        // Dialpad with number
        btnDial.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9699919748"));
            startActivity(intent);
        });
    }
}