package com.example.dev.the_food_house;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 3/9/2018.
 */

public class Setting_Fragment_Hotro extends AppCompatActivity {
    ListView lvMenuHoTro;
    ArrayList<MenuCaiDat> arrayMenuHotro;
    menuCaiDatAdapter Hotroadapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_hotro);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        final Uri URL = Uri.parse("https://www.facebook.com/viettastevietnamese/");
        AnhXa();
        Hotroadapter = new menuCaiDatAdapter(this,R.layout.dnv_dong_hotro_list, arrayMenuHotro);
        lvMenuHoTro.setAdapter(Hotroadapter);
        lvMenuHoTro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i : Trả về vị trí người dùng đang click trên Listview.
                switch (i){
                    case 0: // Quản lí tài khoản.
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, URL);
                        startActivity(launchBrowser);
                        break;
                    case 1: // Quản lí tài khoản.
                        String phone = "+84988700162";
                        Intent phoneCall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        startActivity(phoneCall);
                        break;
                    case 2: // Quản lí tài khoản.

                        break;
                    case 3: // Quản lí tài khoản.

                        break;
                }
            }
        });
    }
    private void AnhXa(){
        lvMenuHoTro = (ListView) findViewById(R.id.listview_hotro);
        arrayMenuHotro = new ArrayList<>();
        arrayMenuHotro.add(new MenuCaiDat("/viettastevietnamese",R.drawable.facebookicon));
        arrayMenuHotro.add(new MenuCaiDat("0988 700 162",R.drawable.phoneicon));
        arrayMenuHotro.add(new MenuCaiDat("support@vietfeeder.com",R.drawable.emailicon));
        arrayMenuHotro.add(new MenuCaiDat("Trụ sở chính: 97 Man Thiện",R.drawable.addressicon));


    }
}