package com.serdar.islemler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    TextView skortext;
    TextView sorutext;
    EditText cevaptext;
    int skor;
    int sayi1;
    int sayi2;
    int sonuc;
    Button button;
    Button button2;
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        skortext = findViewById(R.id.skortext);
        sorutext = findViewById(R.id.sorutext);
        cevaptext = findViewById(R.id.cevaptext);
        button = findViewById(R.id.button);
        random = new Random();
        sayi1 = random.nextInt(10);
        sayi2 = random.nextInt(10);
        sonuc = sayi1 + sayi2;
        sorutext.setText(sayi1 + " + " + sayi2);
        skortext.setText("Skor: " + skor);
        cevaptext.setText("");
    }

    public void Button(View view) {
        String cevap = cevaptext.getText().toString();
        if (Integer.parseInt(cevap) == sonuc) {
            skor++;
            skortext.setText("Skor: " + skor);
            sayi1 = random.nextInt(10);
            sayi2 = random.nextInt(10);
            sonuc = sayi1 + sayi2;
            sorutext.setText(sayi1 + " + " + sayi2);
            cevaptext.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "--YANLIŞ CEVAP--", Toast.LENGTH_SHORT).show();

            skor--;
        }
        skortext.setText("Skor: " + skor);
        sayi1 = random.nextInt(10);
        sayi2 = random.nextInt(10);
        sonuc = sayi1 + sayi2;
        sorutext.setText(sayi1 + " + " + sayi2);
        cevaptext.setText("");
    }

    public void baslangic(View view) {
        Intent baslangic = new Intent(this, MainActivity.class);
        startActivity(baslangic);
    }
}

