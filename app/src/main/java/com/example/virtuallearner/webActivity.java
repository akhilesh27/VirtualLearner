package com.example.virtuallearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class webActivity extends AppCompatActivity {
    TextView webMod1,webMod2,webMod3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webMod1=findViewById(R.id.webMod1TextView);
        webMod2=findViewById(R.id.webMod2TextView);
        webMod3=findViewById(R.id.webMod3TextView);

        webMod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webMod1VideoActivity.class);
                startActivity(intent);
            }
        });

        webMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webMod2VideoActivity.class);
                startActivity(intent);
            }
        });

        webMod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webMod3VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}