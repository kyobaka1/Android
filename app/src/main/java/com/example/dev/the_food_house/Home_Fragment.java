package com.example.dev.the_food_house;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by dev on 3/4/2018.
 */


public class Home_Fragment extends Fragment {
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.hson_fragment_home,container,false);


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
                it.putExtra("YourValueKey",""+1);
                startActivity(it);
            }
        });

        Button  btndt1=(Button)mRootView.findViewById(R.id.btndathang1);
        btndt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey",""+1);
                startActivity(it);
            }
        });

        return mRootView;
    }
}
