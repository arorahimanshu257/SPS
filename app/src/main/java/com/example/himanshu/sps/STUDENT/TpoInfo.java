package com.example.himanshu.sps.STUDENT;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

public class TpoInfo extends AppCompatActivity {

    TextView name,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_info);

        name = findViewById(R.id.name);
        reg = findViewById(R.id.registration);

        name.setText(My_Utility.tpo_name);
        reg.setText(My_Utility.tpo_registration);
    }
}
