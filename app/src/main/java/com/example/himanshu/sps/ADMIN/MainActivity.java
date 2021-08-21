package com.example.himanshu.sps.ADMIN;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.himanshu.sps.R;
import com.example.himanshu.sps.STUDENT.StudentLogin;
import com.example.himanshu.sps.TPO.AdminLogin;

public class  MainActivity extends AppCompatActivity
{
    ImageView student,tpo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student = findViewById(R.id.student);
        tpo = findViewById(R.id.tpo);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent student = new Intent(getApplicationContext(), StudentLogin.class);
                startActivity(student);
            }
        });

        tpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent tpo = new Intent(getApplicationContext(), AdminLogin.class);
                startActivity(tpo);
            }
        });
    }
}