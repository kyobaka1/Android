package com.example.dev.the_food_house;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Bao_XemChiTiet extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private ImageView imgv;
    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_bao__xem_chi_tiet);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        tv1 = (TextView) findViewById(R.id.txt_bao_noidung1);
        tv2 = (TextView) findViewById(R.id.txt_bao_noidung2);
        imgv = (ImageView) findViewById(R.id.img_bao_hinh2);

        tv1.setText(b.getString("noidung1").trim());
        tv2.setText(b.getString("noidung2").trim());
        Picasso.get().load(b.getString("hinh2")).into(imgv);
    }
}
