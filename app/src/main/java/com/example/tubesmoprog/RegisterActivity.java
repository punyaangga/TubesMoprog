package com.example.tubesmoprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DataHelper db;
    Button btnRegis;
    EditText etNama, etNoTelp, etEmail, etPass,etLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DataHelper(this);

        etNama=(EditText)findViewById(R.id.EtNama);
        etNoTelp=(EditText)findViewById(R.id.EtNoTelp);
        etEmail=(EditText)findViewById(R.id.EtEmail);
        etPass=(EditText)findViewById(R.id.EtPassword);
        etLevel=(EditText)findViewById(R.id.EtLevel);

        btnRegis=(Button)findViewById(R.id.btn_regist);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = etNama.getText().toString();
                String s2 = etNoTelp.getText().toString();
                String s3 = etEmail.getText().toString();
                String s4 = etPass.getText().toString();
                String s5 = etLevel.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){
                    Toast.makeText(getApplicationContext(),"Maaf Inputan Masih Kosong", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean chkemail = db.chkemail(s3);
                    if (chkemail==true) {
                        Boolean insert = db.insert(s1,s2,s3,s4,s5);
                        if(insert==true){
                            Toast.makeText(getApplicationContext(),"Berhasil Melakukan Registrasi", Toast.LENGTH_SHORT).show();
                            Intent Loginn = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(Loginn);
                        }
                    }

                    else{
                        Toast.makeText(getApplicationContext(),"Email telah terdaftar!!", Toast.LENGTH_LONG).show();
                    }
                }


                //Intent iDashboard= new Intent(getApplicationContext(),DashboardAdmin.class);
                //startActivity(iDashboard);
            }
        });
    }


}
