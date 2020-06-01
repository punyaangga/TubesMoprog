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

public class EditRsRujukan extends AppCompatActivity {
    EditText edtUpdateNamaRs,edtUpdateTelp,edtUpdateAlamat,edtUpdateId;
    Button btnUpdate,btnUpdateKembali;
    protected Cursor cursor;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rs_rujukan);

        dbHelper = new DataHelper(this);
        edtUpdateNamaRs = (EditText) findViewById(R.id.EtUpdateNamaRs);
        edtUpdateAlamat= (EditText) findViewById(R.id.EtUpdateAlamat);
        edtUpdateTelp = (EditText) findViewById(R.id.EtUpdateNoTelp);
        edtUpdateId = (EditText)findViewById(R.id.EtUpdateId);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdateKembali = (Button) findViewById(R.id.btnUpdateKembali);

        //Start = fungsi nampilin data ke form
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getInfo = getIntent().getStringExtra("namaRs");
        cursor = db.rawQuery("SELECT * FROM rs WHERE namaRs = '"+getInfo+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            edtUpdateId.setText(cursor.getString(0).toString());
            edtUpdateNamaRs.setText(cursor.getString(1).toString());
            edtUpdateTelp.setText(cursor.getString(2).toString());
            edtUpdateAlamat.setText(cursor.getString(3).toString());
        }
        //Finish = fungsi nampilin data ke form

        // start = fungsi update data
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                db.execSQL("update rs set namaRs ='"+
                        edtUpdateNamaRs.getText().toString()+"', noTelpRs ='"+
                        edtUpdateTelp.getText().toString()+"', alamat = '"+
                        edtUpdateAlamat.getText().toString()+"' where idRs = '"+
                        edtUpdateId.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Data Berhasil di Perbarui", Toast.LENGTH_SHORT).show();
                AdminListRsRujukan.ma.RefreshList();
                finish();
            }
        });
        // finish = fungsi updat data

        //Start =  fungsi ketika klik button pindah ke List RS Rujukan
        btnUpdateKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBackList = new Intent(getApplicationContext(),AdminListRsRujukan.class);
                startActivity(iBackList);
            }
        });
        //Finish =  fungsi ketika klik button pindah ke List RS Rujukan

    }
}

