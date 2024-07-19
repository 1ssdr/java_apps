package com.serdar.ogrencipaneli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.serdar.ogrencipaneli.databinding.ActivityMain2Binding;
import com.serdar.ogrencipaneli.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    Button button;
    ArrayList<ogrenciler> ogrencilerArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ogrencilerArrayList = new ArrayList<>();
        ogrenciler ogrenci1 = new ogrenciler ("İSİM / Elif","KURS / Android Studio","EĞİTMEN / Özlem Aytekin",R.drawable.ogrenci1);
        ogrenciler ogrenci2 = new ogrenciler ("İSİM / Ayşe","KURS / Android Studio","EĞİTMEN / Özlem Aytekin",R.drawable.ogrenci2);
        ogrenciler ogrenci3 = new ogrenciler ("İSİM / Serdar","KURS / Android Studio","EĞİTMEN / Özlem Aytekin",R.drawable.ogrenci3);
        ogrenciler ogrenci4 = new ogrenciler ("İSİM / Ali","KURS / Android Studio","EĞİTMEN / Özlem Aytekin",R.drawable.ogrenci4);

        ogrencilerArrayList.add(ogrenci1);
        ogrencilerArrayList.add(ogrenci2);
        ogrencilerArrayList.add(ogrenci3);
        ogrencilerArrayList.add(ogrenci4);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ogrencilerArrayList.stream().map(ogrenciler -> ogrenciler.isim).collect(Collectors.toList()));
        binding.ogrencilerlistesi.setAdapter(arrayAdapter);

        binding.ogrencilerlistesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detaysayfasi = new Intent(MainActivity.this,MainActivity2.class);
                detaysayfasi.putExtra("ogrenci",ogrencilerArrayList.get(position).isim);
                detaysayfasi.putExtra("kursAdi",ogrencilerArrayList.get(position).kursAdi);
                detaysayfasi.putExtra("egitmenAdi",ogrencilerArrayList.get(position).egitmenAdi);
                detaysayfasi.putExtra("gorsel",ogrencilerArrayList.get(position).gorsel);
                startActivity(detaysayfasi);
            }
        });


    }
}