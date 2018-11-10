package com.google.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import static com.google.bmicalculator.MainActivityCalculator.BMI;


public class MainActivityResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivityCalculator.KEY)) {

            TextView textViewResult;
            textViewResult = findViewById(R.id.textViewResult);

            ImageView imageViewResult;
            imageViewResult = findViewById(R.id.imageViewResult);

            if (BMI < 18.5) {
                imageViewResult.setImageResource(R.drawable.bmi_skinny);
                textViewResult.setText(getString(R.string.underweight_advice));
            } else if (BMI >= 18.5 && BMI <= 24.9) {
                imageViewResult.setImageResource(R.drawable.bmi_normal);
                textViewResult.setText(getString(R.string.normal_advice));
            } else {
                imageViewResult.setImageResource(R.drawable.bmi_overweight);
                textViewResult.setText(getString(R.string.overweight_advice));
            }

        }

    }


}
