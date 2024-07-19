package com.serdar.sinavbir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ogrencilistesigiris extends AppCompatActivity {
    ArrayList<ogrenciler> ogrencilerArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ogrencilerArrayList = new ArrayList<ogrenciler>();
        ogrenciler ogrenci1 = new ogrenciler("İSİM / Serdar", "Kahraman", "12345");
        ogrenciler ogrenci2 = new ogrenciler("İSİM / Ali", "Kahraman", "12345");
        ogrenciler ogrenci3 = new ogrenciler("İSİM / Veli", "Kahraman", "12345");
        ogrenciler ogrenci4 = new ogrenciler("İSİM / Mehmet", "Kahraman", "12345");
        ogrenciler ogrenci5 = new ogrenciler("İSİM / İbrahim", "Kahraman", "12345");
        ogrenciler ogrenci6 = new ogrenciler("İSİM / Zeki", "Kahraman", "12345");
        ogrenciler ogrenci7 = new ogrenciler("İSİM / Özgür", "Kahraman", "12345");
        ogrenciler ogrenci8 = new ogrenciler("İSİM / Murat", "Kahraman", "12345");
        ogrenciler ogrenci9 = new ogrenciler("İSİM / Kenan", "Kahraman", "12345");
        ogrenciler ogrenci10 = new ogrenciler("İSİM / Egemen", "Kahraman", "12345");
        ogrenciler ogrenci11 = new ogrenciler("İSİM / Deniz", "Kahraman", "12345");
        ogrenciler ogrenci12 = new ogrenciler("İSİM / Yağmur", "Kahraman", "12345");
        ogrenciler ogrenci13 = new ogrenciler("İSİM / Duygu", "Kahraman", "12345");
        ogrenciler ogrenci14 = new ogrenciler("İSİM / İpek", "Kahraman", "12345");
        ogrenciler ogrenci15 = new ogrenciler("İSİM / Elif", "Kahraman", "12345");
        ogrenciler ogrenci16 = new ogrenciler("İSİM / Sevilay", "Kahraman", "12345");
        ogrenciler ogrenci17 = new ogrenciler("İSİM / Seda", "Kahraman", "12345");
        ogrenciler ogrenci18 = new ogrenciler("İSİM / Anıl", "Kahraman", "12345");
        ogrenciler ogrenci19 = new ogrenciler("İSİM / Gizem", "Kahraman", "12345");
        ogrenciler ogrenci20 = new ogrenciler("İSİM / Hazal", "Kahraman", "12345");


        ogrencilerArrayList.add(ogrenci1);
        ogrencilerArrayList.add(ogrenci2);
        ogrencilerArrayList.add(ogrenci3);
        ogrencilerArrayList.add(ogrenci4);
        ogrencilerArrayList.add(ogrenci5);
        ogrencilerArrayList.add(ogrenci6);
        ogrencilerArrayList.add(ogrenci7);
        ogrencilerArrayList.add(ogrenci8);
        ogrencilerArrayList.add(ogrenci9);
        ogrencilerArrayList.add(ogrenci10);
        ogrencilerArrayList.add(ogrenci11);
        ogrencilerArrayList.add(ogrenci12);
        ogrencilerArrayList.add(ogrenci13);
        ogrencilerArrayList.add(ogrenci14);
        ogrencilerArrayList.add(ogrenci15);
        ogrencilerArrayList.add(ogrenci16);
        ogrencilerArrayList.add(ogrenci17);
        ogrencilerArrayList.add(ogrenci18);
        ogrencilerArrayList.add(ogrenci19);
        ogrencilerArrayList.add(ogrenci20);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ogrencilerArrayList.stream().map(ogrenciler -> ogrenciler.isim).collect(Collectors.toList()));
        binding.ogrencilerArrayList.setAdapter(arrayAdapter);

        binding.ogrencilerlistesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detaysayfasi = new Intent(MainActivity.this, MainActivity2.class);
                detaysayfasi.putExtra("ogrenci", ogrencilerArrayList.get(position).ad);
                detaysayfasi.putExtra("ogrenci", ogrencilerArrayList.get(position).soyad);
                detaysayfasi.putExtra("ogrenci", ogrencilerArrayList.get(position).sifre);

                startActivity(detaysayfasi);
            }
        });


    }
}





