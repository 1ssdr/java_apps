package com.serdar.verisaklama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText isimtext;
    TextView gelentext;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isimtext = findViewById(R.id.isimtext);
        gelentext = findViewById(R.id.gelentext);
        button = findViewById(R.id.button);
        SharedPreferences veriGetir = this.getPreferences(Context.MODE_PRIVATE);
        String gelenveri = veriGetir.getString("ad","");
        if (!gelenveri.isEmpty()) {
            gelentext.setText(gelenveri);
        }
    }
    public void kaydet(android.view.View view) {
        SharedPreferences veriKaydet = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = veriKaydet.edit();
        editor.putString("ad", isimtext.getText().toString());
        editor.apply();
        gelentext.setText(isimtext.getText().toString());
        isimtext.setText("");
    }
}
