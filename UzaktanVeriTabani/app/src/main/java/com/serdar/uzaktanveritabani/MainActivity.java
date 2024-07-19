package com.serdar.uzaktanveritabani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.serdar.uzaktanveritabani.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
    }


    public void giris(View view) {
        String mail = binding.girisMail.getText().toString();
        String sifre = binding.girisSifre.getText().toString();
        if (mail.equals("") || sifre.equals("")) {
            Toast.makeText(this, "Hatalı İşlem Kullanıcı Adı ve Şifre Boş Geçilemez", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(mail, sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
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
        String mail = binding.kayitMail.getText().toString();
        String sifre = binding.kayitSifre.getText().toString();

        if (mail.equals("") || sifre.equals("")) {
            Toast.makeText(this, "Hatalı İşlem Kullanıcı Adı, Şifre ve Şifre Tekrar Boş Geçilemez", Toast.LENGTH_SHORT).show();
        } else {
            auth.createUserWithEmailAndPassword(mail, sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}