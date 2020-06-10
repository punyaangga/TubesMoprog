package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin ;
    EditText e1,e2;
    TextView keterangan;
    DataHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DataHelper(this);

        btnLogin=(Button) findViewById(R.id.btn_login);
        e1 =(EditText)findViewById(R.id.EtEmail);
        e2 = (EditText)findViewById(R.id.EtPassword);
        keterangan = (TextView)findViewById(R.id.Keterangan);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpass(email,password);
                //String cekya = db.level(email,password);
                //Cursor cursor = db.level(email,password);
                //String a = cursor().toString();

                if(Chkemailpass==true){
                    Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_SHORT).show();

                    if(e1.getText().toString().equals("admin@evico.com")){
                        Intent iLogin = new Intent(getApplicationContext(), DashboardAdmin.class);
                        startActivity(iLogin);
                    }

                    else{
                        Intent iLogin2 = new Intent(getApplicationContext(), HalamanUtamaActivity.class);
                        startActivity(iLogin2);
                    }
                }

                else{
                    Toast.makeText(getApplicationContext(),"Login Gagal!! Periksa kembali Username dan Password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

