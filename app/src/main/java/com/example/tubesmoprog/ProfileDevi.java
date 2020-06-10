package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileDevi extends AppCompatActivity {
    Button btnDeviEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_devi);
        btnDeviEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "devifajarsc@gmail.com";
                Intent iProfileDevi = new Intent(Intent.ACTION_VIEW);
                iProfileDevi.setData(Uri.parse(url));
                startActivity(iProfileDevi);
            }
        });
    }
}