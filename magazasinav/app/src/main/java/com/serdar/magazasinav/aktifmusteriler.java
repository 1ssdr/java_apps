package com.serdar.magazasinav;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.serdar.magazasinav.databinding.ActivityAktifmusterilerBinding;
import com.serdar.magazasinav.databinding.ActivityMainBinding;

public class aktifmusteriler extends AppCompatActivity {
    private ActivityAktifmusterilerBinding binding;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAktifmusterilerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}