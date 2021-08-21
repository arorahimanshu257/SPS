package com.example.himanshu.sps.ADMIN;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

public class FinalStudent extends AppCompatActivity {

    TextView r_name , r_id , r_branch , r_password ,r_cgpa;
    String sname , sid , sbranch , spass, scgpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_student);

        r_name = findViewById(R.id.name);
        r_id = findViewById(R.id.registration);
        r_branch = findViewById(R.id.branch);
        r_password = findViewById(R.id.pass);
        r_cgpa = findViewById(R.id.cgpa);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdminStudentData data = new AdminStudentData(this);

        Cursor cursor = data.getOnDemandData(My_Utility.student_registration);
        Toast.makeText(this, My_Utility.student_registration, Toast.LENGTH_SHORT).show();
        while ((cursor.moveToNext())) {
           sname = cursor.getString(1);
           sid = cursor.getString(2);
           sbranch = cursor.getString(3);
           scgpa = cursor.getString(4);
           spass = cursor.getString(5);
        }

        r_name.setText(sname);
        r_id.setText(sid);
        r_branch.setText(sbranch);
        r_cgpa.setText(scgpa);
        r_password.setText(spass);

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
