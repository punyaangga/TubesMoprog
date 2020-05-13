package com.example.tubesmoprog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="evico";
    private static final int DATABASE_VERSION=1;

    public DataHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //table user
        String user ="create table user (idUser integer primary key autoincrement, nama text null, noTelp text null, email text null,password text null,level text null);";
        Log.d("Data","onCreate: "+user);
        db.execSQL(user);
        //note ditable user ada filed level itu sebagai validasi level jika levelnya admin maka akun tersebut hanya bisa masuk ke halaman admin
        //dan jika levelnya user maka akun tersebut hanya bisa masuk ke halaman user.

        //insert data untuk admin sebagai akun pertama sebagai admin
        user ="insert into user (idUser,nama,noTelp,email,password,level) values('','admin','089640065487','admin@evico.com','admin');";
        db.execSQL(user);
        //insert data untuk user sebagai akun pertama sebagai user
        user ="insert into user (idUser,nama,noTelp,email,password,level) values('','user','089640065488','user@evico.com','user');";
        db.execSQL(user);

        //table rumah sakit
        String rs="crate table rs (idRs integer primary key autoincrement, namaRs text null,noTelpRs text null,alamat text null);";
        Log.d("Data","onCreate: "+rs);
        db.execSQL(rs);
        //insert data dummy ke table rumah sakit
        rs ="insert into rs (idRs,namaRs,noTelpRs,alamat) values('','Hasan Sadikin','(022) 2034953','Jl. Pasteur No.38, Pasteur, Kec. Sukajadi, Kota Bandung, Jawa Barat 40161');";
        db.execSQL(rs);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
