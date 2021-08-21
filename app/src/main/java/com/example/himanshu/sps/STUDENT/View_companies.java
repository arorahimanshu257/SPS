package com.example.himanshu.sps.STUDENT;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

public class View_companies extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_companies);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.lists);
        if (My_Utility.shortlisted.contains(My_Utility.student_registration))
        {
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,My_Utility.company_shorlisted);
            listView.setAdapter(adapter);
        }
        else
        {
            Toast.makeText(this, "You are not registered for any Company !", Toast.LENGTH_SHORT).show();
        }
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
