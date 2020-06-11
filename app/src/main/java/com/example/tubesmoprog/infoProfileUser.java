package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class infoProfileUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profile_user);
    }
    public void profileAnggaa(View v){
        //Intent iAngga = new Intent(getApplicationContext(),ProfileAnggaa.class);
        //startActivity(iAngga);
    }
    public void profileDevii(View v){
        Intent iDevi = new Intent(getApplicationContext(),ProfileDevi.class);
        startActivity(iDevi);
    }
    public void profileAyuu(View v){
        Intent iAyu = new Intent(getApplicationContext(),ProfileAyu.class);
        startActivity(iAyu);
    }
    public void kembaliKeHalamanUtama(View v){
        Intent iDashboard = new Intent(getApplicationContext(),HalamanUtamaActivity.class);
        startActivity(iDashboard);
    }
}
