package com.example.himanshu.sps.TPO;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.himanshu.sps.DataBase.CompaniesData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

public class FinalCompany extends AppCompatActivity
{

    TextView tname,tcode,telig,tlocate,tdate;
    TextView r_home;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_company);

        tname = findViewById(R.id.name);
        tcode = findViewById(R.id.code);
        telig = findViewById(R.id.eligible);
        tlocate = findViewById(R.id.location);
        tdate = findViewById(R.id.drivedate);

        r_home = findViewById(R.id.rhome);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        r_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TpoWork.class);
                startActivity(intent);
                finish();
            }
        });

        CompaniesData companiesData = new CompaniesData(this);
        Cursor cursor = companiesData.getData(My_Utility.company_code);

        while (cursor.moveToNext())
        {
            tname.setText(cursor.getString(1));
            tcode.setText(cursor.getString(2));
            telig.setText(cursor.getString(3));
            tlocate.setText(cursor.getString(4));
            tdate.setText(cursor.getString(5));
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return  true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
