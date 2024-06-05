package com.serdar.hesap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1text;
     EditText number2text;
     TextView sonuctext;
     Button button1;
     Button button2;
     Button button3;
     Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1text = findViewById(R.id.number1text);
        number2text= findViewById(R.id.number2text);
        sonuctext = findViewById(R.id.sonuctext);
    }
    public void topla(View view){
        if (number1text.getText().toString().matches("") || number2text.getText().toString().matches("")) {
            sonuctext.setText("Lütfen sayıları giriniz");
        }
        else {
            double number1 = Integer.parseInt(number1text.getText().toString());
            double number2 = Integer.parseInt(number2text.getText().toString());
            double sonuc = number1 + number2;
            sonuctext.setText(String.valueOf(sonuc));
        }

    }
    public void cikar(View view){
        if (number1text.getText().toString().matches("")|| number2text.getText().toString().matches("")){
            sonuctext.setText("Lütfen sayıları giriniz");
        }
        else {
            double number1 = Integer.parseInt(number1text.getText().toString());
            double number2 = Integer.parseInt(number2text.getText().toString());
            double sonuc = number1 - number2;
            sonuctext.setText(String.valueOf(sonuc));
        }

    }
    public void carp(View view){
        if (number1text.getText().toString().matches("")|| number2text.getText().toString().matches("")){
            sonuctext.setText("Lütfen sayıları giriniz");
        }
        else {
            double number1 = Integer.parseInt(number1text.getText().toString());
            double number2 = Integer.parseInt(number2text.getText().toString());
            double sonuc =number1*number2;
            sonuctext.setText(String.valueOf(sonuc));
        }

    }
    public void bolme(View view){
        if (number1text.getText().toString().matches("")|| number2text.getText().toString().matches("")){
            sonuctext.setText("Lütfen sayıları giriniz");
        }
        else {
            double number1 = Integer.parseInt(number1text.getText().toString());
            double number2 = Integer.parseInt(number2text.getText().toString());
            double sonuc =number1/number2;
            sonuctext.setText(String.valueOf(sonuc));
        }

    }


}