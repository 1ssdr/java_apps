package com.serdar.sayacarkaiyi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textsure;
    Button buttonbasla;
    Button buttondur;
    Handler handler;
    Runnable runnable;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textsure = findViewById(R.id.textsure);
        buttonbasla = findViewById(R.id.buttonbasla);
        buttondur = findViewById(R.id.buttondur);
        textsure.setText("Süre:" + number);
    }

    public void basla(View view) {
        buttonbasla.setEnabled(false);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                number++;
                textsure.setText("Süre:" + number);
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }
    public void dur(View view) {
        buttonbasla.setEnabled(true);
        handler.removeCallbacks(runnable);
    }
    public void reset(View view) {
        number = 0;
        textsure.setText("Süre:" + number);
        buttonbasla.setEnabled(true);
        handler.removeCallbacks(runnable);
    }
    }


