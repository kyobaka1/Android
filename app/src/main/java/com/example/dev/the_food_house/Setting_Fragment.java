package com.example.dev.the_food_house;

import android.annotation.SuppressLint;;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dev on 3/4/2018.
 */

public class Setting_Fragment extends AppCompatActivity {
    ListView lvMenu;
    ArrayList<MenuCaiDat> arrayMenu;
    menuCaiDatAdapter adapter;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_fragment_setting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Viet.ttf");
        AnhXa();
        adapter = new menuCaiDatAdapter(this,R.layout.dnv_dong_menu_caidat, arrayMenu);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i : Trả về vị trí người dùng đang click trên Listview.
                switch (i){
                    case 0: // Quản lí tài khoản.
                        Intent intent = new Intent(Setting_Fragment.this,Setting_Fragment_Quanlitaikhoan.class);
                        startActivity(intent);
                        break;
                    case 1: // Quản lí tài khoản.
                        Intent intentThanhtoan = new Intent(Setting_Fragment.this,Setting_Fragment_Thanhtoan.class);
                        startActivity(intentThanhtoan);
                        break;
                    case 2: // Quản lí tài khoản.
                        Intent intentHotro = new Intent(Setting_Fragment.this,Setting_Fragment_Hotro.class);
                        startActivity(intentHotro);
                        break;
                    case 3: // Quản lí tài khoản.
                        Intent intentGioithieu = new Intent(Setting_Fragment.this,Setting_Fragment_Gioithieu.class);
                        startActivity(intentGioithieu);
                        break;
                }
            }
        });

    }
    private void AnhXa(){
        lvMenu = (ListView) findViewById(R.id.listview_menu);
        arrayMenu = new ArrayList<>();
        arrayMenu.add(new MenuCaiDat("Quản lí tài khoản",R.drawable.usericon));
        arrayMenu.add(new MenuCaiDat("Thanh toán",R.drawable.payicon));
        arrayMenu.add(new MenuCaiDat("Hỗ trợ",R.drawable.supporticon));
        arrayMenu.add(new MenuCaiDat("Giới thiệu",R.drawable.helpicon));


    }
}
