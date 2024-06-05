package com.serdar.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText multilinetext;
    EditText edittextisim;
    Button button;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multilinetext = findViewById(R.id.multilinetext);
        edittextisim = findViewById(R.id.edittextisim);
        button = findViewById(R.id.button);
    }

    public void kontrol(View view) {
        int sayi = random.nextInt(100);
        multilinetext.setText(multilinetext.getText() + "\n" + edittextisim.getText() + sayi);

    }

    public void ikinciSayfa(View view) {
        Intent ikinciSayfayaGit = new Intent(this, MainActivity2.class);
        startActivity(ikinciSayfayaGit);
    }


}