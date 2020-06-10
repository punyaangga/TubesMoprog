package com.example.tubesmoprog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class LihatPusatEdukasi extends AppCompatActivity {
    String[] daftar;
    ListView lvListEdukasi;
    Menu menu;
    protected Cursor cursor;
    Button backEdukasi;
    DataHelper dbcenter;
    public static LihatPusatEdukasi lp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pusat_edukasi);
        backEdukasi = (Button) findViewById(R.id.btnBackListEdukasi);

        lp = this; //nambahin ini
        dbcenter = new DataHelper(this);
        RefreshList();

        backEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(getApplicationContext(),HalamanUtamaActivity.class);
                startActivity(iBack);
            }
        });
    }
    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM edukasi", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString() ;
        }
        lvListEdukasi = (ListView) findViewById(R.id.listViewEdukasi);
        lvListEdukasi.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));

        lvListEdukasi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String judulKonten = lvListEdukasi.getItemAtPosition(position).toString();
                Intent intent = new Intent(getApplicationContext(),BacaYuk.class);
                intent.putExtra("judulKonten",judulKonten);
                startActivity(intent);
            }
        });

    }
}
