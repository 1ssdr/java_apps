package com.serdar.verigonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView edittextk;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edittextk = findViewById(R.id.edittextk);
        Intent gelenVeri= getIntent();
        String ad = gelenVeri.getStringExtra("ad");
        String soyad= gelenVeri.getStringExtra("soyad");
        edittextk.setText("---HOŞGELDİNİZ---\n.\n"+ad+" "+soyad);

    }
    public void ilkSayfa (View view) {
        Intent ilksayfagit = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(ilksayfagit);
    }
}