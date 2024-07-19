package com.serdar.sayacuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView suretext;
    EditText edittextmulti;
    Button buttonbasla;
    Button buttontur;
    Button buttondur;
    Button buttonsifirla;
    Handler handler;
    Runnable runnable;
    int number = 0;
    int tur = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        suretext = findViewById(R.id.suretext);
        edittextmulti = findViewById(R.id.edittextmulti);
        buttonbasla = findViewById(R.id.buttonbasla);
        buttontur = findViewById(R.id.buttontur);
        buttondur = findViewById(R.id.buttondur);
        buttonsifirla = findViewById(R.id.buttonsifirla);
        suretext.setText("Süre:" + number);
        buttondur.setEnabled(false);
        buttonsifirla.setEnabled(false);

    }

    public void basla(View view) {
        buttonbasla.setEnabled(false);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                number++;
                int dakika = number / 60;
                int saniye = number % 60;
                suretext.setText("Süre: " + dakika + ":" + String.format("%02d", saniye));
                handler.postDelayed(this, 1000);
                buttondur.setEnabled(true);
                buttonsifirla.setEnabled(true);

            }


        };
        handler.post(runnable);
    }

    public void dur(View view) {
        buttonbasla.setEnabled(true);
        handler.removeCallbacks(runnable);
        buttondur.setEnabled(false);

    }

    public void sifirla(View view) {
        number = 0;
        suretext.setText("Süre:" + number);
        handler.removeCallbacks(runnable);
        tur = 0;
        edittextmulti.setText("");
        buttonbasla.setEnabled(true);

    }

    public void tur(View view) {
        tur++;
        edittextmulti.setText(edittextmulti.getText() + "\n" + tur + ".Tur:" + " " + number);

    }

}
