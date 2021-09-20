package com.example.virtuallearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class loginActivity extends AppCompatActivity {
    private EditText logemail,password;
    private Button login;
    private TextView logSignup;
    private Database myDB;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logemail = findViewById(R.id.logEmail);
        password = findViewById(R.id.logPassword);
        logSignup = findViewById(R.id.logSignup);
        login = findViewById(R.id.btnLogin);
        myDB = new Database(this);
        sessionManager = new SessionManager(getApplicationContext());

        loginUser();

        String text = logSignup.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan,0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        logSignup.setText(spannableString);

        logSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),registrationActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        sessionManager = new SessionManager(getApplicationContext());
        String sessionEmail = sessionManager.getEmail();
        if(sessionEmail=="loggedOut")
        {
            sessionManager.setemail("");
            Toast.makeText(loginActivity.this,"You Logged Out",Toast.LENGTH_SHORT).show();
        }
        else
            super.onBackPressed();
    }


    private void loginUser()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logemail.getText().toString();
                String pass = password.getText().toString();
                if(email.equals("") || pass.equals(""))
                {
                    Toast.makeText(loginActivity.this,"Please Enter Credentials",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result = myDB.checkUser(email,pass);
                    if(result==true)
                    {
                        sessionManager.setLogin(true);
                        sessionManager.setemail(email);
                        Toast.makeText(loginActivity.this,"Sign In successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homeActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(loginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}