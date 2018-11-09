package com.google.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;



public class MainActivityResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivityCalculator.KEY)) {
            TextView textViewResult;
            textViewResult = findViewById(R.id.textViewResult);
            String result;
            result = intent.getStringExtra(MainActivityCalculator.KEY);
            textViewResult.setText(result);

            ImageView imageViewResult;
            imageViewResult = findViewById(R.id.imageViewResult);



        }

    }




}
