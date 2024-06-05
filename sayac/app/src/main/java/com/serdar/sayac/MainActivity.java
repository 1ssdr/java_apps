package com.serdar.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView sayacctext;
    Button button;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayacctext = findViewById(R.id.sayacctext);
        button = findViewById(R.id.button);

    }
    public void basla (View view) {
        button.setEnabled(false);
        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sayacctext.setText("Kalan Süre: " + (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                sayacctext.setText("Süre Bitti");
                button.setEnabled(true);
            }
        }.start();
    }
    }