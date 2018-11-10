package com.google.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityCalculator extends AppCompatActivity {

    public static final String KEY = "com.google.bmicalculator.BMI";
    protected static double BMI;
    double weight;
    double height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);


    }

    public void checkInput(View view) {
        EditText editTextWeight;
        EditText editTextHeight;

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);

            if (TextUtils.isEmpty(editTextWeight.getText())){
                editTextWeight.requestFocus();
                Toast.makeText(MainActivityCalculator.this, "Please enter your weight",Toast.LENGTH_LONG).show();

            }
            else if(TextUtils.isEmpty(editTextHeight.getText())){
                editTextHeight.requestFocus();
                Toast.makeText(MainActivityCalculator.this, "Please enter your height",Toast.LENGTH_LONG).show();

            }
            else {
                weight = Double.parseDouble(editTextWeight.getText().toString());
                height = Double.parseDouble(editTextHeight.getText().toString());

                calculateBMI(weight, height);
                Intent intent = new Intent(this, MainActivityResult.class);
                intent.putExtra(KEY, BMI);
                startActivity(intent);
            }

    }

    public double calculateBMI(double weight, double height) {
        BMI = weight / (height * height);
        return BMI;

    }

}
