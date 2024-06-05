package com.serdar.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeimages(View view){
        //System.out.println("test");
        ImageView kiwi=findViewById(R.id.imageView4);
        kiwi.setImageResource(R.drawable.strawbrry);
        }
}