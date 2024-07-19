package com.serdar.mhrs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.serdar.mhrs.databinding.ActivityRandevuAlBinding;

import java.util.ArrayList;
import java.util.Map;

public class randevuAl extends AppCompatActivity {
    String[] hastaneler = {"Hastane Seçiniz...", "Ankara Üniversitesi Hastanesi", "Gazi Üniversitesi Hastanesi",
            "Hacettepe Üniversitesi Hastanesi", "İbn-i Sina Hastanesi"};
    String[] bolumler = {"Bölüm Seçiniz...", "Ortopedi", "Nöroloji", "Dermotoloji", "Dahiliye", "Psikiyatri"};
    ArrayList<String> doktorlar = new ArrayList<>();
    private ActivityRandevuAlBinding binding;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandevuAlBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        doktorlar.add("Doktor Seçiniz...");

        binding.bolumSpinner.setVisibility(View.INVISIBLE);
        binding.doktorSpinner.setVisibility(View.INVISIBLE);
        binding.text9.setVisibility(View.INVISIBLE);
        binding.text10.setVisibility(View.INVISIBLE);
        binding.text11.setVisibility(View.INVISIBLE);
        binding.text13.setVisibility(View.INVISIBLE);
        binding.text15.setVisibility(View.INVISIBLE);
        binding.text16.setVisibility(View.INVISIBLE);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hastaneler);
        binding.hastaneSpinner.setAdapter(adapter);

        binding.hastaneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!binding.hastaneSpinner.getSelectedItem().equals(hastaneler[0])) {
                    ArrayAdapter adapter2 = new ArrayAdapter<>(randevuAl.this, android.R.layout.simple_list_item_1, bolumler);
                    binding.bolumSpinner.setAdapter(adapter2);
                    binding.bolumSpinner.setVisibility(View.VISIBLE);

                    binding.bolumSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (!binding.bolumSpinner.getSelectedItem().equals(bolumler[0])) {
                                binding.doktorSpinner.setVisibility(View.VISIBLE);
                                String hastane = binding.hastaneSpinner.getSelectedItem().toString();
                                String bolum = binding.bolumSpinner.getSelectedItem().toString();
                                doktorlar.clear();
                                doktorlar.add("Doktor Seçiniz");
                                firestore.collection("doktorlar").whereEqualTo("bolum", bolum).whereEqualTo("hastane", hastane).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                        for (DocumentSnapshot dokuman : value.getDocuments()) {
                                            Map<String, Object> gelenVeri = dokuman.getData();
                                            String gelenDoktor = (String) gelenVeri.get("doktorAdi");
                                            doktorlar.add(gelenDoktor);
                                        }

                                        ArrayAdapter adapter3 = new ArrayAdapter<>(randevuAl.this, android.R.layout.simple_list_item_1, doktorlar);
                                        binding.doktorSpinner.setAdapter(adapter3);

                                        binding.doktorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                            @Override
                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                binding.text9.setVisibility(View.VISIBLE);
                                                binding.text10.setVisibility(View.VISIBLE);
                                                binding.text11.setVisibility(View.VISIBLE);
                                                binding.text13.setVisibility(View.VISIBLE);
                                                binding.text15.setVisibility(View.VISIBLE);
                                                binding.text16.setVisibility(View.VISIBLE);
                                            }

                                            @Override
                                            public void onNothingSelected(AdapterView<?> parent) {
                                                binding.text9.setVisibility(View.INVISIBLE);
                                                binding.text10.setVisibility(View.INVISIBLE);
                                                binding.text11.setVisibility(View.INVISIBLE);
                                                binding.text13.setVisibility(View.INVISIBLE);
                                                binding.text15.setVisibility(View.INVISIBLE);
                                                binding.text16.setVisibility(View.INVISIBLE);
                                            }
                                        });

                                    }
                                });


                            } else {
                                binding.doktorSpinner.setVisibility(View.INVISIBLE);

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }else {
                    binding.bolumSpinner.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}