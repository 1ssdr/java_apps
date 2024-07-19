package com.serdar.sinavyeni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button ogrencibutton;
    Button ogretmenbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ogretmenbutton = findViewById(R.id.ogretmenbutton);
        ogrencibutton = findViewById(R.id.ogrencibutton);
    }
    public void buttonogretmen(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2ogretmen.class);
        startActivity(intent);
    }
    public void buttonogrenci(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2ogrenci.class);
        startActivity(intent);
    }
}