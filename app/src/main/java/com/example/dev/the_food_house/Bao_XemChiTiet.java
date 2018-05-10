package com.example.dev.the_food_house;

    import com.example.dev.the_food_house.model.user;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Bao_XemChiTiet extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private EditText edt;
    private ScrollView srv;
    private TextView tv3;
    private Button send;
    private user loginUser = new user(true);
    ListView lvBinhLuan;
    int key;
    int temp;
    Bao_BinhLuan_Adapter adapter;
    private ImageView imgv;
    ArrayList<Bao_BinhLuan> arrayBinhLuan;
    private DatabaseReference mDatabase;
    private int font;
    private int size;
    private int background;
    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_bao__xem_chi_tiet);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        AnhXa();
        Intent in = getIntent();
        Bundle b = in.getExtras();
        key = b.getInt("i");
        tv1.setText(b.getString("noidung1").trim());
        tv2.setText(b.getString("noidung2").trim());
        Picasso.get().load(b.getString("hinh2")).into(imgv);

        lvBinhLuan.setFocusable(false);
        adapter = new Bao_BinhLuan_Adapter(this,R.layout.dnv_bao_dongbinhluan,arrayBinhLuan);
        lvBinhLuan.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        mDatabase.child("BinhLuan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayBinhLuan.clear();
                for(DataSnapshot dn:dataSnapshot.getChildren()){
                    Bao_BinhLuan newBL = (Bao_BinhLuan) dn.getValue(Bao_BinhLuan.class);
                    newBL.setKey(dn.getKey());
                    if(newBL.getBaiBaoId() == key){
                        arrayBinhLuan.add(newBL);
                    }
                }
                tv3.setText(String.valueOf(arrayBinhLuan.size()) + " bình luận");
                String s = "";
                for(Bao_BinhLuan x: arrayBinhLuan){
                    s += x.getTenUser() +" "+ x.getBinhLuan();
                }
                adapter = new Bao_BinhLuan_Adapter(Bao_XemChiTiet.this,R.layout.dnv_bao_dongbinhluan,arrayBinhLuan);
                lvBinhLuan.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable binhLuan = edt.getText();
                if(String.valueOf(binhLuan).length() > 0) {
                    Bao_BinhLuan nBL = new Bao_BinhLuan(key, loginUser.getUserName(),loginUser.getAvatar(), String.valueOf(binhLuan));
                    mDatabase.child("BinhLuan").push().setValue(nBL);
                    edt.setText("");
                }
            }
        });


    }
    private void AnhXa(){
        tv1 = (TextView) findViewById(R.id.txt_bao_noidung1);
        tv2 = (TextView) findViewById(R.id.txt_bao_noidung2);
        tv3 = (TextView) findViewById(R.id.txt_bao_bl_sobl);
        edt = (EditText) findViewById(R.id.edt_bao_bl);
        send = (Button) findViewById(R.id.button_bao_bl_send);
        imgv = (ImageView) findViewById(R.id.img_bao_hinh2);
        lvBinhLuan = (ListView) findViewById(R.id.listview_binhluan);
        arrayBinhLuan = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        srv = (ScrollView) findViewById(R.id.scrollview_bao_xemchitiet);
        String s = readFromFile(this.getBaseContext());
        //Font:1-Background:1-Size:1
        font = Integer.parseInt(s.substring(s.indexOf("Font:")+5,s.indexOf("Font:")+6));
        background = Integer.parseInt(s.substring(s.indexOf("Background:")+11,s.indexOf("Background:")+12));
        size = Integer.parseInt(s.substring(s.indexOf("Size:")+5,s.indexOf("Size:")+6));
        setFontChu(font);
        setMauNen(background);
        setCoChu(size);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dnv_bao_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View menuItemCoChu = findViewById(R.id.button_setcochu);
        View menuItemFontChu = findViewById(R.id.button_setfontchu);
        View menuItemMauNen = findViewById(R.id.button_setphongnen);
        int id = item.getItemId();
        if (id == R.id.button_setcochu) {
            PopupMenu popupSetCoChu = new PopupMenu(this, menuItemCoChu);
            popupSetCoChu.getMenuInflater().inflate(R.menu.popup_menu_cochu, popupSetCoChu.getMenu());
            popupSetCoChu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.cochu_large:
                            setCoChu(1);
                            break;
                        case R.id.cochu_medium:
                            setCoChu(2);
                            break;
                        case R.id.cochu_small:
                            setCoChu(3);
                            break;
                    }
                    return false;
                }

            });
            popupSetCoChu.show();
        }
        if (id == R.id.button_setfontchu) {
            PopupMenu popupSetFontChu = new PopupMenu(this, menuItemFontChu);
            popupSetFontChu.getMenuInflater().inflate(R.menu.popup_menu_fontchu, popupSetFontChu.getMenu());
            popupSetFontChu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.font_timenew:
                            setFontChu(1);
                            break;
                        case R.id.font_arial:
                            setFontChu(2);
                            break;
                        case R.id.font_vn:
                            setFontChu(3);
                            break;
                    }
                    return false;
                }
            });
            popupSetFontChu.show();
        }
        if (id == R.id.button_setphongnen) {
            PopupMenu popupSetMauNen = new PopupMenu(this, menuItemMauNen);
            popupSetMauNen.getMenuInflater().inflate(R.menu.popupmenu_maunen, popupSetMauNen.getMenu());
            popupSetMauNen.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.bg_sang:
                            setMauNen(1);
                            break;
                        case R.id.bg_trungbinh:
                            setMauNen(2);
                            break;
                        case R.id.bg_toi:
                            setMauNen(3);
                            break;
                    }
                    return false;
                }
            });
            popupSetMauNen.show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void setCoChu(int item){
        switch (item){
            case 1: //Cỡ Lớn.
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
                tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
                tv3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
                size = 1;
                writeToFile("Font:"+font+"-Background:"+background+"-Size:"+1,getBaseContext());
                break;
            case 2: //Cỡ Lớn.
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
                tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
                tv3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
                size = 2;
                writeToFile("Font:"+font+"-Background:"+background+"-Size:"+2,getBaseContext());
                break;
            case 3: //Cỡ Lớn.
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                tv3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                size = 3;
                writeToFile("Font:"+font+"-Background:"+background+"-Size:"+3,getBaseContext());
                break;
        }
    }
    public void setFontChu(int item){
        Typeface vn = Typeface.createFromAsset(getAssets(),"fonts/Viet.ttf");
        Typeface sans = Typeface.createFromAsset(getAssets(),"fonts/BRLNSR.TTF");
        Typeface serif = Typeface.createFromAsset(getAssets(),"fonts/sansserif.ttf");
        switch (item){
            case 1: //VN
                tv1.setTypeface(vn);
                tv2.setTypeface(vn);
                tv3.setTypeface(vn);
                font=1;
                writeToFile("Font:"+1+"-Background:"+background+"-Size:"+size,getBaseContext());
                break;
            case 2: //Sans
                tv1.setTypeface(sans);
                tv2.setTypeface(sans);
                tv3.setTypeface(sans);
                font=2;
                writeToFile("Font:"+2+"-Background:"+background+"-Size:"+size,getBaseContext());
                break;
            case 3: //Serif
                tv1.setTypeface(serif);
                tv2.setTypeface(serif);
                tv3.setTypeface(serif);
                font=3;
                writeToFile("Font:"+3+"-Background:"+background+"-Size:"+size,getBaseContext());
                break;
        }
    }
    public void setMauNen(int item){

        switch (item){
            case 1: //Sáng
                tv1.setTextColor(Color.rgb(0,0,0));
                tv2.setTextColor(Color.rgb(0,0,0));
                tv3.setTextColor(Color.rgb(0,0,0));
                srv.setBackgroundColor(Color.rgb(255,255,255));
                background=1;
                writeToFile("Font:"+1+"-Background:"+1+"-Size:"+size,getBaseContext());
                break;
            case 2: //Trung bình
                tv1.setTextColor(Color.rgb(30,30,30));
                tv2.setTextColor(Color.rgb(30,30,30));
                tv3.setTextColor(Color.rgb(30,30,30));
                srv.setBackgroundColor(Color.rgb(247,247,247));
                background=2;
                writeToFile("Font:"+1+"-Background:"+2+"-Size:"+size,getBaseContext());
                break;
            case 3: //Tối
                tv1.setTextColor(Color.rgb(255,255,255));
                tv2.setTextColor(Color.rgb(255,255,255));
                tv3.setTextColor(Color.rgb(255,255,255));
                srv.setBackgroundColor(Color.rgb(80,80,80));
                background=3;
                writeToFile("Font:"+1+"-Background:"+3+"-Size:"+size,getBaseContext());
                break;
        }
    }
    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("dnv_config_bao.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    private String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("dnv_config_bao.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
