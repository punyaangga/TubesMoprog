package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileDevi extends AppCompatActivity {

    Button btnBack;
    Button btnDeviEmail;
    Button btnDeviLinked;
    Button btnDeviWa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_devi);

        btnBack = (Button) findViewById(R.id.btnBackProfile);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),infoProfile.class);
                startActivity(back);
            }
        });

        btnDeviEmail = (Button) findViewById(R.id.btndeviemail);
        btnDeviEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://devifajarsc@gmail.com/";
                Intent iProfileDevi = new Intent(Intent.ACTION_VIEW);
                iProfileDevi.setData(Uri.parse(url));
                startActivity(iProfileDevi);
            }
        });

        btnDeviLinked = (Button) findViewById(R.id.btndevilinked);
        btnDeviLinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.linkedin.com/in/devi-fajar-850b65137/";
                Intent iProfileDevi = new Intent(Intent.ACTION_VIEW);
                iProfileDevi.setData(Uri.parse(url));
                startActivity(iProfileDevi);
            }
        });

        btnDeviWa= (Button) findViewById(R.id.btndeviwa);
        btnDeviWa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nomor = "085846213308";
                Intent iWa = new Intent(Intent.ACTION_VIEW);
                iWa.setData(Uri.fromParts("tel",nomor,null));
                startActivity(iWa);
            }
        });
    }
}
