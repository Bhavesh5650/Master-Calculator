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

import org.w3c.dom.Text;

public class MutualFundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_fund);


        // Id Binding

        LinearLayout mutualBackBtn=findViewById(R.id.mutualBackBtn);
        TextView clearAll=findViewById(R.id.clearAll);
        EditText investEdt=findViewById(R.id.investEdt);
        EditText returnEdt=findViewById(R.id.returnEdt);
        EditText timeEdt=findViewById(R.id.timeEdt);
        LinearLayout mutualResultBtn=findViewById(R.id.mutualResultBtn);
        TextView totalValue=findViewById(R.id.totalValue);
        TextView estReturn=findViewById(R.id.estReturn);
        TextView investedTxt=findViewById(R.id.investedTxt);

        // Clicking

        mutualBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                investEdt.getText().clear();
                returnEdt.getText().clear();
                timeEdt.getText().clear();
            }
        });
        mutualResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String invest_mutual=investEdt.getText().toString();
                String return_mutual=returnEdt.getText().toString();
                String time_mutual=timeEdt.getText().toString();

                if(invest_mutual.isEmpty())
                {
                    investEdt.setError("Investment Is Required !");
                }
                else if (return_mutual.isEmpty())
                {
                    returnEdt.setError("Returns Is Required !");
                }
                else if (time_mutual.isEmpty())
                {
                    timeEdt.setError("Time Is Required !");
                }
                else
                {

                    int p=Integer.parseInt(invest_mutual);
                    double i=Double.parseDouble(return_mutual)/12/100;
                    int n=Integer.parseInt(time_mutual)*12;

                    double ans=p * ((Math.pow(1+i,n)-1) / i) * (1 + i);
                    double est_return=ans-(p*n);
                    double invested=p*n;

                    totalValue.setText(String.format("%.2f",ans));
                    estReturn.setText(String.format("%.2f",est_return));
                    investedTxt.setText(String.format("%.2f",invested));
                }
            }
        });

        Intent intent=getIntent();
    }
}