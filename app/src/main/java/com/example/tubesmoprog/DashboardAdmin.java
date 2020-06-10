package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardAdmin extends AppCompatActivity {
    Button btnAdminRsRujukan,btnAdminKonten,btnLogout,btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
        btnAdminRsRujukan=(Button)findViewById(R.id.btn_AdminRsRujukan);
        btnAdminKonten = (Button) findViewById(R.id.btn_AdminEdukasi);
        btnLogout = (Button) findViewById(R.id.btn_Logout);
        btnProfile = (Button) findViewById(R.id.btnProfile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iProfilee = new Intent(getApplicationContext(),infoProfile.class);
                startActivity(iProfilee);
            }
        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLogout= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(iLogout);
            }
        });

        btnAdminRsRujukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iListRs = new Intent(getApplicationContext(),AdminListRsRujukan.class);
                startActivity(iListRs);
            }
        });
        btnAdminKonten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iListKonten = new Intent(getApplicationContext(),AdminListKontenEdukasi.class);
                startActivity(iListKonten);
            }
        });
    }
    public  void PindahEdukasi(View v){
        Intent iListKonten = new Intent(getApplicationContext(),AdminListKontenEdukasi.class);
        startActivity(iListKonten);
    }
    public  void PindahRs(View v){
        Intent iListKonten = new Intent(getApplicationContext(),AdminListRsRujukan.class);
        startActivity(iListKonten);
    }
    public void Logout(View v){
        Intent iLogoutApp = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(iLogoutApp);
    }
    public void Profile(View v){
        Intent iProfile = new Intent(getApplicationContext(),infoProfile.class);
        startActivity(iProfile);
    }

}
