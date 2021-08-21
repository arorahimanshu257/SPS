package com.example.himanshu.sps.ADMIN;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

import com.example.himanshu.sps.R;

import java.util.ArrayList;

public class NewAdmin extends AppCompatActivity
{

    RecyclerView recyclerView;
    ArrayList<NewsFeed> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_admin);
        recyclerView = findViewById(R.id.recyclerview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        arrayList.add(new NewsFeed(R.drawable.add_student,"Add Student"));
        arrayList.add(new NewsFeed(R.drawable.add_tpo,"Add Tpo"));
        arrayList.add(new NewsFeed(R.drawable.white_person,"Students"));
        arrayList.add(new NewsFeed(R.drawable.white_tpo,"Tpos"));
        arrayList.add(new NewsFeed(R.drawable.white_company,"Companies"));
        arrayList.add(new NewsFeed(R.drawable.white_alert,"Push Announcement"));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new NewAdminAdapter(arrayList));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.adminlist,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.logout:
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finishAffinity();
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
    public void onBackPressed()
    {
        finish();
    }

}
