package com.example.mastercalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgeCalculatorActivity extends AppCompatActivity {

    EditText birthDateAge;
    EditText birthMonthAge;
    EditText birthYearAge;


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
        TextView resultAge=findViewById(R.id.resultAge);


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

        Intent intent=getIntent();

    }

    int c_date=30,c_month=3,c_year=2024;
    int b_date=Integer.parseInt(String.valueOf(birthDateAge));
    int b_month=Integer.parseInt(String.valueOf(birthMonthAge));
    int b_year=Integer.parseInt(String.valueOf(birthYearAge));

    int date,month,year;

    void count()
    {
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

        System.out.println("You Are"+year+"Year Old !");
    }

}