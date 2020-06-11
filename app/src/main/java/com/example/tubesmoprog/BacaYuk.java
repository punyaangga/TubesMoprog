package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BacaYuk extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;

    Button btnBackBaca;
    TextView txtJudul,txtIsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_yuk);

        txtJudul = (TextView) findViewById(R.id.judulKonten);
        txtIsi = (TextView) findViewById(R.id.kontenIsi);
        btnBackBaca = (Button) findViewById(R.id.btnBackBaca);
        dbHelper=new DataHelper(this);

        btnBackBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iback= new Intent (getApplicationContext(),LihatPusatEdukasi.class);
                startActivity(iback);
            }
        });
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getInfo = getIntent().getStringExtra("judulKonten");
        cursor = db.rawQuery("SELECT * FROM edukasi WHERE judulKonten = '"+getInfo+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            txtJudul.setText(cursor.getString(1).toString());
            txtIsi.setText(cursor.getString(2).toString());
        }



    }
}
