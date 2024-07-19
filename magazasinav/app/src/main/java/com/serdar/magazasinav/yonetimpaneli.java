package com.serdar.magazasinav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.serdar.magazasinav.databinding.ActivityMainBinding;
import com.serdar.magazasinav.databinding.ActivityYonetimpaneliBinding;

public class yonetimpaneli extends AppCompatActivity {
    private ActivityYonetimpaneliBinding binding;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityYonetimpaneliBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            database = openOrCreateDatabase("market_db", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar(id INTEGER PRIMARY KEY AUTOINCREMENT, kullaniciAdi VARCHAR(50), sifre VARCHAR(50))");


            adminKaydet();
        } catch (Exception e) {
            Toast.makeText(this, "hatası: ", Toast.LENGTH_SHORT).show();
        }
    }

    private void adminKaydet() {
        try {

            Cursor cursor = database.rawQuery("SELECT * FROM kullanicilar WHERE kullaniciAdi = 'admin'", null);
            if (cursor.getCount() == 0) {
                database.execSQL("INSERT INTO kullanicilar(kullaniciAdi, sifre) VALUES ('admin', '123456')");
                Toast.makeText(this, "Admin Kullanıcıları Eklendi", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(this, "Admin ekleme hatası: ", Toast.LENGTH_SHORT).show();
        }
    }

    public void GirisYap(View view) {
        String kullaniciAdi = binding.kullaniciAdiText.getText().toString();
        String sifre = binding.sifreText.getText().toString();


        if (kullaniciAdi.isEmpty() || sifre.isEmpty()) {
            Toast.makeText(this, "Kullanıcı adı ve şifre boş bırakılamaz", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Cursor cursor = database.rawQuery("SELECT * FROM kullanicilar WHERE kullaniciAdi = ? AND sifre = ?", new String[]{kullaniciAdi, sifre});
                if (cursor.moveToFirst()) {
                    Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(yonetimpaneli.this, onayekrani.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            } catch (Exception e) {
                Toast.makeText(this, "Giriş yapılırken hata oluştu: ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
