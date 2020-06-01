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

public class AdminEditEdukasi extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2;
    String edit;
    TextView textV1, textV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_edukasi);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.EtJdlKonten);
        text2 = (EditText) findViewById(R.id.EtIsiKonten);
        textV1 = (TextView) findViewById(R.id.TVJdlKonten);
        textV2 = (TextView) findViewById(R.id.TvIsiKonten);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

    }
}
