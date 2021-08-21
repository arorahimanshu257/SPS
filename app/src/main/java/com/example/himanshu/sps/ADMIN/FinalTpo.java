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

public class FinalTpo extends AppCompatActivity {

    TextView t_name , t_id , t_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_tpo);

        t_name = findViewById(R.id.name);
        t_id = findViewById(R.id.registration);
        t_password = findViewById(R.id.pass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        AdminStudentData data = new AdminStudentData(this);

        Cursor cursor = data.getOnDemandTpoData(My_Utility.tpo_registration);
        Toast.makeText(this, My_Utility.tpo_registration, Toast.LENGTH_SHORT).show();
        while ((cursor.moveToNext()))
        {
          t_name.setText(cursor.getString(1));
          t_id.setText(cursor.getString(2));
          t_password.setText(cursor.getString(3));
        }
//
//        t_name.setText(tname);
//        t_id.setText(tid);
//        t_password.setText(tpass);

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
