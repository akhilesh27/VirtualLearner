package com.example.virtuallearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class dataMiningActivity extends AppCompatActivity {
    TextView dmMod1,dmMod2,dmMod3,dmMod4,dmMod5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mining);

        dmMod1=findViewById(R.id.dmMod1TextView);
        dmMod2=findViewById(R.id.dmMod2TextView);
        dmMod3=findViewById(R.id.dmMod3TextView);
        dmMod4=findViewById(R.id.dmMod4TextView);
        dmMod5=findViewById(R.id.dmMod5TextView);

        dmMod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dmMod1VideoActivity.class);
                startActivity(intent);
            }
        });

        dmMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dmMod2VideoActivity.class);
                startActivity(intent);
            }
        });

        dmMod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dmMod3VideoActivity.class);
                startActivity(intent);
            }
        });

        dmMod4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dmMod4VideoActivity.class);
                startActivity(intent);
            }
        });

        dmMod5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dmMod5VideoActivity.class);
                startActivity(intent);
            }
        });

    }
}
