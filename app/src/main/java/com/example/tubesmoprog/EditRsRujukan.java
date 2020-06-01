package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditRsRujukan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3;
    String edit;
    TextView textV1, textV2, textV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rs_rujukan);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.EtNamaRs);
        text2 = (EditText) findViewById(R.id.EtNoTelp);
        text2 = (EditText) findViewById(R.id.EtAlamat);
        textV1 = (TextView) findViewById(R.id.TVNamaRs);
        textV2 = (TextView) findViewById(R.id.TVNotelp);
        textV2 = (TextView) findViewById(R.id.TVAlamat);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getinfo = getIntent().getStringExtra("idRs");
        String[] pecah = getinfo.split("-");
        cursor = db.rawQuery("SELECT * FROM rs WHERE idRs ='" + pecah[0] + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());

        }
        ton1 = (Button) findViewById(R.id.btnSimpan);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                edit = text1.getText().toString();
                edit = text2.getText().toString();
                edit = text3.getText().toString();

                if (edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong...", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("update rs set noTelpRs='"+text2.getText().toString()+"',alamat='"+text3.getText().toString()+"'where namaRs='"+text1.getText().toString()+"'");
                    Toast.makeText(getApplicationContext(),"Perubaan Tersimpan...",Toast.LENGTH_LONG).show();
                    finish();
                }
                MainActivity.da.RefreshList();
            }
        });
    }
}

