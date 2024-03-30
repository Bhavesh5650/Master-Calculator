package com.example.mastercalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Method;

import androidx.appcompat.app.AppCompatActivity;

public class AgeCalculatorActivity extends AppCompatActivity {

    EditText birthDateAge;
    EditText birthMonthAge;
    EditText birthYearAge;

    TextView resultAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        //Id Binding

        LinearLayout ageBackBtn=findViewById(R.id.ageBackBtn);
        birthDateAge=findViewById(R.id.birthDateAge);
        birthMonthAge=findViewById(R.id.birthMonthAge);
        birthYearAge=findViewById(R.id.birthYearAge);
        LinearLayout ageCalculateBtn=findViewById(R.id.ageCalculateBtn);
        resultAge=findViewById(R.id.resultAge);


        //Clicking

        ageBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ageCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String age_date=birthDateAge.getText().toString();
                String age_month=birthMonthAge.getText().toString();
                String age_year=birthYearAge.getText().toString();

                if(age_date.isEmpty())
                {
                    birthDateAge.setError("Date Is Required !");
                }
                else if(age_month.isEmpty())
                {
                    birthMonthAge.setError("Month Is Required !");
                }
                else if(age_year.isEmpty())
                {
                    birthYearAge.setError("Year Is Required !");
                }
                else
                {
                    count();
                }

            }
        });

//        Intent intent=getIntent();

    }


    void count()
    {
        int c_date=30,c_month=3,c_year=2024;
        int b_date=Integer.parseInt(birthDateAge.getText().toString());
        int b_month=Integer.parseInt(birthMonthAge.getText().toString());
        int b_year=Integer.parseInt(birthYearAge.getText().toString());

        int date,month,year;

        year=c_year-b_year;

        if(c_date>b_date && c_month>b_month)
        {
            date=c_date-b_date;
            month=c_month-b_month;
        }
        else
        {
            if(c_month<b_month || c_date<b_date)
            {
                year=year-1;
                c_month=c_month+12;
                month=c_month-b_month;
            }
            else
            {
                month=c_month-b_month;
            }
            if(c_date<b_date)
            {
                month=month-1;
                c_date=c_date+30;
                date=c_date-b_date;
            }
            else
            {
                date=c_date-b_date;
            }
        }

        resultAge.setText("Your Age Is "+year);

    }

}