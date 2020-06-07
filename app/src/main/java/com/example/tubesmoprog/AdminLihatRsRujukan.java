package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLihatRsRujukan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    EditText edtLihatNamaRs,edtLihatTelp,edtLihatAlamat;
    Button backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lihat_rs_rujukan);

        edtLihatNamaRs=(EditText) findViewById(R.id.EtLihatNamaRs);
        edtLihatTelp=(EditText) findViewById(R.id.EtLihatNoTelp);
        edtLihatAlamat=(EditText) findViewById(R.id.EtLihatAlamat);
        backk = (Button) findViewById(R.id.btnBack);

        dbHelper=new DataHelper(this);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String getInfo = getIntent().getStringExtra("namaRs");

        cursor = db.rawQuery("SELECT * FROM rs WHERE namaRs = '"+getInfo+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            edtLihatNamaRs.setText(cursor.getString(1).toString());
            edtLihatTelp.setText(cursor.getString(2).toString());
            edtLihatAlamat.setText(cursor.getString(3).toString());
        }

        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBackk = new Intent(getApplicationContext(),AdminRsRujukan.class);
                startActivity(iBackk);
            }
        });

    }
}
