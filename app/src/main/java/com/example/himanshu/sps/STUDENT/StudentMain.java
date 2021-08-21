package com.example.himanshu.sps.STUDENT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.ADMIN.NewsFeed;
import com.example.himanshu.sps.ADMIN.NewsFeedAdapter;
import com.example.himanshu.sps.AnnouncementClass;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class StudentMain extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<NewsFeed> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        TextView name = findViewById(R.id.user_name);
        name.setText(My_Utility.student_name);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclermain);


        arrayList.add(new NewsFeed(R.drawable.white_profile," edit profile"));
        arrayList.add(new NewsFeed(R.drawable.white_person,"Admin"));
        arrayList.add(new NewsFeed(R.drawable.white_tpo,"Tpo"));
        arrayList.add(new NewsFeed(R.drawable.white_company,"Registered Companies"));
       recyclerView.setLayoutManager(new GridLayoutManager(this,2));
       recyclerView.setAdapter(new NewsFeedAdapter(arrayList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.account:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StudentMain.this,StudentWork.class);
                startActivity(intent);
                break;
            case R.id.logout:
                Intent log = new Intent(getApplicationContext(),StudentLogin.class);
                startActivity(log);
                finishAffinity();
                break;
            case R.id.alert:
                Intent anno = new Intent(getApplicationContext(), AnnouncementClass.class);
                startActivity(anno);
                break;
        }
        return super.onOptionsItemSelected(item);
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
