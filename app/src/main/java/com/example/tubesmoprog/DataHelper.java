package com.example.tubesmoprog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="evico";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE__NAME1="login";

    public DataHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //table rumah sakit
        String rs="create table rs (idRs integer primary key autoincrement, namaRs text null,noTelpRs text null,alamat text null);";
        Log.d("Data","onCreate: "+rs);
        db.execSQL(rs);
        //insert data ke table rumah sakit, data ini diambil dari google
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('Rs.Hasan Sadikin','(022) 2034953','Jl. Pasteur No.38, Pasteur, Kec. Sukajadi, Kota Bandung, Jawa Barat 40161');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('Rs Paru Dr.H.A. Rotinsulu','(022) 2034446','Jl. Bukit Jarian No.40, Hegarmanah, Kec. Cidadap, Kota Bandung, Jawa Barat 40141');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('Rs Dustira','(022) 6652207','Jl. Dustira No.1, Baros, Kec. Cimahi Tengah, Kota Cimahi, Jawa Barat 40521');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('Rsud Subang','(0260) 411421','Jl. Brigjen Katamso No.37, Dangdeur, Kec. Subang, Kabupaten Subang, Jawa Barat 41211');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('RS Umum Dokter Slamet Garut','(0262) 232720','Jl. Rsu DR. Slamet No.12, Sukakarya, Kec. Tarogong Kidul, Kabupaten Garut, Jawa Barat 44151');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('Rsud R. Syamsudin, SH','(0266) 225180','Jl. Rumah Sakit No.1, Cikole, Kec. Cikole, Kota Sukabumi, Jawa Barat 43113');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('RS Paru Dr. M. Goenawan Partowidigdo','(0251) 8253630','Jl. Raya Puncak - Cianjur KM.83, Cibeureum, Kec. Cisarua, Bogor, Jawa Barat 16750');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('RSUD Sekarwangi Sukabumi','(0266) 531261','Jl. Siliwangi No.49, Cibadak, Kec. Cibadak, Sukabumi Regency, Jawa Barat 43351');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('RSUD RAA Soewondo','(0295) 381102','Jl. Dr. Susanto No.114, Ngipik, Kutoharjo, Kec. Pati, Kabupaten Pati, Jawa Tengah 59111');";
        db.execSQL(rs);
        rs ="insert into rs (namaRs,noTelpRs,alamat) values('RSUD Dr Moewardi','(0271) 637415','Jl. Kolonel Sutarto No.132, Jebres, Kec. Jebres, Kota Surakarta, Jawa Tengah 57126');";
        db.execSQL(rs);

        //table konten edukasi
        String edukasi="create table edukasi (idEdukasi integer primary key autoincrement, judulKonten text null,isiKonten text null);";
        Log.d("Data","onCreate: "+edukasi);
        db.execSQL(edukasi);

        edukasi = "insert into edukasi (judulKonten,isiKonten) values('Tips Keluar Rumah','Sebelum keluar rumah harus memakai masker');";
        db.execSQL(edukasi);

        //table login
        String logg="create table login(nama text, notelp text, email text primary key, password text, level text);";
        Log.d("Data","onCreate: "+logg);
        db.execSQL(logg);
        //insert data ke table login
        logg ="insert into login (nama,notelp,email,password,level) values('admin', '089679921130', 'admin@evico.com', 'adev','admin');"; //untuk adminn
        db.execSQL(logg);
        logg ="insert into login (nama,notelp,email,password,level) values('user', '081222197907', 'user@evico.com', 'usev','user');"; //untuk user

        db.execSQL(logg);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists login");
    }

    //inserting in database
    public boolean insert(String nama,String notelp,String email,String password, String level){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nama",nama);
        contentValues.put("notelp", notelp);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("level", level);

        long ins = db.insert("login", null, contentValues);
        if(ins==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //Checking email
    public Boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from login where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    //Checking email and password
    public Boolean emailpass(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from login where email=? and password=?", new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    //cadangan
    public Cursor level(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select level from login where email=? and password=?", new String[]{email,password});
        if(cursor.moveToFirst()){
            String str = cursor.getString(cursor.getColumnIndex("level"));
        }
        return cursor;
    }
}
