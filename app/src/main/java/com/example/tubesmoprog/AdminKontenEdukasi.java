package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminKontenEdukasi extends AppCompatActivity {
    EditText edtJudulKonten,edtIsiKonten ;
    Button btnSaveKonten,btnKembalikeList;
    protected Cursor cursor;
    DataHelper dbHelper;
    String simpanKonten;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_konten_edukasi);

        dbHelper = new DataHelper(this);
        edtJudulKonten=(EditText) findViewById(R.id.EtJdlKonten);
        edtIsiKonten=(EditText) findViewById(R.id.EtIsiKonten);
        btnSaveKonten = (Button) findViewById(R.id.btnSimpanKonten);
        btnKembalikeList=(Button) findViewById(R.id.btnBack);

        btnSaveKonten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                simpanKonten = edtJudulKonten.getText().toString();
                simpanKonten = edtIsiKonten.getText().toString();
                if (simpanKonten.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Field inputan tidak boleh kosong...",Toast.LENGTH_LONG).show();
                }else{
                    db.execSQL("insert into edukasi(judulKonten,isiKonten)values('"+edtJudulKonten.getText().toString()+"','"+edtIsiKonten.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(),"Data Tersimpan...",Toast.LENGTH_LONG).show();
                    finish();

                }
                AdminListKontenEdukasi.ke.RefreshList();

            }
        });

        btnKembalikeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iKembalikeList  = new Intent(AdminKontenEdukasi.this,AdminListKontenEdukasi.class);
                startActivity(iKembalikeList);
            }
        });
    }
}
