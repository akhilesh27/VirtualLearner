package com.example.virtuallearner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class
discussActivity extends AppCompatActivity {
    ListView listView;
    EditText chatContent;
    ImageButton sendButton;
    Database myDB;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss);
        chatContent = findViewById(R.id.chatContent);
        sendButton = findViewById(R.id.sendButton);
        listView = findViewById(R.id.listView);
        myDB = new Database(this);

        arrayList = myDB.getAllChats();
        arrayAdapter = new ArrayAdapter(discussActivity.this, R.layout.customlistview,arrayList);
        listView.setAdapter(arrayAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager = new SessionManager(getApplicationContext());
                String email = sessionManager.getEmail();
                String chat = chatContent.getText().toString();
                Date currentTime = Calendar.getInstance().getTime();
                String date = DateFormat.getDateInstance().format(currentTime);
                String username = myDB.getUsername(email);
                if(chat.equals("") )
                {
                    Toast.makeText(discussActivity.this,"Can't send empty comment",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert = myDB.insertChats(chat,date,email,username);
                    if(insert==true)
                    {
                        Intent intent = new Intent(getApplicationContext(),discussActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(discussActivity.this,"Chat upload failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.discuss);

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