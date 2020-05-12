package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanUtamaActivity extends AppCompatActivity {
Button btnPDarurat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        Button btnPDarurat=(Button) findViewById(R.id.btn_pDarurat);

        // Start = fungsi ketika klik button panggilan darurat akan langsung pindah ke kontak telp
        btnPDarurat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nomor = "119";
                Intent telp = new Intent(Intent.ACTION_VIEW);
                telp.setData(Uri.fromParts("tel",nomor,null));
                startActivity(telp);
            }
        });
        //End = fungsi ketika klik button panggilan darurat akan langsung pindah ke kontak telp
    }
}
