package com.example.himanshu.sps.ADMIN;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class ViewTpo extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<TpoViewClass> arrayList = new ArrayList<>();
    String name,id;
    String name1[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tpo);
        recyclerView = findViewById(R.id.list);
        AdminStudentData studentData = new AdminStudentData(this);
        Cursor cursor = studentData.getTpoData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        while (cursor.moveToNext())
        {
            name = cursor.getString(1);
            name1 = name.split(" ");
            id = cursor.getString(2);
            arrayList.add(new TpoViewClass(name1[0],id));
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new TpoAdapter(arrayList));
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
