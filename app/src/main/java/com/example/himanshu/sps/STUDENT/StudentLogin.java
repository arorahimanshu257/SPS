package com.example.himanshu.sps.STUDENT;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.DataBase.AdminStudentData;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;
import com.example.himanshu.sps.TPO.AdminLogin;

public class StudentLogin extends AppCompatActivity {

    TextView textView;
    EditText student_id,student_password;
    String name,id,branch,password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        student_id = findViewById(R.id.studentid);
        student_password = findViewById(R.id.studentpass);

        textView = findViewById(R.id.logintpo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent tpo = new Intent(getApplicationContext(), AdminLogin.class);
                startActivity(tpo);
                finish();
            }
        });

    }

    public void onLogin(View view)
    {

        if(!TextUtils.isEmpty(student_id.getText().toString()))
        {
            if(!TextUtils.isEmpty(student_password.getText().toString()))
            {
                AdminStudentData studentData = new AdminStudentData(this);
                Cursor cursor = studentData.getOnDemandData(student_id.getText().toString());
                while (cursor.moveToNext())
                {
                    name = cursor.getString(1);
                    id = cursor.getString(2);
                    branch = cursor.getString(3);
                    password = cursor.getString(5);
                }

                if(id.equals(student_id.getText().toString())&&password.equals(student_password.getText().toString()))
                {
                    My_Utility.student_name = name;
                    My_Utility.student_registration = id;
                    Intent intent = new Intent(StudentLogin.this, StudentMain.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Invalid Username/Password !", Toast.LENGTH_SHORT).show();
                }
            }
            else
                student_password.setError("Enter Password !");
        }
        else
            student_id.setError("Enter Username !");
    }

    public String logincheck(String s)
    {
        return s;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_directions_walk_black_24dp);
        builder.setTitle("Do you want to exit ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("no",null);
        builder.show();
    }
}
