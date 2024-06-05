package com.serdar.tost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText number1text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1text = findViewById(R.id.number1text);

    }

    public void sayigirin(View view) {
        int number1 = Integer.parseInt (number1text.getText().toString());
        if (number1 > 100) {
            Toast.makeText(this, "Hatalı Değer", Toast.LENGTH_SHORT).show();
        }
        else if (number1 < 50) {
            Toast.makeText(this, "Kötü Not Aldınz", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "Tebrikler İyi Not Aldınız", Toast.LENGTH_SHORT).show();
        }
    }

}


