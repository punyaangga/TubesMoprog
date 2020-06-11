package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileAnggaa extends AppCompatActivity {
    Button btnIg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_anggaa);
    }
    public void ig(View v){
        String urlIg="https://www.instagram.com/punya_angga/?hl=id";
        Intent iIg= new Intent(Intent.ACTION_VIEW);
        iIg.setData(Uri.parse(urlIg));
        startActivity(iIg);
    }
    public void git(View v){
        String urlGit ="http://github.com/punyaangga";
        Intent iGit= new Intent(Intent.ACTION_VIEW);
        iGit.setData(Uri.parse(urlGit));
        startActivity(iGit);
    }
    public void fb(View v){
        String urlFb = "https://www.facebook.com/KnightProtec";
        Intent iFb=new Intent(Intent.ACTION_VIEW);
        iFb.setData(Uri.parse(urlFb));
        startActivity(iFb);
    }
    public  void portofolio(View v){
        String urlPor="https://drive.google.com/drive/folders/1x4SwIxQtn3sU-tcX051Y6klXYQ3W2cH7?usp=sharing";
        Intent iPor = new Intent(Intent.ACTION_VIEW);
        iPor.setData(Uri.parse(urlPor));
        startActivity(iPor);
    }
    public void linkedin(View v){
        String urlLinkedin ="https://www.linkedin.com/in/angga-fantiya-hermawan-4bb167190";
        Intent iLikedin= new Intent(Intent.ACTION_VIEW);
        iLikedin.setData(Uri.parse(urlLinkedin));
        startActivity(iLikedin);
    }
    public void back(View v){
        Intent iBack = new Intent(getApplicationContext(),infoProfileUser.class);
        startActivity(iBack);
    }



}

