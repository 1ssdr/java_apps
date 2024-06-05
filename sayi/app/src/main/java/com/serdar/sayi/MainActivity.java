package com.serdar.sayi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText number1text;
    EditText number2text;
    EditText sonuctext;
    Button button;


    public void karsilastirma (View view) {
        int number1 = Integer.parseInt(number1text.getText().toString());
        int number2 = Integer.parseInt(number2text.getText().toString());
        if (number1 == number2) {
            sonuctext.setText("Sayılar Eşit");
        } else if (number1 > number2) {
            sonuctext.setText(String.valueOf(number1 + "  Sayısı Büyüktür"));
        }else if (number1 < number2) {
            sonuctext.setText(String.valueOf(number2 + " Sayısı Büyüktür"));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1text = findViewById(R.id.number1text);
        number2text = findViewById(R.id.number2text);
        sonuctext = findViewById(R.id.sonuctext);
    }
}
