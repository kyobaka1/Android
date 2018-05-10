package com.example.dev.the_food_house;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class payviewActivity extends AppCompatActivity {

    ImageView imgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payview);
//        String a = getIntent().get
        final Integer imgint = Integer.parseInt(getIntent().getStringExtra("img"));
//        final String name = getIntent().getStringExtra("name");
        imgview = (ImageView)findViewById(R.id.imageViewBaner);
        imgview.setImageResource(imgint);
    }
}
