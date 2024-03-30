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

public class DiscountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        //id Binding

        LinearLayout discountBackBtn=findViewById(R.id.discountBackBtn);
        EditText discountPriceEdt=findViewById(R.id.discountPriceEdt);
        EditText discountEdt=findViewById(R.id.discountEdt);
        LinearLayout discountCountBtn=findViewById(R.id.discountCountBtn);
        TextView priceAfterDis=findViewById(R.id.priceAfterDis);
        TextView savedAmount=findViewById(R.id.savedAmount);

        //clicking

        discountBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        discountCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String price_discount=discountPriceEdt.getText().toString();
                String discount=discountEdt.getText().toString();

                if(price_discount.isEmpty())
                {
                    discountPriceEdt.setError("Price Is Required !");
                }
                else if (discount.isEmpty())
                {
                    discountEdt.setError("Discount Is Required !");
                }
                else
                {
                    // p - Price
                    // d - Discount Rate

                    int p=Integer.parseInt(price_discount);
                    double d=Double.parseDouble(discount)/100;

                    double price_after= p - (p * d);
                    double save_amount= p - price_after;

                    priceAfterDis.setText(""+price_after);
                    savedAmount.setText(""+save_amount);
                }
            }
        });

        Intent intent=getIntent();
    }
}