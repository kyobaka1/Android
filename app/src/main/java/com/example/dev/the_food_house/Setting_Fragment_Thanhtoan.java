package com.example.dev.the_food_house;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Admin on 3/9/2018.
 */

public class Setting_Fragment_Thanhtoan extends AppCompatActivity {

    TextView choosepay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_thanhtoan);
        choosepay = (TextView)findViewById(R.id.thanhtoan);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));


        choosepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goi man hinh thanh toan len
                Intent myIntent=new Intent(Setting_Fragment_Thanhtoan.this, payActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
