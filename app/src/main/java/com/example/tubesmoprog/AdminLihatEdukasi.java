package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLihatEdukasi extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;

    EditText tampilJudul,tampilIsi;
    Button btnKembaliList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lihat_edukasi);

        tampilIsi = (EditText) findViewById(R.id.EtIsiKonten);
        tampilJudul = (EditText) findViewById(R.id.EtJdlKonten);
        btnKembaliList = (Button) findViewById(R.id.btnBackLihat);

        dbHelper=new DataHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getInfo = getIntent().getStringExtra("judulKonten");
        cursor = db.rawQuery("SELECT * FROM edukasi WHERE judulKonten = '"+getInfo+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            tampilJudul.setText(cursor.getString(1).toString());
            tampilIsi.setText(cursor.getString(2).toString());

        }

        btnKembaliList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ibackList = new Intent(getApplicationContext(),AdminListKontenEdukasi.class);
                startActivity(ibackList);
            }
        });

    }
}
