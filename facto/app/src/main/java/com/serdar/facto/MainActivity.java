package com.serdar.facto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numbertext;
    TextView textView;
Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbertext = findViewById(R.id.numbertext1);
        textView = findViewById(R.id.textView);

    }

    @SuppressLint("SetTextI18n")
    public void kontrol(View view) {
        int number1 = Integer.parseInt(numbertext.getText().toString());
        int fakto = 1;
        for (int i = 1; i <= number1; i++) {
            fakto *= i;
        }
        textView.setText(number1 + " sayısının faktoriyeli: " + fakto);
    }
}
