package com.example.himanshu.sps.STUDENT;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.himanshu.sps.R;

public class ViewAdminInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_admin_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
