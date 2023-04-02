package com.example.smart_chlothing_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    TextView textView, textView1, humidity1, temp1;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Button but;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Hiding Tool Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        textView = (TextView) findViewById(R.id.textView2);
        textView1 = (TextView) findViewById(R.id.bpmtext);
        humidity1 = (TextView) findViewById(R.id.humidity);
        temp1 = (TextView) findViewById(R.id.temp);

        but = (Button) findViewById(R.id.button2);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String str = intent.getStringExtra("mood");

        if (str.equals("Happy")) {
            textView.setText("Hello! Pratik\nYou are feeling Happy today.");
        }else if (str.equals("Angry")){
            textView.setText("Hello! Pratik\nYou are feeling Angry today.");
        }else if(str.equals("Sad")){
            textView.setText("Hello! Pratik\nYou are feeling Sad today.");
        }

        
//        Start Sensor Readings
        
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readRealTime();
            }
        });


    }


//    Function to read data from Firebase
    private void readRealTime(){

        mDatabase.child("FirebaseIOT").child("bpm").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String bpm0 = String.valueOf(dataSnapshot.getValue());
                String bpm1 = "Your Bpm is: " + bpm0;
                textView1.setText(bpm1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

        mDatabase.child("FirebaseIOT").child("temperature").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String tmp0 = String.valueOf(dataSnapshot.getValue());
                String tmp1 = "The Temperature is: " + tmp0;
                temp1.setText(tmp1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

        mDatabase.child("FirebaseIOT").child("humidity").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String hum0 = String.valueOf(dataSnapshot.getValue());
                String hum1 = "The Humidity is: " + hum0;
                humidity1.setText(hum1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}