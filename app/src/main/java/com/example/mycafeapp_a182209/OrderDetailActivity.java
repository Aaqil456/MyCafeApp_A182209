package com.example.mycafeapp_a182209;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {
    ImageButton imgBtnCall,imgBtnEmail,imgBtnWeb;
    TextView tvCustName,tvCoffeeQuantity;
    String name;
    int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

         imgBtnCall=findViewById(R.id.imageButtonCall);
         imgBtnEmail=findViewById(R.id.imageButtonEmail);
         imgBtnWeb=findViewById(R.id.imageButtonWeb);

         tvCustName=findViewById(R.id.txt_cust_name);
         tvCoffeeQuantity=findViewById(R.id.txt_coffee_quantity);


         //get info from Main activity
        Intent intent =getIntent();
        quantity = intent.getIntExtra("quantity",0);
        name=intent.getStringExtra("name");

        //show data
        tvCoffeeQuantity.setText(""+quantity);
        tvCustName.setText(name);


    }
}