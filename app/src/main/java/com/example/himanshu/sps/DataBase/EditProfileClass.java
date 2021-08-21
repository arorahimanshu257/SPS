package com.example.himanshu.sps.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EditProfileClass extends SQLiteOpenHelper
{

    public EditProfileClass(Context context) {
        super(context,"Profiles",null,2);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table StudentProfile(id integer PRIMARY KEY AUTOINCREMENT,email text,mobile text,reset text,fname text,city text)");
    }

    public boolean insert(String email,String mobile,String reset,String fname,String city)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email",email);
        values.put("mobile",mobile);
        values.put("reset",reset);
        values.put("fname",fname);
        values.put("city",city);

        long d = database.insert("StudentProfile",null,values);
        if(d<1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
