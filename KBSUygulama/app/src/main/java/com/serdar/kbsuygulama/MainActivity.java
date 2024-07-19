package com.serdar.kbsuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textView2;
    EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("ogrenciler_Db", MODE_PRIVATE, null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS ogrenciler(id INTEGER PRIMARY KEY AUTOINCREMENT,isim VARCHAR(50),soyisim VARCHAR(50),yas INTEGER,sinif VARCHAR(50))");

        } catch (Exception e) {
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        }
    }

    public void ekle(View view) {
        Intent intent = new Intent(MainActivity.this, ekle.class);
        startActivity(intent);

    }
    public void sil (View view) {
        Intent intent = new Intent(MainActivity.this,sil.class);
        startActivity(intent);


    }
    public void listele (View view) {
        Intent intent = new Intent(MainActivity.this, listele.class);
        startActivity(intent);


    }
}