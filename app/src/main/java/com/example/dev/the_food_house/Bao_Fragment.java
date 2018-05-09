package com.example.dev.the_food_house;

import com.example.dev.the_food_house.model.user;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
/**
 * Created by Admin on 4/2/2018.
 */
public class Bao_Fragment extends Fragment {
    private View mRootView;
    private DatabaseReference mDatabase;
    private user loginUser = new user(true);
    boolean flag = false;
    Bao tinHot;
    ListView lvBao;
    ArrayList<Bao> arrayBao;
    ArrayList<Boolean> ArthichHog;
    BaoAdapter adapter;
    ImageView hotview;
    TextView tieude;
    LinearLayout tinhot;
    TextView thoidiem;
    CheckBox solove;
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
        DocBao();

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
        mDatabase.child("BaoLove").child(""+loginUser.getID()).child("999").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean thichHot = dataSnapshot.getValue(Boolean.class);
                if(thichHot){
                    solove.setChecked(true);
                }
                else{
                    solove.setChecked(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //Tin Hot.
        mDatabase.child("TinHot").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tinHot =(Bao) dataSnapshot.getValue(Bao.class);
                Picasso.get().load(tinHot.getHinh()).into(hotview);
                tieude.setText(tinHot.getTen());
                thoidiem.setText(tinHot.getThoidiem());
                soshare.setText(String.valueOf(tinHot.getSoshare()));
                solove.setText(String.valueOf(tinHot.getSolove()));
                gioithieu.setText(tinHot.getGioithieu());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        solove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(solove.isChecked()){
                    try {
                        mDatabase.child("BaoLove").child("" + loginUser.getID()).child("999").setValue(true);
                        tinHot.setSolove(tinHot.getSolove() + 1);
                        mDatabase.child("TinHot").child("solove").setValue(tinHot.getSolove());
                    }catch (Exception e){

                    }
                }
                else{
                    try {
                        mDatabase.child("BaoLove").child(""+loginUser.getID()).child("999").setValue(true);
                        tinHot.setSolove(tinHot.getSolove()-1);
                        mDatabase.child("TinHot").child("solove").setValue(tinHot.getSolove());
                    }catch (Exception e){
                    }
                }
            }
        });
        tieude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent = new Intent(getActivity(),Bao_XemChiTiet.class);
                Bundle bundle = new Bundle();
                bundle.putString("noidung1",tinHot.getDoanvan1());
                bundle.putString("hinh2",tinHot.getHinh2());
                bundle.putString("noidung2",tinHot.getDoanvan2());
                bundle.putInt("i",999);
                newintent.putExtras(bundle);
                startActivity(newintent);
            }
        });
        return mRootView;
    }
    private void AnhXa() {
        lvBao = (ListView) mRootView.findViewById(R.id.listview_bao);
        arrayBao = new ArrayList<>();
        ArthichHog = new ArrayList<>();
        hotview = (ImageView) mRootView.findViewById(R.id.img_baohot_hinh1);
        tieude = (TextView) mRootView.findViewById(R.id.txt_baohot_tieude);
        thoidiem = (TextView) mRootView.findViewById(R.id.txt_time_dong_hotbao);
        solove = (CheckBox) mRootView.findViewById(R.id.button_hot_bao_love);
        soshare = (TextView) mRootView.findViewById(R.id.txt_hotbao_share);
        gioithieu = (TextView) mRootView.findViewById(R.id.txt_baohot_gioithieu);
        tinhot = (LinearLayout) mRootView.findViewById(R.id.tinhot);
    }
    private void DocBao(){
        mDatabase.child("Bao").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayBao.clear();
                ArthichHog.clear();
                for (DataSnapshot dn : dataSnapshot.getChildren()) {
                    Bao newBao = (Bao) dn.getValue(Bao.class);
                    newBao.setLove(false);
                    arrayBao.add(newBao);
                    mDatabase.child("BaoLove").child(""+loginUser.getID()).child(""+newBao.getIDBao()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            boolean thichHog = dataSnapshot.getValue(Boolean.class);
                            for(Bao x: arrayBao){
                                if(x.getIDBao() == Integer.parseInt(dataSnapshot.getKey())){
                                    x.setLove(thichHog);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

