package com.example.mastercalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        //Id Binding

        LinearLayout interestBackBtn=findViewById(R.id.interestBackBtn);
        EditText interestAmountEdt=findViewById(R.id.interestAmountEdt);
        EditText interestRateEdt=findViewById(R.id.interestRateEdt);
        EditText interestTimeEdt=findViewById(R.id.interestTimeEdt);
        LinearLayout interestCalculateBtn=findViewById(R.id.interestCalculateBtn);
        TextView interestAmountResult=findViewById(R.id.interestAmountResult);

        //Clicking

        interestBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        interestCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount_interest=interestAmountEdt.getText().toString();
                String  rate_interest=interestRateEdt.getText().toString();
                String time_interest=interestTimeEdt.getText().toString();

                if(amount_interest.isEmpty())
                {
                    interestAmountEdt.setError("Amount Is Required !");
                }
                else if (rate_interest.isEmpty())
                {
                    interestRateEdt.setError("Interest Is Required !");
                }
                else if (time_interest.isEmpty())
                {
                    interestTimeEdt.setError("Time Is Required !");
                }
                else
                {
                    // p - Amount
                    // r - Rate Of Interest
                    // t - Time
                    // ans = p * r * t
                    int p=Integer.parseInt(amount_interest);
                    double r=Double.parseDouble(rate_interest)/100;
                    int t=Integer.parseInt(time_interest);

                    double ans= p * (1+ (r * t) );

                    interestAmountResult.setText(""+ans);
                }
            }
        });

        Intent intent=getIntent();
    }
}