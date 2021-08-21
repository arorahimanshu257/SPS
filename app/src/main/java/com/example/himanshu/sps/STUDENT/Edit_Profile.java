package com.example.himanshu.sps.STUDENT;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.himanshu.sps.R;

public class Edit_Profile extends AppCompatActivity {

    TextView email,mobile,reset,father,city;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);

        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        reset = findViewById(R.id.password);
        father = findViewById(R.id.fname);
        city = findViewById(R.id.city);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
