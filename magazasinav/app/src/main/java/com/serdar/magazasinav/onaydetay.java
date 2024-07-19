package com.serdar.magazasinav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class onaydetay extends AppCompatActivity {
    EditText isimText;
    EditText soyisimText;
    EditText kullaniciAdiiText;
    Spinner spinner;
    String[] cinsiyet = {"KADİN","ERKEK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onaydetay);
        isimText = findViewById(R.id.isimText);
        soyisimText = findViewById(R.id.soyisimText);
        kullaniciAdiiText = findViewById(R.id.kullaniciAdiiText);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cinsiyet));


    }

    public void ekle(View view) {
        if (isimText.getText().toString().isEmpty() || soyisimText.getText().toString().isEmpty() || kullaniciAdiiText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Hiç Bir Alan Boş Geçilemez", Toast.LENGTH_SHORT).show();
        } else {

            try {

                String isim = isimText.getText().toString();
                String soyisim = soyisimText.getText().toString();
                String kullaniciadi = kullaniciAdiiText.getText().toString();
                String cinsiyet = spinner.getSelectedItem().toString();


                SQLiteDatabase veriTabani = this.openOrCreateDatabase("market_db", MODE_PRIVATE, null);
                veriTabani.execSQL("INSERT INTO ogrenciler (isim,soyisim,,kullaniciAdii) VALUES ('" + isim + "', '" + soyisim + "', " + ", '" + kullaniciadi + "')");
                Toast.makeText(this, "Müşteri Başarı İle Kaydedildi", Toast.LENGTH_SHORT).show();
                isimText.setText("  ");
                soyisimText.setText("");
                kullaniciAdiiText.setText("");
                Intent intent = new Intent(this, onayekrani.class);
                startActivity(intent);
                finish();


            } catch (Exception e) {
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }


        }
    }
    public void geri(View view) {
        Intent intent = new Intent(this, onayekrani.class);
        startActivity(intent);
    }

}