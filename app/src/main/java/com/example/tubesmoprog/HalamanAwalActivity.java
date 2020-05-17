package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanAwalActivity extends AppCompatActivity implements View.OnClickListener {
Button btnRegistt,btnLoginn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);

        btnRegistt=(Button) findViewById(R.id.btn_registt);
        btnLoginn=(Button) findViewById(R.id.btn_loginn);

        //eksekusi button
        btnRegistt.setOnClickListener(this);
        btnLoginn.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_loginn:
                Intent  moveToPageLogin =new Intent(HalamanAwalActivity.this,LoginActivity.class);
                startActivity(moveToPageLogin);
                break;
            case R.id.btn_registt:
                Intent moveToPageRegis = new Intent(HalamanAwalActivity.this,RegisterActivity.class);
                startActivity(moveToPageRegis);
                break;
        }
    }


}
