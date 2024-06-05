package com.serdar.siralama;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText multitext;
    Button buttontek;
    Button buttoncift;
    Button buttontop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multitext = (EditText) findViewById(R.id.multitext);
        buttontek = (Button) findViewById(R.id.buttontek);
        buttoncift = (Button) findViewById(R.id.buttoncift);
        buttontop = (Button) findViewById(R.id.buttontop);

    }

    @SuppressLint("SetTextI18n")
    public void buttontek(View view) {
        String text = multitext.getText().toString();
        String[] dizi = text.split(" ");
        String sonuc = "";
        for (int i = 0; i < dizi.length; i++) {
            sonuc += dizi[i] + " ";
        }
        multitext.setText(sonuc);
    }

    @SuppressLint("SetTextI18n")
    public void buttoncift(View view) {
        String text = multitext.getText().toString();
        String[] dizi = text.split(" ");
        String sonuc = "";
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i].length() % 2 == 0) {
                sonuc += dizi[i] + " ";
            }
        }
        multitext.setText(sonuc);
    }

    @SuppressLint("SetTextI18n")
    public void buttontop(View view) {
        String text = multitext.getText().toString();
        String[] dizi = text.split(" ");
        String sonuc = "";
        for (int i = 0; i < dizi.length; i++) {
            sonuc += dizi[dizi.length - 1 - i] + " ";
        }
        multitext.setText(sonuc);
    }
}