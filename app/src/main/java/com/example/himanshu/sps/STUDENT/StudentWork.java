package com.example.himanshu.sps.STUDENT;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

public class StudentWork extends AppCompatActivity
{

    TextView name,registration,branch;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_work);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        name = findViewById(R.id.name);
        registration = findViewById(R.id.registration);
        branch = findViewById(R.id.branch);

        AdminStudentData data = new AdminStudentData(this);
        Cursor cursor = data.getOnDemandData(My_Utility.student_registration);
        while (cursor.moveToNext())
        {
            name.setText(cursor.getString(1));
            registration.setText(cursor.getString(2));
            branch.setText(cursor.getString(3));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}
