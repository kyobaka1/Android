package com.example.dev.the_food_house;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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

import java.util.ArrayList;

public class Bao_XemChiTiet extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private EditText edt;
    private EditText edt_dialog;
    private Button delete;
    private Button modify;
    private TextView tv3;
    private Button send;
    final String user = "Đoàn Ngọc Vương";
    ListView lvBinhLuan;
    int key;
    int temp;
    Bao_BinhLuan_Adapter adapter;
    private ImageView imgv;
    ArrayList<Bao_BinhLuan> arrayBinhLuan;
    ArrayList<String> arrayKey;
    Dialog suaBLDialog;
    private DatabaseReference mDatabase;
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


        mDatabase.child("BinhLuan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Bao_BinhLuan newBL = (Bao_BinhLuan) dataSnapshot.getValue(Bao_BinhLuan.class);
                String mkey = dataSnapshot.getKey();
                if(newBL.getBaiBaoId() == key){
                    arrayBinhLuan.add(newBL);
                    arrayKey.add(mkey);
                }
                adapter = new Bao_BinhLuan_Adapter(Bao_XemChiTiet.this,R.layout.dnv_bao_dongbinhluan,arrayBinhLuan);
                lvBinhLuan.setAdapter(adapter);
                tv3.setText(String.valueOf(arrayBinhLuan.size()) + " bình luận");
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

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
                    Bao_BinhLuan nBL = new Bao_BinhLuan(key, user, String.valueOf(binhLuan));
                    mDatabase.child("BinhLuan").push().setValue(nBL);
                    edt.setText(" ");
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 0 ; x<arrayBinhLuan.size(); x++){
                    Bao_BinhLuan bl = arrayBinhLuan.get(x);
                    if(bl.getTenUser().equals("Đoàn Ngọc Vương")){
                        mDatabase.child("BinhLuan").child(String.valueOf(arrayKey.get(x))).removeValue();
                        arrayBinhLuan.remove(x);
                        arrayKey.remove(x);
                        adapter = new Bao_BinhLuan_Adapter(Bao_XemChiTiet.this,R.layout.dnv_bao_dongbinhluan,arrayBinhLuan);
                        lvBinhLuan.setAdapter(adapter);
                        tv3.setText(String.valueOf(arrayBinhLuan.size()) + " bình luận");
                    }
                }
            }
        });
        lvBinhLuan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                temp = i;
                Bao_BinhLuan currentBL = arrayBinhLuan.get(i);
                suaBLDialog.show();
                edt_dialog.setText(currentBL.getBinhLuan());
                modify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Editable newbinhLuan = edt_dialog.getText();
                        Bao_BinhLuan currentBL = arrayBinhLuan.get(temp);
                        currentBL.setBinhLuan(String.valueOf(newbinhLuan));
                        mDatabase.child("BinhLuan").child(String.valueOf(arrayKey.get(temp))).setValue(currentBL);
                        arrayBinhLuan.get(temp).setBinhLuan(String.valueOf(newbinhLuan));
                        adapter = new Bao_BinhLuan_Adapter(Bao_XemChiTiet.this,R.layout.dnv_bao_dongbinhluan,arrayBinhLuan);
                        lvBinhLuan.setAdapter(adapter);
                        suaBLDialog.cancel();
                    }
                });
            }
        });

    }
    public void Dialog(){

    }
    private void AnhXa(){
        tv1 = (TextView) findViewById(R.id.txt_bao_noidung1);
        tv2 = (TextView) findViewById(R.id.txt_bao_noidung2);
        tv3 = (TextView) findViewById(R.id.txt_bao_bl_sobl);
        edt = (EditText) findViewById(R.id.edt_bao_bl);
        send = (Button) findViewById(R.id.button_bao_bl_send);
        imgv = (ImageView) findViewById(R.id.img_bao_hinh2);
        delete = (Button) findViewById(R.id.button_bao_bl_delete);
        lvBinhLuan = (ListView) findViewById(R.id.listview_binhluan);
        arrayBinhLuan = new ArrayList<>();
        arrayKey = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        suaBLDialog = new Dialog(this);
        suaBLDialog.setContentView(R.layout.dnv_bao_suabl_dialog);
        edt_dialog = (EditText) suaBLDialog.findViewById(R.id.edt_sua_bl);
        modify = (Button) suaBLDialog.findViewById(R.id.button_bao_bl_sua);
    }
}
