package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminRsRujukan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSimpanRs;
    EditText edtNamaRs,edtTelp,edtAlamat;
    String simpan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_rs_rujukan);

        dbHelper = new DataHelper(this);
        edtNamaRs=(EditText) findViewById(R.id.EtNamaRs);
        edtTelp=(EditText) findViewById(R.id.EtNoTelp);
        edtAlamat=(EditText) findViewById(R.id.EtAlamat);
        btnSimpanRs=(Button) findViewById(R.id.btnSimpanRs);

        btnSimpanRs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                simpan = edtNamaRs.getText().toString();
                simpan = edtAlamat.getText().toString();
                simpan = edtTelp.getText().toString();
                if (simpan.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Field inputan tidak boleh kosong...",Toast.LENGTH_LONG).show();
                }else{
                    db.execSQL("insert into rs(namaRs,noTelpRs,alamat)values('"+edtNamaRs.getText().toString()+"','"+edtTelp.getText().toString()+"','"+edtTelp.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(),"Data Tersimpan...",Toast.LENGTH_LONG).show();
                    finish();

                }
                AdminListRsRujukan.ma.RefreshList();
            }
        });
    }
}
