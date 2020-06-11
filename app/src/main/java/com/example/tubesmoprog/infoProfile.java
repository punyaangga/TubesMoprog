package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class infoProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profile);
    }
    public void profileAngga(View v){
        Intent iAngga = new Intent(getApplicationContext(),ProfileAngga.class);
        startActivity(iAngga);
    }
    public void profileDevi(View v){
        Intent iDevi = new Intent(getApplicationContext(),ProfileDevi.class);
        startActivity(iDevi);
    }
    public void profileAyu(View v){
        Intent iAyu = new Intent(getApplicationContext(),ProfileAyu.class);
        startActivity(iAyu);
    }
    public void kembaliKeDashboard(View v){
        Intent iDashboard = new Intent(getApplicationContext(),DashboardAdmin.class);
        startActivity(iDashboard);
    }
}
