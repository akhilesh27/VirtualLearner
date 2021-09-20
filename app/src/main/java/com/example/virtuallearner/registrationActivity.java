package com.example.virtuallearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class registrationActivity extends AppCompatActivity {
    TextView regLogin;
    EditText username, collegename, email, mobile, password;
    Button SignUp;
    Database myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.regName);
        collegename = findViewById(R.id.regCollege);
        email = findViewById(R.id.regEmail);
        mobile = findViewById(R.id.regMobile);
        password = findViewById(R.id.regPassword);
        SignUp = findViewById(R.id.btnRegister);
        myDB = new Database(this);
        regLogin = findViewById(R.id.regLogin);
        insertUser();

        String text = regLogin.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan,20,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        regLogin.setText(spannableString);

        regLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void insertUser()
    {
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String un = username.getText().toString();
                String cn = collegename.getText().toString();
                String m = mobile.getText().toString();
                String p = password.getText().toString();
                if(e.equals("")||un.equals("")||cn.equals("")||m.equals("")||p.equals(""))
                {
                    Toast.makeText(registrationActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else if(m.length()!=10)
                {
                    Toast.makeText(registrationActivity.this,"Please enter valid Mobile Number",Toast.LENGTH_SHORT).show();
                }
                else if(!isValidEmail(e))
                {
                    Toast.makeText(registrationActivity.this,"Please enter valid Email ID",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkUser = myDB.checkEmail(e);
                    if(checkUser==false)
                    {
                        Boolean insert = myDB.insertData(e,un,cn,m,p);
                        if (insert==true)
                        {
                            Toast.makeText(registrationActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(registrationActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(registrationActivity.this,"User Already Exists,Please Sign In!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
    private Boolean isValidEmail(String email)
    {
        if(!emailPattern.matcher(email).matches())
            return false;
        else
            return true;
    }
}