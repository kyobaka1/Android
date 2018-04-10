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
import android.widget.Toast;

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
                    case 0: // Đổi hình đại diện

                        break;
                    case 1: // Đổi back groud hình đại diện

                        break;
                    case 2: // Hỗ trợ
                        Intent hotroIntent = new Intent(Setting_Fragment.this, Setting_Fragment_Hotro.class);
                        startActivity(hotroIntent);
                        break;
                    case 3: // Phương thức thanh toán
                        Intent thanhtoanIntent = new Intent(Setting_Fragment.this, Setting_Fragment_Thanhtoan.class);
                        startActivity(thanhtoanIntent);
                        break;
                    case 4:
                        Intent gioithieuIntent = new Intent(Setting_Fragment.this, Setting_Fragment_Gioithieu.class);
                        startActivity(gioithieuIntent);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }
        });

    }
    private void AnhXa(){
        lvMenu = (ListView) findViewById(R.id.listview_menu);
        arrayMenu = new ArrayList<>();
        arrayMenu.add(new MenuCaiDat("Thay hình đại diện",R.drawable.avatar_icon));
        arrayMenu.add(new MenuCaiDat("Thay hình background đại diện",R.drawable.background_icon));
        arrayMenu.add(new MenuCaiDat("Các kênh hỗ trợ",R.drawable.support_icon));
        arrayMenu.add(new MenuCaiDat("Phương thức thanh toán",R.drawable.pay_icon));
        arrayMenu.add(new MenuCaiDat("Đổi mật khẩu",R.drawable.password_icon));
        arrayMenu.add(new MenuCaiDat("Giới thiệu về chuỗi cửa hàng",R.drawable.info_icon));
        arrayMenu.add(new MenuCaiDat("Đăng xuất",R.drawable.dangxuat_icon));
    }
}
