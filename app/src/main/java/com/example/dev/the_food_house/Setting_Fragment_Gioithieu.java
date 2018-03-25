package com.example.dev.the_food_house;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Admin on 3/9/2018.
 */

public class Setting_Fragment_Gioithieu extends AppCompatActivity {
    private TextView gioithieu1;
    private TextView gioithieu2;
    private TextView gioithieu3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_gioithieu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Viet.ttf");


        gioithieu1 = (TextView) findViewById(R.id.tv_gioithieu1);
        gioithieu2 = (TextView) findViewById(R.id.tv_gioithieu2);
        gioithieu3 = (TextView) findViewById(R.id.tv_gioithieu3);

        gioithieu1.setTypeface(type);
        gioithieu2.setTypeface(type);
        gioithieu3.setTypeface(type);
    }
}