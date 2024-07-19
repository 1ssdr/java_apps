package com.serdar.magazasinav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.serdar.magazasinav.databinding.ActivityOnayMusteriBinding;
import com.serdar.magazasinav.databinding.ActivityOnayekraniBinding;

public class onayMusteri extends AppCompatActivity {
    private ActivityOnayMusteriBinding binding;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnayMusteriBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void detay (View view) {
        Intent intent = new Intent(onayMusteri.this, onaydetay.class);
        startActivity(intent);
    }
}