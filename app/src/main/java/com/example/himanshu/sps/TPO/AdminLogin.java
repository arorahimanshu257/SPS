package com.example.himanshu.sps.TPO;

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
import com.example.himanshu.sps.STUDENT.AdminStudent;
import com.example.himanshu.sps.STUDENT.StudentLogin;

public class AdminLogin extends AppCompatActivity {

    TextView textView;
    EditText tid,tpass;
    String name,id,pass;
    AdminStudentData data = new AdminStudentData(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        tid=findViewById(R.id.tpoid);
        tpass=findViewById(R.id.tpopass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.loginstud);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent student = new Intent(getApplicationContext(), StudentLogin.class);
                startActivity(student);
                finish();
            }
        });

    }

    public void onLogin(View view)
    {
        if(!TextUtils.isEmpty(tid.getText().toString()))
        {
            if(!TextUtils.isEmpty(tpass.getText().toString()))
            {

                Cursor cursor = data.getOnDemandTpoData(tid.getText().toString());
                while (cursor.moveToNext())
                {
                    name=cursor.getString(1);
                    id=cursor.getString(2);
                    pass=cursor.getString(3);
                }
                if(id.equals(tid.getText().toString()) && pass.equals(tpass.getText().toString()))
                {
                    My_Utility.tpo_name = name;
                    My_Utility.tpo_registration = id;
                    Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this,TpoWork.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Invalid Username/Password ", Toast.LENGTH_SHORT).show();
                }
            }
            else
                tpass.setError("Enter Password !");
        }
        else
            tid.setError("Enter Id !");
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
