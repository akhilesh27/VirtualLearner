package com.example.virtuallearner;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public  SessionManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences("Appkey",0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void setLogin(boolean login)
    {
        editor.putBoolean("KEY_LOGIN",login);
        editor.commit();
    }

    private boolean getLogin()
    {
        return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }

    public void setemail(String email)
    {
        editor.putString("KEY_EMAIL",email);
        editor.commit();
    }

    public String getEmail()
    {
        return sharedPreferences.getString("KEY_EMAIL","");
    }

}
