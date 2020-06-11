package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileAyuu extends AppCompatActivity {
    TextView tvEmail, tvYoutube,tvInstagram;
    TextView back;
    TextView telpon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ayuu);

        tvEmail = (TextView) findViewById(R.id.TvEmailAyuu);
        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://ayuperaiyantika123@gmail.com/";
                Intent iEmail = new Intent(Intent.ACTION_VIEW);
                iEmail.setData(Uri.parse(url));
                startActivity(iEmail);
            }
        });

        tvYoutube = (TextView) findViewById(R.id.TvYoutubeAyuu);
        tvYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/channel/UCtssjlWlDPmyHEhjyCI2mNw";
                Intent iYoutube = new Intent(Intent.ACTION_VIEW);
                iYoutube.setData(Uri.parse(url));
                startActivity(iYoutube);
            }
        });

        back = (TextView) findViewById(R.id.TvBackYaa);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backk = new Intent(getApplicationContext(),infoProfileUser.class);
                startActivity(backk);
            }
        });

        telpon= (TextView) findViewById(R.id.TvTelponAyuu);
        telpon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String nomor = "089679921132";
                Intent iTelpon = new Intent(Intent.ACTION_VIEW);
                iTelpon.setData(Uri.fromParts("tel",nomor,null));
                startActivity(iTelpon);
            }
        });

        tvInstagram = (TextView) findViewById(R.id.TvInstagramAyuu);
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
