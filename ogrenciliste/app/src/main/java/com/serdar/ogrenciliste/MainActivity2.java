package com.serdar.ogrenciliste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText edittextliste;

    ArrayList<String> ogrencilerlist = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edittextliste = findViewById(R.id.edittextliste);

        Intent intent = getIntent();
        ogrencilerlist = intent.getStringArrayListExtra("ogrencilerListe");


    }

    public void getList(View view) {
        for (int i = 0; i < ogrencilerlist.size(); i++) {

            edittextliste.setText(edittextliste.getText().toString() + "\n" + ogrencilerlist.get(i));
        }
    }

    public void ilkSayfa(View view) {
        Intent ilksayfagit = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(ilksayfagit);
    }
}