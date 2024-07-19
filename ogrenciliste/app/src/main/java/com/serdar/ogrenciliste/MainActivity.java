package com.serdar.ogrenciliste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edittexto;
    Button buttonk;
    Button buttontl;

    ArrayList<String> ogrenciler = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittexto = findViewById(R.id.edittexto);
        buttonk = findViewById(R.id.buttonk);
        buttontl = findViewById(R.id.buttonl);

    }

    public void kaydet(View view) {
        ogrenciler.add(edittexto.getText().toString());
        edittexto.setText("");
        Toast.makeText(this, "Öğrenci Kaydedildi", Toast.LENGTH_SHORT).show();

    }

    public void listele(View view) {
        Intent listele = new Intent(this, MainActivity2.class);
        listele.putStringArrayListExtra("ogrencilerListe", ogrenciler);
        startActivity(listele);
    }
}

