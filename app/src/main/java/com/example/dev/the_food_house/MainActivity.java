package com.example.dev.the_food_house;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    private ViewPager mViewPage;
    private ImageButton btnHome;
    private ImageButton btnFood;
    private ImageButton btnLogin;
    private ImageButton btnSetting;
    private ImageButton btnLocation;
    private ImageButton btnOder;
    private ImageButton btnMusic;
    String x="1";
    String name;
    String name1;
    String name2;
    String name3;
    String name4;
    String name5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Viet.ttf");
        actionBar.hide();

        btnHome = (ImageButton) findViewById(R.id.btnFood);
        btnFood = (ImageButton) findViewById(R.id.btnFood_);
        btnLocation = (ImageButton) findViewById(R.id.btnLocation);
        btnOder = (ImageButton) findViewById(R.id.btnOder);
        btnSetting = (ImageButton) findViewById(R.id.btn_setting);
        btnMusic = (ImageButton) findViewById(R.id.btnMusic);




        //////////////////////////////////////////////////////////////////////////////////////////////
        Intent intent = getIntent();
        //doan nay bat cái put extra (YourValueKey) = "1"
        name = intent.getStringExtra("YourValueKey");
        name1 = intent.getStringExtra("YourValueKey1");
        name5 = intent.getStringExtra("YourValueKey5");

        //Log.e("name","1 :"+name+"2:"+name1);

        if(x.equalsIgnoreCase(name)) {

            mViewPage = findViewById(R.id.viewPager);
            mViewPage.setAdapter(new Adapter(getSupportFragmentManager()));

            mViewPage.setCurrentItem(1);
            init();
        }
        else {
            mViewPage = findViewById(R.id.viewPager);
            mViewPage.setAdapter(new Adapter(getSupportFragmentManager()));
            mViewPage.setCurrentItem(0);
            init();
        }


        if(x.equalsIgnoreCase(name1)){

            Intent it=new Intent(this,Oder_Food_Activity.class);
            startActivity(it);
        }
        else {

            mViewPage = findViewById(R.id.viewPager);
            mViewPage.setAdapter(new Adapter(getSupportFragmentManager()));
            mViewPage.setCurrentItem(0);

            init();
        }

        if(x.equalsIgnoreCase(name5)){

            Intent it=new Intent(this,HistoryActivity.class);
            startActivity(it);
        }
        else {

            mViewPage = findViewById(R.id.viewPager);
            mViewPage.setAdapter(new Adapter(getSupportFragmentManager()));
            mViewPage.setCurrentItem(0);

            init();
        }
        //////////////////////////////////////////////////////////////////////////////////////



        LocationManager locationManager;

        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
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