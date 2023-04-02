package com.example.smart_chlothing_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FeelingActivity extends AppCompatActivity {

    ImageView img1, img2, img3;
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling);

        //        Hiding Tool Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        img1 = (ImageView) findViewById(R.id.imageview1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = "Happy";
                Intent i = new Intent(FeelingActivity.this, HomeActivity.class);
                i.putExtra("mood", mood);
                startActivity(i);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = "Angry";
                Intent i = new Intent(FeelingActivity.this, HomeActivity.class);
                i.putExtra("mood", mood);
                startActivity(i);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mood = "Sad";
                Intent i = new Intent(FeelingActivity.this, HomeActivity.class);
                i.putExtra("mood", mood);
                startActivity(i);
            }
        });

    }
}