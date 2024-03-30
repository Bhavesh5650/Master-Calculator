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

public class EmiCalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calculation);

        //id Binding

        LinearLayout emiBackBtn=findViewById(R.id.emiBackBtn);
        EditText emiAmountEdt=findViewById(R.id.emiAmountEdt);
        EditText emiInterestEdt=findViewById(R.id.emiInterestEdt);
        EditText emiTimeEdt=findViewById(R.id.emiTimeEdt);
        LinearLayout emiCalculateBtn=findViewById(R.id.emiCalculateBtn);
        TextView interestAmountEmi=findViewById(R.id.interestAmountEmi);
        TextView totalInterestEmi=findViewById(R.id.totalInterestEmi);
        TextView totalPayableAmountEmi=findViewById(R.id.totalPayableAmountEmi);

        //Clicking

        emiBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        emiCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount_emi=emiAmountEdt.getText().toString();
                String interest_emi=emiInterestEdt.getText().toString();
                String time_emi=emiTimeEdt.getText().toString();

                if(amount_emi.isEmpty())
                {
                    emiAmountEdt.setError("Amount Is Required !");
                }
                else if(interest_emi.isEmpty())
                {
                    emiInterestEdt.setError("Interest Is Required !");
                }
                else if(time_emi.isEmpty())
                {
                    emiTimeEdt.setError("Time Is Required !");
                }
                else
                {
                    // p - Amount
                    // r - Interest
                    // n - Time

                    int p=Integer.parseInt(amount_emi);
                    double r=Double.parseDouble(interest_emi)/(12*100);
                    int n=Integer.parseInt(time_emi)*12;

                    double ans=p*r*(Math.pow((1+r),n))/(Math.pow((1+r),n)-1);
                    double pay_amount=ans*n;
                    double total_interest=pay_amount-p;

                    interestAmountEmi.setText(String.format("%.2f",ans));
                    totalInterestEmi.setText(String.format("%.2f",total_interest));
                    totalPayableAmountEmi.setText(String.format("%.2f",pay_amount));



                }
            }
        });

        Intent intent=getIntent();
    }
}