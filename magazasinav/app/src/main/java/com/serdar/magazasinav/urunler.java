package com.serdar.magazasinav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.serdar.magazasinav.databinding.ActivityUrunlerBinding;

import java.util.ArrayList;

public class urunler extends AppCompatActivity {
    public ActivityUrunlerBinding binding;
    ArrayList<Integer> idler = new ArrayList<>();
    ArrayList<String> urunAdlari = new ArrayList<>();
    ArrayList<String> yazilacakIfadeler = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUrunlerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        try {
            SQLiteDatabase veritabani = this.openOrCreateDatabase("market_db", MODE_PRIVATE, null);
            String sql = "INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES (?, ?, ?)";
            SQLiteStatement sqlDurum = veritabani.compileStatement(sql);


            veritabani.execSQL("INSERT INTO urunler (urunAdi) VALUES ('T-shirt')");
            veritabani.execSQL("INSERT INTO urunler (urunAdi) VALUES ('Pantolon')");
            veritabani.execSQL("INSERT INTO urunler (urunAdi) VALUES ('Kazak')");
            veritabani.execSQL("INSERT INTO urunler (urunAdi) VALUES ('Gömlek')");
            veritabani.execSQL("INSERT INTO urunler (urunAdi) VALUES ('Etek')");
            veritabani.execSQL("INSERT INTO urunler (urunAdi) VALUES ('Çanta')");

            veritabani.execSQL("INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES ('T-shirt', 15, 50)");
            veritabani.execSQL("INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES ('Pantolon', 20, 30)");
            veritabani.execSQL("INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES ('Kazak', 10, 70)");
            veritabani.execSQL("INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES ('Gömlek', 18, 40)");
            veritabani.execSQL("INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES ('Etek', 12, 60)");
            veritabani.execSQL("INSERT INTO urunler (urunAdi, urunFiyati, stokAdedi) VALUES ('Çanta', 10, 80)");

            Cursor cursor = veritabani.rawQuery("SELECT * FROM urunler", null);


            while (cursor.moveToNext()) {
                idler.add(cursor.getInt(0));
                urunAdlari.add(cursor.getString(1));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            binding.urunler.setAdapter(adapter);
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(this, "Veritabanına ürün eklenirken bir hata oluştu", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }
        binding.urunler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent urunekle = new Intent(urunler.this, urunlerdetay.class);
                urunekle.putExtra("Geliş Sebebi", "urunDetay");
                urunekle.putExtra("id", idler.get(position));
                startActivity(urunekle);
            }
        });


    }

    public void urunDetay(View view) {
        Intent urunekle = new Intent(urunler.this, urunlerdetay.class);
        urunekle.putExtra("Geliş Sebebi", "urunEkle");
        startActivity(urunekle);

    }
}
