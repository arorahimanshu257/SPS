package com.example.himanshu.sps;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.himanshu.sps.DataBase.CompaniesData;

public class AnnouncementClass extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_class);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textView = findViewById(R.id.text);

        CompaniesData companiesData = new CompaniesData(this);

        Cursor cursor = companiesData.getAnoun();

        while (cursor.moveToNext())
        {
            textView.setText(cursor.getString(1));
        }

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
