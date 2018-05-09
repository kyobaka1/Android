package com.example.dev.the_food_house;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Admin on 4/2/2018.
 */
public class Bao_Fragment extends Fragment {
    private View mRootView;
    private DatabaseReference mDatabase;
    ListView lvBao;
    ArrayList<Bao> arrayBao;
    BaoAdapter adapter;


    ImageView hotview;
    TextView tieude;
    TextView thoidiem;
    TextView solove;
    TextView soshare;
    TextView gioithieu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.dnv_bao, container, false);
        AnhXa();
        adapter = new BaoAdapter(getActivity(),R.layout.dnv_dong_bao, arrayBao);
        lvBao.setAdapter(adapter);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Bao").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Bao newBao =(Bao) dataSnapshot.getValue(Bao.class);
                arrayBao.add(newBao);
                adapter = new BaoAdapter(getActivity(),R.layout.dnv_dong_bao, arrayBao);
                lvBao.setAdapter(adapter);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Bao newBao =(Bao) dataSnapshot.getValue(Bao.class);
                int key = Integer.parseInt(dataSnapshot.getKey());
                arrayBao.get(key).setSolove(newBao.getSolove());
                adapter = new BaoAdapter(getActivity(),R.layout.dnv_dong_bao, arrayBao);
                lvBao.setAdapter(adapter);
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
        lvBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent newintent = new Intent(getActivity(),Bao_XemChiTiet.class);
                Bundle bundle = new Bundle();
                Bao mBao = arrayBao.get(i);
                bundle.putString("noidung1",mBao.getDoanvan1());
                bundle.putString("hinh2",mBao.getHinh2());
                bundle.putString("noidung2",mBao.getDoanvan2());
                bundle.putInt("i",i);
                newintent.putExtras(bundle);
                startActivity(newintent);
            }
        });

        //Tin Hot.
        mDatabase.child("TinHot").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bao newBao =(Bao) dataSnapshot.getValue(Bao.class);
                Picasso.get().load(newBao.getHinh()).into(hotview);
                tieude.setText(newBao.getTen());
                thoidiem.setText(newBao.getThoidiem());
                solove.setText(String.valueOf(newBao.getSolove()));
                soshare.setText(String.valueOf(newBao.getSoshare()));
                gioithieu.setText(newBao.getGioithieu());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return mRootView;
    }
    public void ex(int i){

    }
    private void AnhXa() {
        lvBao = (ListView) mRootView.findViewById(R.id.listview_bao);
        arrayBao = new ArrayList<>();
        hotview = (ImageView) mRootView.findViewById(R.id.img_baohot_hinh1);
        tieude = (TextView) mRootView.findViewById(R.id.txt_baohot_tieude);
        thoidiem = (TextView) mRootView.findViewById(R.id.txt_time_dong_hotbao);
        solove = (TextView) mRootView.findViewById(R.id.txt_hotbao_love);
        soshare = (TextView) mRootView.findViewById(R.id.txt_hotbao_share);
        gioithieu = (TextView) mRootView.findViewById(R.id.txt_baohot_gioithieu);

    }
}

