package com.example.dev.the_food_house;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Admin on 4/20/2018.
 */

public class Bao_BinhLuan_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Bao_BinhLuan> binhLuanList;
    public Bao_BinhLuan_Adapter(Context context, int layout, ArrayList<Bao_BinhLuan> BinhLuanList) {
        this.context = context;
        this.layout = layout;
        this.binhLuanList = BinhLuanList;
    }
    @Override
    public int getCount() {
        return binhLuanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        private TextView username;
        private TextView binhluan;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if( view == null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.username = (TextView) view.findViewById(R.id.txt_bao_bl_username);
            holder.binhluan = (TextView) view.findViewById(R.id.txt_bao_bl_binhluan);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        Bao_BinhLuan binhLuan = binhLuanList.get(i);
        holder.username.setText(binhLuan.getTenUser());
        holder.binhluan.setText(binhLuan.getBinhLuan());
        return view;
    }
}
