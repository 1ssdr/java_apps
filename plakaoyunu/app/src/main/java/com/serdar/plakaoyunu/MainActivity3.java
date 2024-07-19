package com.serdar.plakaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.serdar.plakaoyunu.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
    EditText kullanicitext;
    EditText sifretext;
    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        kullanicitext = (EditText) findViewById(R.id.kullanicitext);
        sifretext = (EditText) findViewById(R.id.sifretext);
    }

    public void ogrenciGiris(View view) {
        if (kullanicitext.getText().toString().isEmpty() && sifretext.getText().toString().isEmpty()) {
            Toast.makeText(this, "Kullanıcı Adı ya da Şifre Boş Geçilemez", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences giris = this.getSharedPreferences("dosyam", Context.MODE_PRIVATE);
            for (int i = 0; i < 20; i++) {
                String sira = String.valueOf(i);
                String anahtar = "kullaniciAdi" + sira;
                String anahtar2 = "no" + sira + "kullanilanHak";
                String gelenKullaniciAdi = giris.getString(anahtar, "");
                int gelenHak = giris.getInt(anahtar2, -1);
                if (gelenKullaniciAdi.matches(kullanicitext.getText().toString()) && sifretext.getText().toString().matches("12345")) {
                    if (gelenHak > 2) {
                        Toast.makeText(this, "Kullanıcı Hesabı Kilitlendi", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intent oyunaGit = new Intent(this, ogreciOyun.class);
                    startActivity(oyunaGit);
                    break;
                }
            }else{
                Toast.makeText(this, "Kullanıcı Bulunamadı", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
}