package com.example.virtuallearner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profileNavActivity extends AppCompatActivity {
    TextView profileUserName,profileEmail;
    EditText profileName,profileCollegeName,profileMobileNumber;
    SessionManager sessionManager;
    Button editProfile,logout;
    Database myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_nav);

        profileUserName = findViewById(R.id.profileUserName);
        profileEmail = findViewById(R.id.profileEmail);
        profileName = findViewById(R.id.profileName);
        profileCollegeName = findViewById(R.id.profileCollegeName);
        profileMobileNumber = findViewById(R.id.profileMobileNumber);
        editProfile = findViewById(R.id.editProfile);
        logout = findViewById(R.id.profileLogout);
        myDB = new Database(this);

        sessionManager = new SessionManager(getApplicationContext());
        String sessionEmail = sessionManager.getEmail();
        profileEmail.setText(sessionEmail);

        String username = myDB.getUsername(sessionEmail);
        profileUserName.setText(username);
        profileName.setText(username);

        String collegeName = myDB.getCollegeName(sessionEmail);
        profileCollegeName.setText(collegeName);

        String mobileNumber = myDB.getMobileNumber(sessionEmail);
        profileMobileNumber.setText(mobileNumber);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updateData = myDB.updateData(sessionEmail,profileName.getText().toString(),profileCollegeName.getText().toString(),profileMobileNumber.getText().toString());
                Toast.makeText(profileNavActivity.this,"Profile Updated",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),profileNavActivity.class);
                startActivity(intent);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Log Out");
                builder.setMessage("Are you sure you want to Logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sessionManager.setLogin(false);
                        sessionManager.setemail("loggedOut");
                        Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

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
                        return true;
                }

                return false;
            }
        });
    }
}