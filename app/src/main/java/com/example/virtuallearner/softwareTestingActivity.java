package com.example.virtuallearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class softwareTestingActivity extends AppCompatActivity {
    TextView stMod1,stMod2,stMod3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_testing);

        stMod1=findViewById(R.id.stMod1TextView);
        stMod2=findViewById(R.id.stMod2TextView);
        stMod3=findViewById(R.id.stMod3TextView);

        stMod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),stMod1VideoActivity.class);
                startActivity(intent);
            }
        });

        stMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),stMod2VideoActivity.class);
                startActivity(intent);
            }
        });


    }
}