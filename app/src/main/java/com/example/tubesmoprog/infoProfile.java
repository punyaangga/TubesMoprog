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
        //Pada bagian intent iDevi terdapat class ProfileAngga.class ganti aja sama nama class profile kalian
        Intent iDevi = new Intent(getApplicationContext(),ProfileAngga.class);
        startActivity(iDevi);
    }
    public void profileAyu(View v){
        //Pada bagian intent iAyu terdapat class ProfileAngga.class ganti aja sama nama class profile kalian
        Intent iAyu = new Intent(getApplicationContext(),ProfileAngga.class);
        startActivity(iAyu);
    }
    public void kembaliKeDashboard(View v){
        Intent iDashboard = new Intent(getApplicationContext(),DashboardAdmin.class);
        startActivity(iDashboard);
    }
}
