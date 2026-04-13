package com.example.ratingprogressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView txtRating;
    ProgressBar progressBar;
    Button btnIncrease;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        txtRating = findViewById(R.id.txtRating);
        progressBar = findViewById(R.id.progressBar);
        btnIncrease = findViewById(R.id.btnIncrease);
        
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtRating.setText("Rating: " + rating);
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress += 10;

                if (progress > 100) {
                    progress = 0;
                }

                progressBar.setProgress(progress);
            }
        });
    }
}