package com.example.dev.the_food_house;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnFood = (ImageButton) findViewById(R.id.btnFood);
        mViewPage = findViewById(R.id.viewPager);
        mViewPage.setAdapter(new Adapter(getSupportFragmentManager()));
        mViewPage.setCurrentItem(0);
        init();
    }

   protected void init(){
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPage.setCurrentItem(1);
            }
        });
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPage.setCurrentItem(0);
            }
        });

   }
}
