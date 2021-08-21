package com.example.himanshu.sps.STUDENT;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.himanshu.sps.ADMIN.FinalStudent;
import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class AdminStudent extends AppCompatActivity {

    EditText sname,sid,spass,scgpa;
    Spinner sbranch;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String branch;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student);
        sname = findViewById(R.id.student_name);
        sid = findViewById(R.id.student_id);
        sbranch = findViewById(R.id.student_branch);
        spass = findViewById(R.id.student_pass);
        scgpa = findViewById(R.id.student_cgpa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        arrayList =new ArrayList<>();
        arrayList.add("Select Branch");
        arrayList.add("CSE");
        arrayList.add("ME");
        arrayList.add("EE");
        arrayList.add("EEE");
        arrayList.add("ECE");
        arrayList.add("CIVIL");
        arrayList.add("IT");

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,arrayList);
        sbranch.setAdapter(arrayAdapter);

        sbranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                branch=arrayList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void dataInsert(View view)
    {
        //data.deleteTable();
        if(!TextUtils.isEmpty(sname.getText().toString()))
        {
            if(!TextUtils.isEmpty(sid.getText().toString()))
            {
                if(!TextUtils.isEmpty(scgpa.getText().toString()))
                {
                    if(!TextUtils.isEmpty(spass.getText().toString()))
                    {
                        My_Utility.student_registration = sid.getText().toString();
                        AdminStudentData data = new AdminStudentData(AdminStudent.this);
                        SQLiteDatabase sqLiteDatabase = data.getWritableDatabase();
                        boolean b = data.insertData(sname.getText().toString(), sid.getText().toString(), branch,scgpa.getText().toString(),spass.getText().toString(), sqLiteDatabase);
                        if (b) {
                            Intent intent = new Intent(getApplicationContext(), FinalStudent.class);
                            startActivity(intent);
                            Toast.makeText(this, "Student Registered", Toast.LENGTH_SHORT).show();
                        }
                        else
                            sid.setError("User Already Exists !");
                    }
                    else
                        spass.setError("Enter password !");
                    }
                    else
                        spass.setError("Enter cgpa !");
            }
            else
                sid.setError("Enter Valid Id !");
        }
        else
            sname.setError("Enter Name !");


     /*Cursor cursor = data.getData();
         StringBuffer stringBuffer = new StringBuffer();
         while ((cursor.moveToNext())) {
             stringBuffer.append(cursor.getString(0) + "\n");
             stringBuffer.append(cursor.getString(1) + "\n");
             stringBuffer.append(cursor.getString(2) + "\n");
             stringBuffer.append(cursor.getString(3) + "\n");
             stringBuffer.append(cursor.getString(4) + "\n\n");
         }
         AlertDialog.Builder builder = new AlertDialog.Builder(AdminStudent.this).setTitle("Data").setMessage(stringBuffer);
         builder.show();*/
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
