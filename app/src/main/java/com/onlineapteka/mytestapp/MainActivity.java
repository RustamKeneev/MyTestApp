package com.onlineapteka.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;


    private Animation topAnimation;
    private Animation bottomAnimation;
    private ImageView imageView;
    private TextView logo;
    private TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.splash_image);
        logo = findViewById(R.id.rent_text);
        slogan = findViewById(R.id.nation_wide_car_text);

        imageView.setAnimation(topAnimation);
        logo.setAnimation(bottomAnimation);
        slogan.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,DasboardActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}