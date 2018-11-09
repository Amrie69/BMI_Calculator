package com.google.bmicalculator;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;

public class MainActivityCalculator extends AppCompatActivity {

    public static final String KEY = "com.google.bmicalculator.BMI";
    protected static double BMI;
    String result;
    double weight;
    double height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        Intent intent = new Intent(this, MainActivityResult.class);
        intent.putExtra(KEY, BMI);
        intent.putExtra(KEY, result);
        startActivity(intent);

    }

    public void checkInput(View view) {
        EditText editTextWeight;
        EditText editTextHeight;

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);

        if (TextUtils.isEmpty(editTextWeight.getText()) || TextUtils.isEmpty(editTextHeight.getText())) {
            editTextWeight.setError(getString(R.string.error_weight));

        }

        calculateBMI(weight, height);
    }

    public double calculateBMI(double weight, double height) {
        BMI = weight / (height * height);
        return BMI;
    }

    public void checkResult(double BMI){
        ImageView imageViewResult;
        imageViewResult = findViewById(R.id.imageViewResult);

        if (BMI < 18.5) {
            imageViewResult.setImageResource(getResources().getIdentifier("bmi_underweight", "drawable", getPackageName()));
            result = "Underweight. Eat and exercise more";
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            imageViewResult.setImageResource(getResources().getIdentifier("bmi_normal", "drawable", getPackageName()));
            result = "Normal. Keep it up.";
        } else {
            imageViewResult.setImageResource(getResources().getIdentifier("bmi_overweight", "drawable", getPackageName()));
            result = "Overweight. Eat less and exercise more.";
        }
    }

}
