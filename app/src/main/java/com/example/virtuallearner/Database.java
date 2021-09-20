package com.example.virtuallearner;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.renderscript.Sampler;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import javax.sql.StatementEvent;

public class Database extends SQLiteOpenHelper {
    public static final String DB_Name="login.DB";

    public Database(Context context) {
        super(context, "login.DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(email TEXT primary key , username TEXT, collegename TEXT, mobile TEXT, password TEXT )");

        db.execSQL("create table usersChats(chatId INTEGER primary key autoincrement, chatContent TEXT, chatDate TEXT, userEmail TEXT, userName TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");

        db.execSQL("drop Table if exists userschats");
    }

    public Boolean insertData(String email, String username, String collegename, String mobile, String password) {
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("collegename", collegename);
        contentValues.put("mobile", mobile);
        contentValues.put("password", password);
        long result = db.insert("users",null,contentValues);
        if((result == -1))
            return false;
        else
            return true;
    }

    public Boolean checkEmail(String email)
    {
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ?",new String[] {email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUser(String email, String password)
    {
        SQLiteDatabase db =  this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ? and password = ?",new String[] {email,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public String getUsername(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ?",new String[] {email});
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext())
        {
            stringBuilder.append(cursor.getString(1));
        }
        String val = stringBuilder.toString();
        return val;
    }

    public String getCollegeName(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ?",new String[] {email});
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext())
        {
            stringBuilder.append(cursor.getString(2));
        }
        String val = stringBuilder.toString();
        return val;
    }

    public String getMobileNumber(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ?",new String[] {email});
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext())
        {
            stringBuilder.append(cursor.getString(3));
        }
        String val = stringBuilder.toString();
        return val;
    }

    public boolean updateData(String email,String name,String college,String mobileNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",name);
        contentValues.put("collegename",college);
        contentValues.put("mobile",mobileNumber);
        db.update("users",contentValues,"email=?",new String[] {email});
        return true;
    }

    public Boolean insertChats(String chatcontent, String date, String useremail ,String username) {
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("chatContent", chatcontent);
        contentValues.put("chatDate", date);
        contentValues.put("userEmail", useremail);
        contentValues.put("userName", username);
        long result = db.insert("usersChats",null,contentValues);
        if((result == -1))
            return false;
        else
            return true;
    }

    public ArrayList getAllChats()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor cursor = db.rawQuery("Select * from usersChats ",new String[]{});
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            arrayList.add(cursor.getString(4) + " " + "on" + " " + cursor.getString(2) + "\n" + cursor.getString(1));
            cursor.moveToNext();
        }
        return arrayList;
    }
}
