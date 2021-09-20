package com.example.virtuallearner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homeActivity extends AppCompatActivity {
    SessionManager sessionManager;
    ImageView fsIcon,stIcon,webIcon,dmIcon,madIcon,stLabIcon,fsLabIcon;
    TextView welcomeText,viewAllSub;
    Button btnToNotes,btnToDiscuss;
    Database myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        welcomeText = findViewById(R.id.welcomeText);
        viewAllSub = findViewById(R.id.ViewAllText);
        fsIcon = findViewById(R.id.fsIcon);
        stIcon = findViewById(R.id.stIcon);
        webIcon = findViewById(R.id.webIcon);
        dmIcon = findViewById(R.id.dmIcon);
        madIcon = findViewById(R.id.madIcon);
        stLabIcon = findViewById(R.id.stlabIcon);
        fsLabIcon = findViewById(R.id.fslabIcon);
        btnToNotes = findViewById(R.id.btnToNotes);
        btnToDiscuss = findViewById(R.id.btnToDiscuss);
        myDB = new Database(this);
        sessionManager = new SessionManager(getApplicationContext());

        String username = myDB.getUsername(sessionManager.getEmail());
        welcomeText.setText("Hi, "+ username+"!");

        viewAllSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VideoNavActivity.class);
                startActivity(intent);
            }
        });

        fsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fileStructureActivity.class);
                startActivity(intent);
            }
        });

        stIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),softwareTestingActivity.class);
                startActivity(intent);
            }
        });

        webIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webActivity.class);
                startActivity(intent);
            }
        });

        dmIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dataMiningActivity.class);
                startActivity(intent);
            }
        });

        madIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),madLabVideoActivity.class);
                startActivity(intent);
            }
        });

        stLabIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),stLabVideoActivity.class);
                startActivity(intent);
            }
        });

        fsLabIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),fsLabVideoActivity.class);
                startActivity(intent);
            }
        });

        btnToNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),notesNavActivity.class);
                startActivity(intent);
            }
        });

        btnToDiscuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),discussActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        return true;

                    case R.id.video:
                        startActivity(new Intent(getApplicationContext(),VideoNavActivity.class));
                        overridePendingTransition(0,0);
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