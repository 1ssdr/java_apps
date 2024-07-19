package com.serdar.kbsuygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sil extends AppCompatActivity {
    ListView listview;
    ArrayList<Integer> idler = new ArrayList<>();
    ArrayList<String> isimler = new ArrayList<>();
    ArrayList<String> idlerveisimler = new ArrayList<>();
    String idveisim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sil);
        listview = findViewById(R.id.ogrenciler2);
        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("ogrenciler_Db", MODE_PRIVATE, null);
            Cursor imlec = veriTabani.rawQuery("SELECT * FROM ogrenciler", null);
            int idX = imlec.getColumnIndex("id");
            int isimX = imlec.getColumnIndex("isim");

            while (imlec.moveToNext()) {
                int id = imlec.getInt(idX);
                String isim = imlec.getString(isimX);
                idler.add(id);
                isimler.add(isim);
                idlerveisimler.add(id + " - " + isim);
            }

            ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, idlerveisimler);
            listview.setAdapter(adaptor);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String deger = idlerveisimler.get(position);
                    String[] parcala = deger.split("-");
                    int silinecek = Integer.parseInt(parcala[0].trim());
                    veriTabani.execSQL("DELETE FROM ogrenciler WHERE id=" + silinecek + "");
                    Toast.makeText(sil.this, "Öğrenci Başarı İle Silindi", Toast.LENGTH_SHORT).show();
                    Intent sayfayıyenile = new Intent(sil.this,sil.class);
                    startActivity(sayfayıyenile);
                }
            });

            imlec.close();


        } catch (Exception e) {
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        }
    }

    public void geriGit(View view) {
        idler.clear();
        isimler.clear();
        idlerveisimler.clear();
        Intent intent = new Intent(sil.this, MainActivity.class);
        startActivity(intent);

    }
}