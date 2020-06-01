package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
Button btnLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button) findViewById(R.id.btn_login);

        //intent login dipake sementara buat pindah ke halaman utama
        //nanti kalo udah bisa bikin login nya baru di hapus fungsi intentnya
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iLogin = new Intent(getApplicationContext(), HalamanUtamaActivity.class);
                startActivity(iLogin);
            }
        });

    }
}
