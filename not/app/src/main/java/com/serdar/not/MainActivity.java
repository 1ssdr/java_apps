package com.serdar.not;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textnumberv;
    EditText textnumberf;
    TextView textview;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textnumberv = findViewById(R.id.textnumberv);
        textnumberf = findViewById(R.id.textnumberf);
        textview = findViewById(R.id.textviewn);
    }

    @SuppressLint("SetTextI18n")
    public void kontrol(View view) {
        double numberv = Double.parseDouble(textnumberv.getText().toString());
        double numberf = Double.parseDouble(textnumberf.getText().toString());
        double result = (numberv * 0.4) + (numberf * 0.6);
        Toast.makeText(this, "Ders Notunuz: " + result, Toast.LENGTH_SHORT).show();

        textview.setText("Ders Notunuz : "+(result));



    }

}
