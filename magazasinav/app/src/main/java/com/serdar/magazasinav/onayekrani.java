package com.serdar.magazasinav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.serdar.magazasinav.databinding.ActivityOnayekraniBinding;
import com.serdar.magazasinav.databinding.ActivityYonetimpaneliBinding;

public class onayekrani extends AppCompatActivity {
    private ActivityOnayekraniBinding binding;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnayekraniBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void urunlerGiris(View view) {
        Intent intent = new Intent(onayekrani.this, urunler.class);
        startActivity(intent);

    }
    public void aktifMusteri (View view) {
        Intent intent = new Intent(onayekrani.this, aktifmusteriler.class);
        startActivity(intent);
    }
    public void onaybekleyenMusterii (View view) {
        Intent intent = new Intent(onayekrani.this, onayMusteri.class);
        startActivity(intent);
    }


}