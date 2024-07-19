package com.serdar.sinavbir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonogretmen;
    Button buttonogrenci;
    ArrayList<ogrenciler> ogrencilerArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonogretmen = findViewById(R.id.buttonogretmen);
        buttonogrenci = findViewById(R.id.buttonogrenci);
    }
    public void buttonogretmen(View view) {
        Intent intent = new Intent(MainActivity.this, ogretmen.class);
        startActivity(intent);
    }
    public void buttonogrenci(View view) {
        Intent intent = new Intent(MainActivity.this, ogrenci.class);
        startActivity(intent);
    }
}