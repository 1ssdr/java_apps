package com.serdar.mhrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.serdar.mhrs.databinding.ActivityKayitBinding;

import java.util.HashMap;
import java.util.Objects;

public class kayit extends AppCompatActivity {
    public ActivityKayitBinding binding;
    String[] sehirler = {"Şehir Seçiniz", "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir",
            "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli",
            "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane",
            "Hakkari", "Hatay", "Isparta", "İçel (Mersin)", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri",
            "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin",
            "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas",
            "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak"};
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKayitBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sehirler);
        binding.sehirSpinner.setAdapter(adapter);
    }

    public void hastaKayit(View view) {
        String mail = binding.kayitMailText.getText().toString();
        String sifre = binding.kayitSifreText.getText().toString();
        String sifreTekrar = binding.kayitSifreTekrarText.getText().toString();
        String isim = binding.kayitisimText.getText().toString();
        String soyisim = binding.kayitSoyisimText.getText().toString();
        String sehir = binding.sehirSpinner.getSelectedItem().toString();

        if (mail.equals("") || sifre.equals("") || sifreTekrar.equals("") || isim.equals("") || soyisim.equals("")) {
            Toast.makeText(this, "Tüm Alanları Doldurun", Toast.LENGTH_SHORT).show();
        } else {
            if (!sifre.equals(sifreTekrar)) {
                Toast.makeText(this, "Şifreler Uyuşmuyor", Toast.LENGTH_SHORT).show();


            } else {
                if (sehir.equals(sehirler[0])) {
                    Toast.makeText(this, "Lütfen Şehir Seçimi Yapınız", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(mail, sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(kayit.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();

                            HashMap<String, Object> veriKaydet = new HashMap<>();
                            veriKaydet.put("mail", mail);
                            veriKaydet.put("sifre", sifre);
                            veriKaydet.put("isim", isim);
                            veriKaydet.put("soyisim", soyisim);
                            veriKaydet.put("sehir", sehir);

                            firestore.collection("hastalar").add(veriKaydet).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(kayit.this, "Hasta Kaydı Başarıyla Tamamlandı", Toast.LENGTH_SHORT).show();
                                    Intent giriseDon = new Intent(kayit.this, MainActivity.class);
                                    startActivity(giriseDon);
                                    finish();


                                }

                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(kayit.this, "Hasta Kaydı Yapılamadı. Tekrar Deneyiniz!", Toast.LENGTH_SHORT).show();


                                }
                            });


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(kayit.this, "Kayıt Başarısız: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        }
    }
}