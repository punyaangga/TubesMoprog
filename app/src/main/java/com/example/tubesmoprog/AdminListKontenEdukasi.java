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

public class AdminListKontenEdukasi extends AppCompatActivity {
    String[] daftar;
    ListView lvEdukasi;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static AdminListKontenEdukasi ke;
    Button btnAddEdukasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list_konten_edukasi);
        btnAddEdukasi = (Button) findViewById(R.id.btnAddEdukasi);


        btnAddEdukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent iEdukuas = new Intent(AdminListKontenEdukasi.this,AdminKontenEdukasi.class);
                startActivity(iEdukuas);
            }
        });

        ke = this; //nambahin ini
        dbcenter = new DataHelper(this);
        RefreshList();
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
        lvEdukasi = (ListView) findViewById(R.id.lvEdukasi);
        lvEdukasi.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));

        //untuk pilihan
        lvEdukasi.setSelected(true);
        lvEdukasi.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3)
            {
                final String selection = daftar[arg2];
                //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Data", "Update Data", "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminListKontenEdukasi.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
//                                Intent i = new Intent(getApplicationContext(), AdminLihatRsRujukan.class);
//                                i.putExtra("namaRs", selection);
//                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), AdminEditEdukasi.class);
                                in.putExtra("judulKonten", selection);
                                startActivity(in);
                                break;
                            case 2 :
//                                SQLiteDatabase db= dbcenter.getWritableDatabase();
//                                db.execSQL("delete from rs where namaRs = '"+selection+"'");
//                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)lvEdukasi.getAdapter()).notifyDataSetInvalidated(); //nambah ini

    }
}
