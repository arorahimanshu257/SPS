package com.example.himanshu.sps.ADMIN;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.himanshu.sps.R;

public class Login extends AppCompatActivity {
    EditText admin_id,admin_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        admin_id = findViewById(R.id.adminid);
        admin_pass = findViewById(R.id.adminpass);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onLogin(View view)
    {
        if(!TextUtils.isEmpty(admin_id.getText().toString()))
        {
            if(!TextUtils.isEmpty(admin_pass.getText().toString()))
            {
                long adminid = Long.parseLong(admin_id.getText().toString());
                String adminpass = admin_pass.getText().toString();

                if(adminid == 11607989 && adminpass.equalsIgnoreCase("1234"))
                {
                    Intent intent = new Intent(this,NewAdmin.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Invalid Admin", Toast.LENGTH_SHORT).show();
                }

            }
            else
                admin_pass.setError("Enter Password !");
        }
        else
            admin_id.setError("Enter Username");

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
