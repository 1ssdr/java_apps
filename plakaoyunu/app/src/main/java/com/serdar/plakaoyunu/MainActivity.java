package com.serdar.plakaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Integer[] ogrencilerNo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    String[] ogrencilerAd = {"Ahmet", "Tolga", "Serdar", "Umut",
            "Anıl", "Kerem", "Alperen", "Barış", "Berfin", "Ayşe",
            "Mehmet", "Fatma", "Mustafa", "Zeynep", "Ali", "Hatice",
            "İbrahim", "Esra", "Yusuf", "Sibel"};
    String[] ogrencilerSoyad = {"Demir", "Yılmaz", "Kaya", "Çelik",
            "Öztürk", "Arslan", "Aksoy", "Kılıç", "Özdemir", "Aydın",
            "Şahin", "Ekinci", "Aslan", "Çakır", "Taşkın", "Erdoğan",
            "Korkmaz", "Doğan", "Tekin", "Özbek"};

    String[] ogrencilerKullaniciAdi = {"ahmetdemir", "tolgayilmaz", "serdarkaya", "umutcelik", "anilozturk",
            "keremarslan", "alperenaksoy", "bariskilic", "berfinozdemir", "ayseaydin",
            "mehmetsahin", "fatmaekinci", "mustafaaslan", "zeynepcakir", "alitaskin", "haticeerdogan", "ibrahimkorkmaz", "esradogan",
            "yusuftekin", "sibelozbek"};
    String ogrenciSifre = "12345";
    String ogretmenKullaniciAdi = "ozlemaytekinadmin";
    String ogretmenSifre = "54321";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dosyayaKaydet();
    }


    public void buttonogretmen(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void buttonogrenci(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }

    public void dosyayaKaydet() {
        SharedPreferences isimleriKaydet = this.getSharedPreferences("dosyam", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = isimleriKaydet.edit();
        for (int i = 0; i < ogrencilerAd.length; i++) {
            String sira = String.valueOf(i);
            String anahtar1 = "no" + sira;
            String anahtar2 = "isim" + sira;
            String anahtar3 = "soyisim" + sira;
            String anahtar4 = "kullaniciAdi" + sira;
            String anahtar5 = anahtar1 + "kullanilanHak";
            editor.putInt(anahtar1, ogrencilerNo[i]);
            editor.putString(anahtar2, ogrencilerAd[i]);
            editor.putString(anahtar3, ogrencilerSoyad[i]);
            editor.putString(anahtar4, ogrencilerKullaniciAdi[i]);
            editor.putInt(anahtar5, 0);
        }
        editor.putString("ogrenciSifre", ogrenciSifre);
        editor.putString("ogretmenKullaniciAdi", ogretmenKullaniciAdi);
        editor.putString("ogretmenSifre", ogretmenSifre);
        editor.apply();

    }}