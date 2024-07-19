package com.serdar.tahminoyun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.serdar.tahminoyun.databinding.ActivityMain3Binding;
import com.serdar.tahminoyun.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding binding;
    TextView süretext;
    TextView harftext;
    EditText tahmintext;
    Button buttonal;
    Button buttonet;
    Button buttonD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void buttonD(View view) {
        Intent buttonD = new Intent(this, MainActivity.class);
        startActivity(buttonD);
    }
}