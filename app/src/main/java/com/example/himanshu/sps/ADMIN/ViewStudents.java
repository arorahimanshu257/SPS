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
import java.util.Collection;

public class ViewStudents extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<StudentViewClass> arrayList = new ArrayList<>();
    String name1,id,branch,cgpa;
    String name[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);
        AdminStudentData data = new AdminStudentData(this);
        Cursor cursor = data.getData();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        while (cursor.moveToNext())
        {
            name1 = cursor.getString(1);
            name = name1.split(" ");
            id = cursor.getString(2);
            branch = cursor.getString(3);
            cgpa = cursor.getString(4);
            arrayList.add(new StudentViewClass(name[0],id,branch,cgpa));
        }
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new StudentAdapter(arrayList));

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
