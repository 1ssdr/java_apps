package com.serdar.islemler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void bolme (View view) {
    Intent bolmegit = new Intent(this, MainActivity4.class);
    startActivity(bolmegit);
}
public void carpma (View view) {
    Intent carpmagit = new Intent(this, MainActivity5.class);
    startActivity(carpmagit);
}
public void toplama (View view) {
    Intent toplamagit = new Intent(this, MainActivity3.class);
    startActivity(toplamagit);
}
public void cikarma (View view) {
    Intent cikarmagit = new Intent(this, MainActivity2.class);
    startActivity(cikarmagit);
}
}