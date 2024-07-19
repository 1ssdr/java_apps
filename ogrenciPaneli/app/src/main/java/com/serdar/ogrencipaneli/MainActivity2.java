package com.serdar.ogrencipaneli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.serdar.ogrencipaneli.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent gelenVeri = getIntent();
        String ogrenci = gelenVeri.getStringExtra("ogrenci");
        String kurs = gelenVeri.getStringExtra("kursAdi");
        String egitmen = gelenVeri.getStringExtra("egitmenAdi");
        int gorsel = gelenVeri.getIntExtra("gorsel", R.drawable.ogrenci1);
        binding.isimText.setText(ogrenci);
        binding.kursText.setText(kurs);
        binding.egitmenText.setText(egitmen);
        binding.resimtext.setImageResource(gorsel);



    }
    public void ilksayfa(View view) {
        Intent ilksayfagit = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(ilksayfagit);
    }



}

