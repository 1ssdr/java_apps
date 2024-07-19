package com.serdar.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {
    EditText kullaniciadiText;
    EditText sifreText;
    EditText kullaniciadi2Text;
    EditText sifre2Text;
    Boolean varyok = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullaniciadiText = findViewById(R.id.kullaniciadiText);
        sifreText = findViewById(R.id.sifreText);
        kullaniciadi2Text = findViewById(R.id.kullaniciadi2Text);
        sifre2Text = findViewById(R.id.sifre2Text);

        try {
            SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanicilar_Db", MODE_PRIVATE, null);
            veriTabani.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar(id_INTEGER PRIMARY KEY,kullaniciAdi VARCHAR(50),sifre VARCHAR(50))");

        } catch (Exception e) {
            Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
        }
    }

    public void girişYap(View view) {
        String kullaniciAdi = kullaniciadiText.getText().toString();
        String sifre = sifreText.getText().toString();

        if (kullaniciAdi.isEmpty() || sifre.isEmpty()) {
            Toast.makeText(this, "Kullanıcı adı veya şifre boş olamaz", Toast.LENGTH_SHORT).show();
        } else {
            try {
                SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanicilar_Db", MODE_PRIVATE, null);

                Cursor imlec = veriTabani.rawQuery("SELECT * FROM kullanicilar",null);

                int kullaniciimlec = imlec.getColumnIndex("kullaniciAdi");
                int sifreimlec = imlec.getColumnIndex("sifre");
                varyok = false;

                while (imlec.moveToNext()) {
                    if (imlec.getString(kullaniciimlec).equals(kullaniciAdi) && imlec.getString(sifreimlec).equals(sifre)) {
                        varyok = true;
                        break;
                    }
                }
                if (varyok == true){
                    Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Kullanıcı Bulunamadı veya Şifre Hatalı", Toast.LENGTH_SHORT).show();
                }
                imlec.close();

            } catch (Exception e) {
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void kayıtOl(View view) {
        String kullaniciAdi = kullaniciadi2Text.getText().toString();
        String sifre = sifre2Text.getText().toString();
        if (kullaniciAdi.isEmpty() || sifre.isEmpty()) {
            Toast.makeText(this, "Boş Alan Bırakmayınız", Toast.LENGTH_SHORT).show();
        } else {
            try {
                SQLiteDatabase veriTabani = this.openOrCreateDatabase("kullanicilar_Db", MODE_PRIVATE, null);
                veriTabani.execSQL("INSERT INTO kullanicilar(kullaniciAdi,sifre) VALUES('" + kullaniciAdi + "','" + sifre + "')");
                Toast.makeText(this, "Kullanıcı Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Bir Hata Oluştu", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void KullanicilariSil(View view) {
    }
}
