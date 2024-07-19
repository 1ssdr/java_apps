package com.serdar.mhrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.serdar.mhrs.databinding.ActivityHastaAnasayfaBinding;

public class hastaAnasayfa extends AppCompatActivity {
    private ActivityHastaAnasayfaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHastaAnasayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void randevuAl (View view) {
        Intent randevuAl = new Intent(this, com.serdar.mhrs.randevuAl.class);
        startActivity(randevuAl);
        finish();

    }
    public void gecmisRandevu (View view) {
        Intent gecmisRandevu = new Intent(this,gecmisRandevular.class);
        startActivity(gecmisRandevu);
        finish();

    }
    public void cikis (View view) {
        Intent cikis = new Intent(this,MainActivity.class);
        startActivity(cikis);
        finish();

    }
}