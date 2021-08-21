package com.example.himanshu.sps.ADMIN;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.himanshu.sps.R;
import com.example.himanshu.sps.STUDENT.StudentLogin;

public class SplashM extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_m);
        progressBar=findViewById(R.id.progressbar);
        progressBar.setProgress(0);
        ImageView imageView=findViewById(R.id.image);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animation);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),StudentLogin.class);
                startActivity(intent);
                finish();
            }
        },2500);
    }
}
