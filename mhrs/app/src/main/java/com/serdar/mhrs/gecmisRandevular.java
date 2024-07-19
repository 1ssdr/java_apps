package com.serdar.mhrs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.serdar.mhrs.databinding.ActivityGecmisRandevularBinding;

import java.util.ArrayList;
import java.util.Map;

public class gecmisRandevular extends AppCompatActivity {
    public ActivityGecmisRandevularBinding binding;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    ArrayList<String> yazdirilacak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGecmisRandevularBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
    }

    public void geriGit(View view) {
        Intent geriGit = new Intent(this, hastaAnasayfa.class);
        startActivity(geriGit);
        finish();
    }
    public void RandevuGetir(){
        FirebaseUser aktifkullanici = auth.getCurrentUser();
        String mail = aktifkullanici.getEmail();

        firestore.collection("randevular").whereEqualTo("mail", mail).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for (DocumentSnapshot dokuman : value.getDocuments()){
                    Map<String,Object> gelenveri = dokuman.getData();
                    String tarih = (String) gelenveri.get("tarih");
                    String hastane = (String) gelenveri.get("hastane");
                    String bolum = (String) gelenveri.get("bolum");
                    String doktor = (String) gelenveri.get("doktor");

                    yazdirilacak.add(tarih+"-"+hastane+"-"+bolum+"-"+doktor);

                }
                ArrayAdapter adepter = new ArrayAdapter<>(gecmisRandevular.this, android.R.layout.simple_list_item_1,yazdirilacak);
                binding.gecmisRandevuList.setAdapter(adepter);

            }
        });

    }

}