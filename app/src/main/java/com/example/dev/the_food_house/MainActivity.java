package com.example.dev.the_food_house;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPage;
    private ImageButton btnHome;
    private ImageButton btnFood;
    private ImageButton btnLogin;
    private ImageButton btnSetting;
    private ImageButton btnLocation;
    private ImageButton btnOder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnHome = (ImageButton) findViewById(R.id.btnFood);
        btnFood = (ImageButton) findViewById(R.id.btnFood_);
        btnLocation = (ImageButton) findViewById(R.id.btnLocation);
        btnOder = (ImageButton) findViewById(R.id.btnOder);
        btnSetting = (ImageButton) findViewById(R.id.btn_setting);


        mViewPage = findViewById(R.id.viewPager);
        mViewPage.setAdapter(new Adapter(getSupportFragmentManager()));
        mViewPage.setCurrentItem(0);
        init();
    }

    protected void init(){
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPage.setCurrentItem(0);
            }
        });
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPage.setCurrentItem(1);
            }
        });
        btnOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPage.setCurrentItem(2);
            }
        });
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPage.setCurrentItem(3);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingIntent = new Intent(MainActivity.this, Setting_Fragment.class);
               startActivity(settingIntent);
            }
        });
    }


}