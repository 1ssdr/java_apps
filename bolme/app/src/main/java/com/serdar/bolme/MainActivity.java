package com.serdar.bolme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText textInput;
    Button buttonSingle;
    Button buttonEven;
    Button buttonReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput = findViewById(R.id.text_input);
        buttonSingle = findViewById(R.id.button_single);
        buttonEven = findViewById(R.id.button_even);
        buttonReverse = findViewById(R.id.button_reverse);
    }

    @SuppressLint("SetTextI18n")
    public void buttonSingle(View view) {
        String text = textInput.getText().toString().trim();
        if (!text.isEmpty()) {
            String[] words = text.split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(word).append(" ");
            }
            textInput.setText(result.toString().trim());
        }
    }

    @SuppressLint("SetTextI18n")
    public void buttonEven(View view) {
        String text = textInput.getText().toString().trim();
        if (!text.isEmpty()) {
            String[] words = text.split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                if (word.length() % 2 == 0) {
                    result.append(word).append(" ");
                }
            }
            textInput.setText(result.toString().trim());
        }
    }

    @SuppressLint("SetTextI18n")
    public void buttonReverse(View view) {
        String text = textInput.getText().toString().trim();
        if (!text.isEmpty()) {
            String[] words = text.split(" ");
            StringBuilder result = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                result.append(words[i]).append(" ");
            }
            textInput.setText(result.toString().trim());
        }
    }
}
