package com.serdar.mhrs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.serdar.mhrs.databinding.ActivityMainBinding;

import org.w3c.dom.Document;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    public FirebaseFirestore firestore;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        yukleme();
    }

    public void giris(View view) {
        String mail = binding.mailText.getText().toString();
        String sifre = binding.sifreText.getText().toString();
        if (mail.equals("") || sifre.equals("")) {
            Toast.makeText(this, "E-posta ya da Şifre Boş Geçilemez", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(mail, sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent hastaAnasayfa = new Intent(MainActivity. this, com.serdar.mhrs.hastaAnasayfa.class);
                    startActivity(hastaAnasayfa);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

    public void kayit(View view) {
        Intent intent = new Intent(MainActivity.this, kayit.class);
        startActivity(intent);

    }

    public void doktorHastaneKayit() {
        String[] hastaneler = {"Ankara Üniversitesi Hastanesi", "Gazi Üniversitesi Hastanesi",
                "Hacettepe Üniversitesi Hastanesi", "İbn-i Sina Hastanesi"};
        String[] bolumler = {"Ortopedi", "Nöroloji", "Dermotoloji", "Dahiliye", "Psikiyatri"};
        String[] doktorlar = {"Dr Ayşe Yılmaz", "Dr Mehmet Demir", "Dr Fatma Kaya", "Dr Ahmet Çelik", "Dr Zeynep Yıldırım", "Dr Mustafa Şahin",
                "Dr Esra Öztürk", "Dr Ali Aksoy", "Dr Selma Baş", "Dr Hasan Akgün", "Dr Şeyma Özdemir", "Dr Emre Aydın", "Dr Seda Erdoğan", "Dr Murat Kocaman",
                "Dr Elif Yıldız", "Dr İbrahim Taş", "Dr Pelin Güneş", "Dr Cemal Korkmaz", "Dr Şebnem Tekin", "Dr Serkan Yılmaz"};

        for (int i = 0; i < doktorlar.length; i++) {
            HashMap<String, Object> veriKaydet = new HashMap<>();
            veriKaydet.put("doktorAdi", doktorlar[i]);
            veriKaydet.put("hastane", hastaneler[i % hastaneler.length]);
            veriKaydet.put("bolum", bolumler[i % bolumler.length]);
            firestore.collection("doktorlar").add(veriKaydet).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Kaydedilmeyen Doktor Mevcuti", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });


        }
    }

    public void yukleme() {
        firestore.collection("doktorlar").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }
                int i = 0;
                for (DocumentSnapshot dokuman : value.getDocuments()) {
                    i++;

                }
                if (i == 0) {
                    doktorHastaneKayit();
                }

            }
        });
    }
}
