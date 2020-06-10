package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardAdmin extends AppCompatActivity {
    Button btnAdminRsRujukan,btnAdminKonten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
        btnAdminRsRujukan=(Button)findViewById(R.id.btn_AdminRsRujukan);
        btnAdminKonten = (Button) findViewById(R.id.btn_AdminEdukasi);

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
        Intent iListKonten = new Intent(getApplicationContext(),AdminListKontenEdukasi.class);
        startActivity(iListKonten);
    }

}
