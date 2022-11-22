package com.idnp.aplicacionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class EntranceAnimation extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation topAnimation, bottomAnimation;
    ImageView imgEntranceLogo;
    TextView titleEntrance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_entrance_animation);

        imgEntranceLogo = findViewById(R.id.entrance_logo);
        titleEntrance = findViewById(R.id.title_entrance);

        AnimatedVectorDrawable imgDrawable = (AnimatedVectorDrawable) imgEntranceLogo.getDrawable();
        imgDrawable.start();

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imgEntranceLogo.setAnimation(topAnimation);
        titleEntrance.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EntranceAnimation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}