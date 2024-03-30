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

public class SchoolResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_result);

        //Id Binding

        LinearLayout schoolBackBtn=findViewById(R.id.schoolBackBtn);
        EditText totalMarkSchool=findViewById(R.id.totalMarkSchool);
        EditText yourTotalMarkSchool=findViewById(R.id.yourTotalMarkSchool);
        LinearLayout schoolResultBtn=findViewById(R.id.schoolResultBtn);
        TextView yourPercentage=findViewById(R.id.yourPercentage);

        //Clicking

        schoolBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        schoolResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String total_mark=totalMarkSchool.getText().toString();
                String your_mark=yourTotalMarkSchool.getText().toString();

                if(total_mark.isEmpty())
                {
                    totalMarkSchool.setError("Total Mark Is Required !");
                }
                else if(your_mark.isEmpty())
                {
                    yourTotalMarkSchool.setError("Your Mark Is Required !");
                }
                else
                {
                    int total_mark_school=Integer.parseInt(total_mark);
                    int your_total_mark=Integer.parseInt(your_mark);

                    double ans=your_total_mark*100/total_mark_school;

                    yourPercentage.setText(String.format("%.2f",ans));
                }
            }
        });

        Intent intent=getIntent();
    }
}