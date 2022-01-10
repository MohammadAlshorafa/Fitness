package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BmiActivity extends AppCompatActivity {
    EditText heightEt, weightEt;
    TextView bmiTv;
    Button bmiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        bmiTv = findViewById(R.id.bmiTv);
        bmiBtn = findViewById(R.id.bmiBtn);

        bmiBtn.setOnClickListener(v -> {

            String height = heightEt.getText().toString();
            String weight = weightEt.getText().toString();

            if (height.isEmpty()) {
                Toast.makeText(this, "Please, Enter Your height!", Toast.LENGTH_SHORT).show();
            } else if (weight.isEmpty()) {
                Toast.makeText(this, "Please, Enter Your weight!", Toast.LENGTH_SHORT).show();
            } else {

                float he =  Float.parseFloat(height) * 0.01F;
                float we =  Float.parseFloat(weight);

                float bmi = we / (he * he);

//                Log.d("ttt", bmi+"");

                bmiTv.setText(bmi + "");

                float result = Float.parseFloat(bmiTv.getText().toString());

                if (result < 18.50) {
                    Toast.makeText(this, "Underweight", Toast.LENGTH_SHORT).show();
                } else if (result > 18.50 && bmi < 24.99){
                    Toast.makeText(this, "Healthy Weight", Toast.LENGTH_SHORT).show();
                } else if (result > 25.00 && bmi < 29.99) {
                    Toast.makeText(this, "Overweight", Toast.LENGTH_SHORT).show();
                } else if (result > 30) {
                    Toast.makeText(this, "Obese", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}