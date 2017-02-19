package com.example.asiagibson.mypath;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.asiagibson.mypath.activities.HomeScreenActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_move_up);
        ImageView imageView = (ImageView) findViewById(R.id.path_icon);
        imageView.setAnimation(animation);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, HomeScreenActivity.class));
                finish();
//
            }
        }, 6000);



    }
}
