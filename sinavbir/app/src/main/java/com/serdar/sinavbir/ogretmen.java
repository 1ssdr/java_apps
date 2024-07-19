package com.serdar.sinavbir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ogretmen extends AppCompatActivity {
    EditText kullanicitext;
    EditText sifretext;
    Button buttongirisogretmen;
    Button buttongeriogretmen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogretmen);
View view = binding.getRoot();
setContentView(view);
        Intent gelenVeri = getIntent();
        String ad = gelenVeri.getStringExtra("ad");
        String soyad = gelenVeri.getStringExtra("soyad")
        String sifre = gelenVeri.getStringExtra("sifre");
        binding.isimText.setText(ad);
        binding.kursText.setText(soyad);
        binding.egitmenText.setText(sifre);

        kullanicitext = findViewById(R.id.kullanicitext);
        sifretext = findViewById(R.id.sifretext);
        buttongirisogretmen = findViewById(R.id.buttongirisogretmen);
        buttongeriogretmen = findViewById(R.id.buttongeriogretmen);
        binding = ActivityogretmenBinding.inflate(getLayoutInflater());
    }
    public void buttongirisogretmen(View view) {
        Intent intent = new Intent(ogretmen.this, ogrencilistesigiris.class);
        startActivity(intent);

    }
    public void buttongeriogretmen(View view) {
        Intent intent = new Intent(ogretmen.this, MainActivity.class);
        startActivity(intent);

    }
}