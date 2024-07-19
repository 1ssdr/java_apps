package com.serdar.oyunp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView skorText;
    TextView zamanText;
    TextView yuksekSkorText;
    int skor = 0;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] gorseller;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skorText = findViewById(R.id.skorText);
        zamanText = findViewById(R.id.zamanText);
        yuksekSkorText = findViewById(R.id.yuksekSkorText);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                zamanText.setText("Kalan Süre : " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                SharedPreferences skorTut = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                int enYuksekSkor = skorTut.getInt("yuksekSkor", 0);
                if (skor > enYuksekSkor) {
                    SharedPreferences.Editor editor = skorTut.edit();
                    editor.putInt("yuksekSkor", skor);
                    editor.apply();

                }
                zamanText.setText("Süre Bitti");
                handler.removeCallbacks(runnable);
                for (ImageView resim : gorseller){
                    resim.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder mesaj = new AlertDialog.Builder(MainActivity.this);
                mesaj.setTitle("Yeniden Başla");//Ekran mesajının başlığı
                mesaj.setMessage("Tekrar Oynamak İstermisin");//ekran mesajının içeriği
                mesaj.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent bastanBasla = getIntent();
                        finish();
                        startActivity(bastanBasla);
                    }
                });
                mesaj.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Oyun Bitti!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                mesaj.show();
            }

        }.start();
        gorseller = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
        gorselGizle();

    }

    public void skorArttir(View view) {
        skor++;
        skorText.setText("Skor : " + skor);
        SharedPreferences skoruTut = this.getPreferences(Context.MODE_PRIVATE);
        int enYuksekSkor = skoruTut.getInt("yuksekSkor", 0);
        yuksekSkorText.setText("EN YUKSEK SKOR : " + enYuksekSkor);
    }

    public void gorselGizle() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView resim : gorseller) {
                    resim.setVisibility(View.INVISIBLE);
                }
                Random rastgele = new Random();
                int i = rastgele.nextInt(8);
                gorseller[i].

                        setVisibility(View.VISIBLE);
                handler.postDelayed(runnable, 999);
            }


        };
        handler.post(runnable);
    }
}
