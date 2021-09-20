package com.example.virtuallearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class fileStructureActivity extends AppCompatActivity {
    TextView fsMod1,fsMod2,fsMod3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_structure);

        fsMod1=findViewById(R.id.fsMod1TextView);
        fsMod2=findViewById(R.id.fsMod2TextView);
        fsMod3=findViewById(R.id.fsMod3TextView);

        fsMod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fsMod1VideoActivity.class);
                startActivity(intent);
            }
        });

        fsMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fsMod2VideoActivity.class);
                startActivity(intent);
            }
        });

        fsMod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fsMod3VideoActivity.class);
                startActivity(intent);
            }
        });

    }
}