package com.mobileapp.shoppingcartappsample.Startup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mobileapp.shoppingcartappsample.R;

public class SplashScreen extends Activity implements Animation.AnimationListener {

    Animation animationFab;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Log.e("SDK Version ::::", String.valueOf(Build.VERSION.SDK_INT));
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decoreView = getWindow().getDecorView();
            int uiOpt = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decoreView.setSystemUiVisibility(uiOpt);
        }
        animationFab = AnimationUtils.loadAnimation(getApplicationContext(),
                R.animator.anim_fadin);
        animationFab.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(SplashScreen.this, WelcomeActivity.class);
        startActivity(intent);
        this.finish();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
