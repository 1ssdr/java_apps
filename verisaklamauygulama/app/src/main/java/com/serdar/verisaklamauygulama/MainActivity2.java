package com.serdar.verisaklamauygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textsayfa;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textsayfa=findViewById(R.id.textsayfa);
        button=findViewById(R.id.button);
    }
    public void geri(View view) {
        textsayfa.setText("Merhaba");
    }
}