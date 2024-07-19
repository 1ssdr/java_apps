package com.serdar.marketrnotomasyonu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
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
import com.serdar.marketrnotomasyonu.databinding.ActivityUrunDetayBinding;

import java.io.ByteArrayOutputStream;

public class urunDetay extends AppCompatActivity {
    private ActivityUrunDetayBinding binding;
    private ActivityResultLauncher<Intent> galeriLauncher;
    private ActivityResultLauncher<String> izinLauncher;
    private Bitmap secilenGorsel;
    private int gelenid;
    private String gelisSebebi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUrunDetayBinding.inflate(getLayoutInflater());
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
                Toast.makeText(urunDetay.this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        } else {
            urunEkleme();
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
                            Toast.makeText(urunDetay.this, "Görsel Seçiminde Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                } else {
                    Toast.makeText(urunDetay.this, "Galeri İzni Vermeniz Gerekmektedir", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void resimSec(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(view, "Galeri İzni Vermeniz Gerekmektedir", Snackbar.LENGTH_INDEFINITE)
                        .setAction("İzin Ver", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                izinLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
                            }
                        })
                        .show();
            } else {
                Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galeriLauncher.launch(galeriyeGit);
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(view, "Galeri İzni Vermeniz Gerekmektedir", Snackbar.LENGTH_INDEFINITE)
                        .setAction("İzin Ver", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                izinLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                            }
                        })
                        .show();
            } else {
                Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galeriLauncher.launch(galeriyeGit);
            }
        }
    }

    public Bitmap resimKucult(Bitmap gorsel, int maximumBoyut) {
        int genislik = gorsel.getWidth();
        int yukseklik = gorsel.getHeight();
        float oran = (float) genislik / (float) yukseklik;

        if (genislik > yukseklik) {
            genislik = maximumBoyut;
            yukseklik = (int) (genislik / oran);
        } else {
            yukseklik = maximumBoyut;
            genislik = (int) (yukseklik * oran);
        }

        return Bitmap.createScaledBitmap(gorsel, genislik, yukseklik, true);
    }

    public void kaydet(View view) {
        String urunAdi = binding.urunAdiText.getText().toString();
        int urunFiyati = Integer.parseInt(binding.fiyatText.getText().toString());
        int stokAdedi = Integer.parseInt(binding.stokText.getText().toString());

        if (secilenGorsel != null) {
            Bitmap kucukResim = resimKucult(secilenGorsel, 300);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            kucukResim.compress(Bitmap.CompressFormat.PNG, 50, outputStream);
            byte[] resimDizisi = outputStream.toByteArray();

            try {
                SQLiteDatabase veritabani = this.openOrCreateDatabase("market_db", MODE_PRIVATE, null);
                String sql = "INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi, gorsel) VALUES (?, ?, ?, ?)";
                SQLiteStatement sqlDurum = veritabani.compileStatement(sql);
                sqlDurum.bindString(1, urunAdi);
                sqlDurum.bindLong(2, urunFiyati);
                sqlDurum.bindLong(3, stokAdedi);
                sqlDurum.bindBlob(4, resimDizisi);
                sqlDurum.execute();
                Toast.makeText(urunDetay.this, "Ürün Kaydedildi", Toast.LENGTH_SHORT).show();

                Intent urunlereGit = new Intent(urunDetay.this, urunler.class);
                urunlereGit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(urunlereGit);

            } catch (Exception e) {
                Toast.makeText(urunDetay.this, "Kayıt Sırasında Hata Oluştu", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        } else {
            Toast.makeText(urunDetay.this, "Lütfen Bir Görsel Seçiniz", Toast.LENGTH_SHORT).show();
        }
    }

    private void urunEkleme() {
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
                            Toast.makeText(urunDetay.this, "Görsel Seçiminde Hata Oluştu", Toast.LENGTH_SHORT).show();
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
                } else {
                    Toast.makeText(urunDetay.this, "Galeri İzni Vermeniz Gerekmektedir", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
