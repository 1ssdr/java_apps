package com.serdar.tahminoyun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.serdar.tahminoyun.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
TextView textView;
Button buttonN;
Button buttonS;
Button buttonC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        textView=findViewById(R.id.textView);
        buttonN=findViewById(R.id.buttonN);
        buttonS=findViewById(R.id.buttonS);
        buttonC=findViewById(R.id.buttonC);

    }
    public void buttonN(View view) {
        Intent buttonN = new Intent(this,MainActivity2.class);
        startActivity(buttonN);
    }
    public void buttonS(View view) {
        Intent buttonS = new Intent(this,MainActivity3.class);
        startActivity(buttonS);

    }
    public void buttonC(View view) {
        finish();
    }
}