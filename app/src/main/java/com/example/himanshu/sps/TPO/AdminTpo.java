package com.example.himanshu.sps.TPO;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.himanshu.sps.ADMIN.FinalStudent;
import com.example.himanshu.sps.ADMIN.FinalTpo;
import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

public class AdminTpo extends AppCompatActivity {

    EditText tname,tid,tpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tpo);
        tname = findViewById(R.id.tponame);
        tid = findViewById(R.id.tpoid);
        tpass = findViewById(R.id.tpopass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void registerTpo(View view)
    {
        if(!TextUtils.isEmpty(tname.getText().toString()))
        {
            if(!TextUtils.isEmpty(tid.getText().toString()))
            {
                if(!TextUtils.isEmpty(tpass.getText().toString()))
                {
                    AdminStudentData data = new AdminStudentData(this);
                    SQLiteDatabase sqLiteDatabase=data.getWritableDatabase();
                    boolean b = data.tpoData(tname.getText().toString(),tid.getText().toString(),tpass.getText().toString(),sqLiteDatabase);
                    if(b)
                    {
                        My_Utility.tpo_registration=tid.getText().toString();
                        Toast.makeText(this, "Tpo Registered", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), FinalTpo.class);
                        startActivity(intent);
                    }

                    else
                        tid.setError("User Already Exists");
                }
                else
                    tpass.setError("Enter Password !");
            }
            else
                tid.setError("Enter Id !");
        }
        else
            tname.setError("Enter Name !");
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
