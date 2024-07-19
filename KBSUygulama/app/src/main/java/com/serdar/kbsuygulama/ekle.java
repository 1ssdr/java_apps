package com.serdar.kbsuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kotlin.collections.builders.MapBuilder;

public class ekle extends AppCompatActivity {
    EditText isimText;
    EditText soyisimText;
    EditText yasText;
    EditText sinifText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);
        isimText = findViewById(R.id.isimText);
        soyisimText = findViewById(R.id.soyisimText);
        yasText = findViewById(R.id.yasText);
        sinifText = findViewById(R.id.sinifText);

    }
    public  void ekle (View view) {
        if (isimText.getText().toString().isEmpty() || soyisimText.getText().toString().isEmpty() || sinifText.getText().toString().isEmpty() || yasText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Hiç Bir Alan Boş Geçilemez", Toast.LENGTH_SHORT).show();
        } else {
            try {

                String isim = isimText.getText().toString();
                String soyisim = soyisimText.getText().toString();
                int yas = Integer.parseInt(yasText.getText().toString());
                String sinif = sinifText.getText().toString();

                SQLiteDatabase veriTabani = this.openOrCreateDatabase("ogrenciler_Db", MODE_PRIVATE, null);
                veriTabani.execSQL("INSERT INTO ogrenciler (isim,soyisim,yas,sinif) VALUES ('" + isim + "', '" + soyisim +"', " + yas + ", '" + sinif + "')");
                Toast.makeText(this, "Öğrenci Başarı İle Kaydedildi", Toast.LENGTH_SHORT).show();
                isimText.setText("  ");
                soyisimText.setText("");
                yasText.setText("");
                sinifText.setText("");

            }catch (Exception e){
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void geriGit (View view){
        Intent intent = new Intent(ekle.this, MainActivity.class);
        startActivity(intent);

    }
}