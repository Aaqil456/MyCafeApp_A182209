package com.example.mycafeapp_a182209;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {
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

        //btn function
        imgBtnCall.setOnClickListener(this);
        imgBtnWeb.setOnClickListener(this);
        imgBtnEmail.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.imageButtonCall:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 0182967861"));
                //verify an app exist for this action
                if(callIntent.resolveActivity(getPackageManager())!=null) {
                    startActivity(callIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "No app can handle this action", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.imageButtonEmail:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your Order From MyCafeApp_A182209");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Email message: Information about your order");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"mycafeapp@company.com"});

                if(emailIntent.resolveActivity(getPackageManager())!=null) {
                    startActivity(emailIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "No app can handle this action", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.imageButtonWeb:
                Uri webpage= Uri.parse("https://en.wikipedia.org/wiki/Coffee");
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

                if(webIntent.resolveActivity(getPackageManager())!=null) {
                    startActivity(webIntent);
                }
                else{
                    Toast.makeText(OrderDetailActivity.this, "No app can handle this action", Toast.LENGTH_SHORT).show();

                }
                break;



        }

    }
}