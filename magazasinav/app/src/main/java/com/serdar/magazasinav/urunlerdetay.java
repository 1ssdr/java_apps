package com.serdar.magazasinav;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.serdar.magazasinav.databinding.ActivityUrunlerdetayBinding;

import java.io.ByteArrayOutputStream;

public class urunlerdetay extends AppCompatActivity {
    private ActivityUrunlerdetayBinding binding;
    private ActivityResultLauncher<Intent> galeriLauncher;
    private ActivityResultLauncher<String> izinLauncher;
    private Bitmap secilenGorsel;
    private int gelenid;
    private String gelisSebebi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUrunlerdetayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent gelenVeri = getIntent();
        gelisSebebi = gelenVeri.getStringExtra("gelisSebebi");
        gelenid = gelenVeri.getIntExtra("id", -1);

        if (gelisSebebi != null && gelisSebebi.matches("urunGoster")) {
            try {
                SQLiteDatabase veritabani = this.openOrCreateDatabase("market_db", MODE_PRIVATE, null);
                String sql = "SELECT * FROM urunler WHERE id = ?";
                Cursor imlec = veritabani.rawQuery(sql, new String[]{String.valueOf(gelenid)});

                if (imlec.moveToFirst()) {
                    int urunAdiX = imlec.getColumnIndex("urunAdi");
                    int urunFiyatiX = imlec.getColumnIndex("urunFiyati");
                    int stokAdediX = imlec.getColumnIndex("stokAdedi");
                    int gorselX = imlec.getColumnIndex("gorsel");

                    binding.urunAdiText.setText(imlec.getString(urunAdiX));
                    binding.fiyatText.setText(String.valueOf(imlec.getInt(urunFiyatiX)));
                    binding.stokText.setText(String.valueOf(imlec.getInt(stokAdediX)));

                    byte[] gorselDizisi = imlec.getBlob(gorselX);
                    Bitmap olusanGorsel = BitmapFactory.decodeByteArray(gorselDizisi, 0, gorselDizisi.length);
                    binding.gorsel.setImageBitmap(olusanGorsel);
                }

                imlec.close();
                binding.button3.setVisibility(View.INVISIBLE);

            } catch (Exception e) {
                Toast.makeText(urunlerdetay.this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        } else {
            binding.button3.setVisibility(View.VISIBLE);
        }

        galeriLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode() == RESULT_OK) {
                    Intent galeridenGelen = o.getData();
                    if (galeridenGelen != null) {
                        Uri gorselData = galeridenGelen.getData();

                        try {
                            if (Build.VERSION.SDK_INT >= 28) {
                                ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(), gorselData);
                                secilenGorsel = ImageDecoder.decodeBitmap(source);
                                binding.gorsel.setImageBitmap(secilenGorsel);
                            } else {
                                secilenGorsel = MediaStore.Images.Media.getBitmap(getContentResolver(), gorselData);
                                binding.gorsel.setImageBitmap(secilenGorsel);
                            }

                        } catch (Exception e) {
                            Toast.makeText(urunlerdetay.this, "Görsel Seçiminde Hata Oluştu", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }

                }
            }
        });

        izinLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean o) {
                if (o) {
                    Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    galeriLauncher.launch(galeriyeGit);
                }
            }
        });
    }




    public void kaydet(View view) {
        String urunAdi = binding.urunAdiText.getText().toString();
        int urunFiyati = Integer.parseInt(binding.fiyatText.getText().toString());
        int stokAdedi = Integer.parseInt(binding.stokText.getText().toString());

        {


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


            try {
                SQLiteDatabase veritabani = this.openOrCreateDatabase("market_db", MODE_PRIVATE, null);
                String sql = "INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES (?, ?, ?, ?)";
                SQLiteStatement sqlDurum = veritabani.compileStatement(sql);
                sqlDurum.bindString(1, urunAdi);
                sqlDurum.bindLong(2, urunFiyati);
                sqlDurum.bindLong(3, stokAdedi);
                sqlDurum.execute();
                Toast.makeText(urunlerdetay.this, "Ürün Kaydedildi", Toast.LENGTH_SHORT).show();

                Intent urunlereGit = new Intent(urunlerdetay.this, urunler.class);
                urunlereGit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(urunlereGit);

            } catch (Exception e) {
                Toast.makeText(urunlerdetay.this, "Kayıt Sırasında Hata Oluştu", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }


        public void onActivityResult(Boolean o) {
            if (o) {
                Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galeriLauncher.launch(galeriyeGit);
            } else {
                Toast.makeText(urunlerdetay.this, "Galeri İzni Vermeniz Gerekmektedir", Toast.LENGTH_SHORT).show();
            }
        }
    }


