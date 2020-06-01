package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
Button btnRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //fungsi ini cuma dipake sementara aja. kalo fungsi regis udah jalan fungsi ini hapus aja
        btnRegis=(Button) findViewById(R.id.btn_regist);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDashboard= new Intent(getApplicationContext(),DashboardAdmin.class);
                startActivity(iDashboard);
            }
        });
    }


}
