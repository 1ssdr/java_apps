package com.serdar.tahminoyun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.serdar.tahminoyun.databinding.ActivityMain2Binding;
import com.serdar.tahminoyun.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    String[] iller = {
            "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir",
            "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır",
            "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay",
            "Isparta", "Mersin", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli",
            "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa",
            "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın",
            "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"
    };
    ArrayList<Character> sehirHarfleri;
    String sehirCizgileri = "";
    Random rastgele;
    int rastgeleSehirSira;
    String rastgeleSehir;
    TextView harftext;
    EditText tahmintext;
    Button buttonal;
    Button buttonet;
    Button buttonD;
    int rastgeleHarfSira;
    String[] ipuculuHarfler;
    int puan;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        sehirSec();
    }


    public void sehirSec() {
        rastgele = new Random();
        rastgeleSehirSira = rastgele.nextInt(iller.length);
        rastgeleSehir = iller[rastgeleSehirSira];
        for (int i = 0; i < rastgeleSehir.length(); i++) {
            sehirCizgileri += "- ";
        }
        binding.harftext.setText(sehirCizgileri);

        sehirHarfleri = new ArrayList<>();
        for (char harf : rastgeleSehir.toCharArray()) {
            sehirHarfleri.add(harf);
        }
        ipuculuHarfler = sehirCizgileri.split(" ");
    }

    public void geriDön(View view) {
        Intent geriDön = new Intent(this, MainActivity.class);
        startActivity(geriDön);
    }

    public void harfAl(View view) {
        if (sehirHarfleri.size() > 0) {
            rastgeleSehirSira = rastgele.nextInt(sehirHarfleri.size());
            sehirHarfleri.remove(rastgeleSehirSira);

            int harfSayisi = sehirHarfleri.size();
            for (int i = 0; i < harfSayisi; i++) {
                if (rastgeleHarfSira == i) {
                    ipuculuHarfler[i] = String.valueOf(sehirHarfleri.get(rastgeleHarfSira));

                }
            }
            binding.harftext.setText("");
            for (int i = 0; i < sehirHarfleri.size(); i++) {
                binding.harftext.setText(binding.harftext.getText().toString() + ipuculuHarfler[i]);
            }
        }
    }

    public void tahminEt(View view) {
        String cevap = binding.tahmintext.getText().toString();
        int cizgiAdeti = 0;
        if (cevap.equals(rastgeleSehir)) {
            for (int i = 0; i < rastgeleSehir.length(); i++) {
                if (ipuculuHarfler[i].equals("-")) {
                    cizgiAdeti++;
                }
            }
            puan += cizgiAdeti;
            Toast.makeText(this, "Doğru Tahmin. Alınan Toplam Puan:" + puan, Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Yanlış Tahmin. Tekrar Dene", Toast.LENGTH_SHORT).show();
        }
        sehirSec();
    }
}



