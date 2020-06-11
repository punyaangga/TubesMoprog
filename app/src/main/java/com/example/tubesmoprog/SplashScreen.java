package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int loadingTime=2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHalamanAwal= new Intent (SplashScreen.this,
                        HalamanAwalActivity.class);
                startActivity(iHalamanAwal);
                finish();
            }
        },loadingTime);
    }
}
