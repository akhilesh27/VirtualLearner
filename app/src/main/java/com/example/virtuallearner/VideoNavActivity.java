package com.example.virtuallearner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VideoNavActivity extends AppCompatActivity {
    TextView fs,st,web,dm,mad,fsLab,stLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_nav);

        fs = findViewById(R.id.fsTextView);
        st = findViewById(R.id.stTextView);
        web = findViewById(R.id.webTextView);
        dm = findViewById(R.id.dmTextView);
        mad = findViewById(R.id.madTextView);
        fsLab = findViewById(R.id.fsLabTextView);
        stLab = findViewById(R.id.stLabTextView);

        fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fileStructureActivity.class);
                startActivity(intent);
            }
        });

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),softwareTestingActivity.class);
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webActivity.class);
                startActivity(intent);
            }
        });

        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dataMiningActivity.class);
                startActivity(intent);
            }
        });

        mad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),madLabVideoActivity.class);
                startActivity(intent);
            }
        });

        fsLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fsLabVideoActivity.class);
                startActivity(intent);
            }
        });

        stLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),stLabVideoActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.video);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),homeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.video:
                        return true;

                    case R.id.notes:
                        startActivity(new Intent(getApplicationContext(),notesNavActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.discuss:
                        startActivity(new Intent(getApplicationContext(),discussActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),profileNavActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

    }
}