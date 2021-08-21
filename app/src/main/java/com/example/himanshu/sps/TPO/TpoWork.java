package com.example.himanshu.sps.TPO;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.himanshu.sps.ADMIN.NewsFeed;
import com.example.himanshu.sps.ADMIN.ViewStudents;
import com.example.himanshu.sps.AnnouncementClass;
import com.example.himanshu.sps.My_Utility;
import com.example.himanshu.sps.R;
import com.example.himanshu.sps.STUDENT.StudentLogin;
import com.example.himanshu.sps.STUDENT.StudentMain;
import com.example.himanshu.sps.STUDENT.StudentWork;
import com.example.himanshu.sps.STUDENT.TpoInfo;

import java.util.ArrayList;

public class TpoWork extends AppCompatActivity {

    Button tponame;
    RecyclerView recyclerView;
    ArrayList<NewsFeed> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_work);
        recyclerView = findViewById(R.id.recycletpo);
        tponame = findViewById(R.id.tponame);

        tponame.setText(My_Utility.tpo_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        arrayList.add(new NewsFeed(R.drawable.white_company,"Add Company"));
        arrayList.add(new NewsFeed(R.drawable.white_tpo,"Shortlist Students"));
        arrayList.add(new NewsFeed(R.drawable.white_person,"Students"));
        arrayList.add(new NewsFeed(R.drawable.white_company,"Registered Companies"));
        arrayList.add(new NewsFeed(R.drawable.white_profile,"edit profile"));
        arrayList.add(new NewsFeed(R.drawable.happen,"happenings"));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new WorkAdapter(arrayList));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                Intent intent = new Intent(getApplicationContext(),TpoInfo.class);
                startActivity(intent);
                break;
            case R.id.logout:
                Intent log = new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(log);
                finish();
                break;
            case R.id.alert:
                Intent anno = new Intent(getApplicationContext(), AnnouncementClass.class);
                startActivity(anno);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }
}
