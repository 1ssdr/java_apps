package com.serdar.verigonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edittextisim;
    EditText edittextsoy;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittextisim = findViewById(R.id.edittextisim);
        edittextsoy = findViewById(R.id.edittextsoy);
    }

    public void ikinciSayfayaGit(View view) {
        Intent ikinciSayfayaGit = new Intent(this, MainActivity2.class);
        ikinciSayfayaGit.putExtra("ad",edittextisim.getText().toString() );
        ikinciSayfayaGit.putExtra("soyad",edittextsoy.getText().toString() );
        startActivity(ikinciSayfayaGit);

    }
}