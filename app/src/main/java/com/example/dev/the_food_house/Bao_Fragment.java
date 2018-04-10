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
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
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
                // i : Trả về vị trí người dùng đang click trên Listview.
                Intent newintent = new Intent(getActivity(),Bao_XemChiTiet.class);
                Bundle bundle = new Bundle();
                Bao mBao = arrayBao.get(i);
                bundle.putString("noidung1",mBao.getDoanvan1());
                bundle.putString("hinh2",mBao.getHinh2());
                bundle.putString("noidung2",mBao.getDoanvan2());
                newintent.putExtras(bundle);
                startActivity(newintent);
        }
        });
        return mRootView;
    }
    private void AnhXa() {
        lvBao = (ListView) mRootView.findViewById(R.id.listview_bao);
        arrayBao = new ArrayList<>();
    }
}

