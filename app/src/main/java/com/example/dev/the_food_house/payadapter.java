package com.example.dev.the_food_house;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;

/**
 * Created by dev on 5/10/2018.
 */

public class payadapter extends BaseAdapter {

    List<pay> mlistNote;
    Context mContext;
    int mLayout;


    public payadapter(Context context, int layout, List<pay> listNote) {
        mlistNote = listNote;
        mLayout = layout;
        mContext = context;
    }

    @Override
    public int getCount() {
//        return 5;
        return mlistNote.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mLayout,null);

        ImageButton btnViewPay = (ImageButton)convertView.findViewById(R.id.btnpayview);
        btnViewPay.setImageResource(mlistNote.get(position).img);

        btnViewPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"choose "+position, Toast.LENGTH_SHORT).show();

                mlistNote.get(position).selected = false;
                Intent intent = new Intent(mContext, payviewActivity.class);
//                intent.putExtra("img", mlistNote.get(position).img);
                intent.putExtra("img",mlistNote.get(position).img.toString());

//                intent.putExtra("name", mlistNote.get(position).name);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
