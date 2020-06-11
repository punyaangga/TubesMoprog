package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileAyu extends AppCompatActivity {

    TextView tvEmail, tvYoutube,tvInstagram;
    TextView back;
    TextView telpon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ayu);

        tvEmail = (TextView) findViewById(R.id.TvEmailAyu);
        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://ayuperaiyantika123@gmail.com/";
                Intent iEmail = new Intent(Intent.ACTION_VIEW);
                iEmail.setData(Uri.parse(url));
                startActivity(iEmail);
            }
        });

        tvYoutube = (TextView) findViewById(R.id.TvYoutubeAyu);
        tvYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/channel/UCtssjlWlDPmyHEhjyCI2mNw";
                Intent iYoutube = new Intent(Intent.ACTION_VIEW);
                iYoutube.setData(Uri.parse(url));
                startActivity(iYoutube);
            }
        });

        back = (TextView) findViewById(R.id.TvBackYa);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backk = new Intent(getApplicationContext(),infoProfile.class);
                startActivity(backk);
            }
        });

        telpon= (TextView) findViewById(R.id.TvTelponAyu);
        telpon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nomor = "089679921132";
                Intent iTelpon = new Intent(Intent.ACTION_VIEW);
                iTelpon.setData(Uri.fromParts("tel",nomor,null));
                startActivity(iTelpon);
            }
        });

        tvInstagram = (TextView) findViewById(R.id.TvInstagramAyu);
        tvInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com/peraiyantika/";
                Intent iInst = new Intent(Intent.ACTION_VIEW);
                iInst.setData(Uri.parse(url));
                startActivity(iInst);
            }
        });
    }
}
