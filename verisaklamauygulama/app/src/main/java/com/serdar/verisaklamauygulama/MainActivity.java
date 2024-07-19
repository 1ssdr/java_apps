package com.serdar.verisaklamauygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textkullanici;
    EditText textsifre;
    Button buttongiris;
    EditText textisim;
    EditText textsoyisim;
    EditText textkullaniciiki;
    EditText texsifreiki;
    Button buttonkayit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textkullanici = findViewById(R.id.textkullanici);
        textsifre = findViewById(R.id.textsifre);
        buttongiris = findViewById(R.id.buttongiris);
        textisim = findViewById(R.id.textisim);
        textsoyisim = findViewById(R.id.textsoyisim);
        textkullaniciiki = findViewById(R.id.textkullaniciiki);
        texsifreiki = findViewById(R.id.textsifreiki);
        buttonkayit = findViewById(R.id.buttonkayit);
    }

    public void kayıt(View view) {
        String text = textisim.getText().toString();
        String text2 = textsoyisim.getText().toString();
        String text3 = textkullaniciiki.getText().toString();
        String text4 = texsifreiki.getText().toString();
        if (text.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty()) {
            textisim.setError("Lütfen boş alan bırakmayınız");
            textsoyisim.setError("Lütfen boş alan bırakmayınız");
            textkullaniciiki.setError("Lütfen boş alan bırakmayınız");
            texsifreiki.setError("Lütfen boş alan bırakmayınız");
            return;
            }
        }
    }

    public void giris(View view) {
        String text = textkullanici.getText().toString();
        String text2 = textsifre.getText().toString();
        if (text.isEmpty() || text2.isEmpty()) {
            textkullanici.setError("Lütfen boş alan bırakmayınız");
            textsifre.setError("Lütfen boş alan bırakmayınız");
            return;
            Intent intent = new Intent ( Intent.ACTION_VIEW );
        }
    }
}
