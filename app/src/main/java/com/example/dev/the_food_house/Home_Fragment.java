//HomeFragment
package com.example.dev.the_food_house;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



/**
 * Created by dev on 3/4/2018.
 */


public class Home_Fragment extends Fragment {
    private View mRootView;
    Button  btndt;
    Button  btndt1;
    Button  btndt3;
    Button  btndt4;
    Button  btndt2;
    Button  btndt5;
    Button  btndt6;
    Button  btndt7;
    Button  btndt8;
    Button  btndt9;
    ImageView im;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        mRootView = inflater.inflate(R.layout.hson_fragment_home,container,false);


        btndt=(Button)mRootView.findViewById(R.id.buttondathang);


        Button  btndt=(Button)mRootView.findViewById(R.id.buttondathang);
        Button  review=(Button)mRootView.findViewById(R.id.btn2);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),Hien_Review.class);
                startActivity(it);
            }
        });

        btndt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);


            }
        });

        btndt1=(Button)mRootView.findViewById(R.id.btndathang1);

        btndt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);


            }
        });

        btndt2=(Button)mRootView.findViewById(R.id.btndathang2);
        btndt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
            }
        });

        btndt3=(Button)mRootView.findViewById(R.id.btndathang3);
        btndt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
            }
        });

        btndt4=(Button)mRootView.findViewById(R.id.btndathang4);
        btndt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
            }
        });


        btndt5=(Button)mRootView.findViewById(R.id.btn2); //button xem them
        btndt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);


            }
        });


        btndt6=(Button)mRootView.findViewById(R.id.btn3);
        btndt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey2",""+1);
                startActivity(it);


            }
        });

        btndt7=(Button)mRootView.findViewById(R.id.btn4);
        btndt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey3",""+1);
                startActivity(it);


            }
        });

        btndt8=(Button)mRootView.findViewById(R.id.btn5);
        btndt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey4",""+1);
                startActivity(it);


            }
        });

        btndt9=(Button)mRootView.findViewById(R.id.history);

        btndt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),HistoryActivity.class);
                it.putExtra("YourValueKey5",""+1);
                startActivity(it);


            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();


                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
                return false;
            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton1);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();


                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey2",""+1);
                startActivity(it);
                return false;
            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton2);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey3",""+1);
                startActivity(it);
                return false;
            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton3);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();


                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey4",""+1);
                startActivity(it);
                return false;
            }
        });







        return mRootView;
    }
}
