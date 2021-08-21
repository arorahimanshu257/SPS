package com.example.himanshu.sps.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;

public class CompaniesData extends SQLiteOpenHelper {
    public CompaniesData(Context context) {
        super(context,"Company__Data",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Company(id integer PRIMARY KEY AUTOINCREMENT ,name text,code text,eligiblity text,location text,date text)");
        db.execSQL("create table Announcement(id integer PRIMARY KEY AUTOINCREMENT,push text)");
    }

    public boolean addCompany(String name,String code,String eligiblity,String location,String date)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name",name);
        contentValues.put("code",code);
        contentValues.put("eligiblity",eligiblity);
        contentValues.put("location",location);
        contentValues.put("date",date);

        long data = sqLiteDatabase.insert("Company",null,contentValues);

        if(data<1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean pushAnnouncement(String push)
    {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("push",push);

        long d = database.insert("Announcement",null,contentValues);

        if(d<1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public Cursor getAnoun()
    {
        SQLiteDatabase database = getWritableDatabase();

        Cursor cursor = database.rawQuery("Select * from Announcement",null);
        return cursor;
    }

    public Cursor getData(String s)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Company where code=?",new String[]{s});
        return cursor;
    }

    public Cursor getCompanies()
    {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Company",null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
