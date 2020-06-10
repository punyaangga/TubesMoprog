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

public class AdminEditEdukasi extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    EditText editJudulKonten,editIsiKonten,editId;
    Button btnUpdateBack,btnUpdateEdukasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_edukasi);

        dbHelper = new DataHelper(this);
        editJudulKonten = (EditText) findViewById(R.id.EditJdlKonten);
        editIsiKonten= (EditText) findViewById(R.id.EditIsiKonten);
        editId=(EditText) findViewById(R.id.EditIdKonten);
        btnUpdateBack = (Button) findViewById(R.id.btnUpdateBack);
        btnUpdateEdukasi = (Button) findViewById(R.id.btnUpdateEdukasi);

        btnUpdateBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iKembali = new Intent(getApplicationContext(),AdminListKontenEdukasi.class);
                startActivity(iKembali);
            }
        });

        //Start = fungsi nampilin data ke form
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getInfo = getIntent().getStringExtra("judulKonten");
        cursor = db.rawQuery("SELECT * FROM edukasi WHERE judulKonten = '"+getInfo+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            editId.setText(cursor.getString(0).toString());
            editJudulKonten.setText(cursor.getString(1).toString());
            editIsiKonten.setText(cursor.getString(2).toString());
        }
        //Finish = fungsi nampilin data ke form

        btnUpdateEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                db.execSQL("update edukasi set judulKonten ='"+
                        editJudulKonten.getText().toString()+"', isiKonten ='"+
                        editIsiKonten.getText().toString()+"' where idEdukasi = '"+
                        editId.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Data Berhasil di Perbarui", Toast.LENGTH_SHORT).show();
                AdminListKontenEdukasi.ke.RefreshList();
                finish();
            }
        });


    }
}