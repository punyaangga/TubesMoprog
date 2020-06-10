package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanUtamaActivity extends AppCompatActivity {
    Button btnPDarurat,btnPusatInformasi1,
            btnPusatInformasi2,btnPusatInformasi3,getBtnPusatInformasi3;
    Button btnEdukasi,btnRsRujukan,btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        btnPDarurat=(Button) findViewById(R.id.btn_pDarurat);
        btnEdukasi=(Button)findViewById(R.id.btn_pEdukasi);
        btnPusatInformasi1=(Button) findViewById(R.id.btnSatu);
        btnPusatInformasi2=(Button) findViewById(R.id.btnDua);
        btnPusatInformasi3=(Button) findViewById(R.id.btnTiga);
        btnRsRujukan = (Button) findViewById(R.id.btn_rsRujukan);
        btnLogout = (Button) findViewById(R.id.btn_LogoutUser);
        //intent untuk fitur menu menu
        // Start = fungsi ketika klik button Edukasi akan pindah ke list view
        btnEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEdukasi=new Intent(getApplicationContext(),LihatPusatEdukasi.class);
                startActivity(iEdukasi);
            }
        });
        // Finish =fungsi ketika klik button Edukasi akan pindah ke list view
        // Start = fungsi ketika klik button panggilan darurat akan langsung pindah ke kontak telp
        btnPDarurat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nomor = "119";
                Intent iTelp = new Intent(Intent.ACTION_VIEW);
                iTelp.setData(Uri.fromParts("tel",nomor,null));
                startActivity(iTelp);
            }
        });
        //End = fungsi ketika klik button panggilan darurat akan langsung pindah ke kontak telp

        //Start = fungsi ketika klik button daftar rs akan langsung pindah ke list daftar rs
        btnRsRujukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iRsRujukan = new Intent(getApplicationContext(),DaftarRumahSakit.class);
                startActivity(iRsRujukan);
            }
        });
        //End = fungsi ketika klik button daftar rs akan langsung pindah ke list daftar rs

        // intent untuk fitur pusat informasi covid 19
        // Start = fungsi ketika klik pusat informasi covid-19 pindah ke web resmi penangangan covid-19
        btnPusatInformasi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://covid19.go.id/p/berita";
                Intent iCovid = new Intent(Intent.ACTION_VIEW);
                iCovid.setData(Uri.parse(url));
                startActivity(iCovid);
            }
        });
        // End = fungsi ketika klik pusat informasi covid-19 pindah ke web resmi penangangan covid-19

        // Start = fungsi ketika klik pusat informasi BNPD pindah ke web resmi BNPD
        btnPusatInformasi3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String url = "https://bnpb.go.id/berita";
                Intent iBnpd= new Intent(Intent.ACTION_VIEW);
                iBnpd.setData(Uri.parse(url));
                startActivity(iBnpd);
            }
        });
        // End = fungsi ketika klik pusat informasi BNPD pindah ke web resmi BNPD

        // Start = fungsi ketika klik pusat informasi kemenkes pindah ke web resmi kemenkes
        btnPusatInformasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://pusdatin.kemkes.go.id/";
                Intent iKemenkes = new Intent(Intent.ACTION_VIEW);
                iKemenkes.setData(Uri.parse(url));
                startActivity(iKemenkes);
            }
        });
        // End = fungsi ketika klik pusat informasi kemenkes pindah ke web resmi kemenkes

        //Start = Fungsi Logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ilogout = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(ilogout);
            }
        });
        //End = Fungsi Logout

    }

    public void ProfilePembuatUser(View v){
        Intent iProfile = new Intent(getApplicationContext(),infoProfileUser.class);
        startActivity(iProfile);
    }

}
