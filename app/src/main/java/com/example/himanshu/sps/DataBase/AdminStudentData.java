package com.example.himanshu.sps.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class AdminStudentData extends SQLiteOpenHelper
    {
    public AdminStudentData(Context context)
    {
        super(context, "Placement-Data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table StudentData(id INTEGER PRIMARY KEY AUTOINCREMENT,name text,registration text unique,branch text,cgpa text,password text)");
        db.execSQL("create table TpoData(id INTEGER PRIMARY kEY AUTOINCREMENT,name text,registration text unique,password text)");
        tpoData("Himanshu","11607989","123",db);
        insertData("Himanshu","11607989","CSE","8.22","123",db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public  boolean insertData(String name,String registration,String branch,String cgpa,String password,SQLiteDatabase sqLiteDatabase)
    {
       // SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("registration",registration);
        contentValues.put("branch",branch);
        contentValues.put("cgpa",cgpa);
        contentValues.put("password",password);
        long t=sqLiteDatabase.insert("StudentData",null,contentValues);
        if(t>0)
        {
            return true;
        }

        else
        {
            return false;
        }

    }


    public boolean tpoData(String name,String registration,String password,SQLiteDatabase liteDatabase)
    {
       // SQLiteDatabase liteDatabase =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("registration",registration);
        contentValues.put("password",password);

        long t = liteDatabase.insert("TpoData",null,contentValues);

        if(t>0)
        {
            return true;
        }
        else
            return false;

    }


    public boolean deleteTable()
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("Drop table Student_Data");
        return  true;
    }


    public Cursor getData()
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from StudentData",null);
        return cursor;
    }


    public Cursor getTpoData()
    {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from TpoData",null);
            return cursor;
    }


    public Cursor getOnDemandData(String s)
    {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from StudentData where registration=?",new String[]{s});
            return cursor;
    }

        public Cursor getOnDemandTpoData(String q)
        {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from TpoData where registration=?",new String[]{q});
            return cursor;
        }

        public  Cursor getShortlist(String q)
        {
            SQLiteDatabase liteDatabase = getWritableDatabase();
            Cursor cursor = liteDatabase.rawQuery("select * from StudentData where cgpa>=?",new String[]{q});
            return cursor;
        }



    }
