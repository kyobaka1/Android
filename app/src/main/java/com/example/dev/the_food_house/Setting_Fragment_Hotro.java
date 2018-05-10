package com.example.dev.the_food_house;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Admin on 3/9/2018.
 */

public class Setting_Fragment_Hotro extends AppCompatActivity {
    ListView lvMenuHoTro;
    ArrayList<MenuCaiDat> arrayMenuHotro;
    menuCaiDatAdapter Hotroadapter;
    final int REQUEST_CODE = 123;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_hotro);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        final Uri URL = Uri.parse("https://www.facebook.com/viettastevietnamese/");
        AnhXa();
        Hotroadapter = new menuCaiDatAdapter(this,R.layout.dnv_dong_menu_caidat, arrayMenuHotro);
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
                        Intent iz = new Intent(Intent.ACTION_SEND);
                        iz.setType("message/rfc822");
                        iz.putExtra(Intent.EXTRA_EMAIL  , new String[]{"support@vietfeeder.com"});
                        try {
                            startActivity(Intent.createChooser(iz, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getBaseContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3: // Quản lí tài khoản.
                        Toast.makeText(getBaseContext(), "Mời bạn đến trụ sở chính: 97 Man Thiện,Quận 9, Hồ Chí Minh để được hỗ trợ trực tiếp", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    private void AnhXa(){
        lvMenuHoTro = (ListView) findViewById(R.id.listview_hotro);
        arrayMenuHotro = new ArrayList<>();
        arrayMenuHotro.add(new MenuCaiDat("/viettastevietnamese",R.drawable.facebook_icon));
        arrayMenuHotro.add(new MenuCaiDat("0988 700 162",R.drawable.phone_icon));
        arrayMenuHotro.add(new MenuCaiDat("support@vietfeeder.com",R.drawable.email_icon));
        arrayMenuHotro.add(new MenuCaiDat("Trụ sở chính: 97 Man Thiện",R.drawable.location_icon));
    }
}