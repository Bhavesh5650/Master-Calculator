package com.example.mastercalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AllCalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_calculation);

        //Id Binding

        LinearLayout allCalcBtn=findViewById(R.id.allCalcBtn);
        LinearLayout mutualFundCalc=findViewById(R.id.mutualFundCalc);
        LinearLayout interestCalc=findViewById(R.id.interestCalc);
        LinearLayout discountCalc=findViewById(R.id.discountCalc);
        LinearLayout emiCalc=findViewById(R.id.emiCalc);
        LinearLayout schoolResultCalc=findViewById(R.id.schoolResultCalc);
        LinearLayout ageCalc=findViewById(R.id.ageCalc);

        // clicking
        allCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mutualFundCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AllCalculationActivity.this, MutualFundActivity.class);
                startActivity(intent);
            }
        });
        interestCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AllCalculationActivity.this, InterestActivity.class);
                startActivity(intent);
            }
        });
        discountCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AllCalculationActivity.this, DiscountActivity.class);
                startActivity(intent);
            }
        });
        emiCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AllCalculationActivity.this, EmiCalculationActivity.class);
                startActivity(intent);
            }
        });
        schoolResultCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AllCalculationActivity.this, SchoolResultActivity.class);
                startActivity(intent);
            }
        });
        ageCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AllCalculationActivity.this, AgeCalculatorActivity.class);
                startActivity(intent);
            }
        });


        Intent intent=getIntent();
    }
}