package com.example.activity3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar) {
            Intent i = new Intent(MainActivity.this, ActivityMenu.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Menyimpan input user di edittext kedala variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edittext password kedalam varibel password
                password = edpassword.getText().toString();

                //Membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                Toast t = Toast.makeText(getApplicationContext(),
                        "email anda: "+nama+" dan Password anda: "+password+"", Toast.LENGTH_LONG);

                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                if (nama.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "User atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (nama.equals("Barik") && password.equals("123")){
                        Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (password.equals("123")) {
                            Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (nama.equals("Barik")) {
                                Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Email dan Password Salah!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                t.show();

                Bundle b = new Bundle();

                b.putString("a", nama.trim());

                b.putString("b", password.trim());

                Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                i.putExtras(b);

                startActivity(i);
            }
        });
    }
}
