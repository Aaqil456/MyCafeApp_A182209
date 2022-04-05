package com.example.mycafeapp_a182209;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_quantity;
    Button btnAdd,btnMinus,btnCheckout,btnVideo;
    EditText edit_text_Name;


    int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_quantity=findViewById(R.id.tv_quantity);
        btnAdd=findViewById(R.id.btn_add);
        btnMinus=findViewById(R.id.btn_minus);
        btnVideo=findViewById(R.id.ButtonVideo);
        btnCheckout=findViewById(R.id.btn_checkout);
        edit_text_Name=findViewById(R.id.edit_text_Name);
        quantity=1;


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                tv_quantity.setText(""+quantity);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity--;
                tv_quantity.setText(""+quantity);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            String name;

            @Override
            public void onClick(View v) {
                name=edit_text_Name.getText().toString();
                Toast.makeText(MainActivity.this, "Thank you "+name+" for order "+quantity+" Latte", Toast.LENGTH_SHORT).show();

                //intent
                Intent intent = new Intent(MainActivity.this,OrderDetailActivity.class);

                intent.putExtra("quantity",quantity);
                intent.putExtra("name",name);

                startActivity(intent);

            }
        });


        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + "zYeIqZzmTKs"));

                if(videoIntent.resolveActivity(getPackageManager())!=null) {
                    startActivity(videoIntent);
                }
                else{
                    Toast.makeText(MainActivity.this, "No app can handle this action", Toast.LENGTH_SHORT).show();

                }
                
            }
        });
    }


}