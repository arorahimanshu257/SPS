package com.example.himanshu.sps.TPO;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.himanshu.sps.DataBase.CompaniesData;
import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class ViewTpo extends AppCompatActivity {

    RecyclerView recyclerView;
    String name,date;
    ArrayList<TpoClass> tpoClasses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tpo2);
        recyclerView = findViewById(R.id.lists);
        CompaniesData companiesData = new CompaniesData(this);
        Cursor cursor = companiesData.getCompanies();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        while (cursor.moveToNext())
        {
            name = cursor.getString(1);
            date = cursor.getString(5);
            tpoClasses.add(new TpoClass(name,date));
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new TpoAdapter(tpoClasses));
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
