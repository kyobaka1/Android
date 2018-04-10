package com.example.dev.the_food_house;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Admin on 4/5/2018.
 */

public class BaoAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Bao> BaoList;

    public BaoAdapter(Context context, int layout, ArrayList<Bao> BaoList) {
        this.context = context;
        this.layout = layout;
        this.BaoList = BaoList;
    }
    @Override
    public int getCount() {
        return BaoList.size();
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
        private TextView txtTen;
        private ImageView imgHinh;
        private TextView txtThoiGian;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if( view == null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.txt_dong_bao);
            holder.txtThoiGian = (TextView) view.findViewById(R.id.txt_time_dong_bao);
            holder.imgHinh = (ImageView) view.findViewById(R.id.img_dong_bao);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Bao bao = BaoList.get(i);

        holder.txtTen.setText(bao.getTen());
        holder.txtThoiGian.setText(bao.getThoidiem());
        Picasso.get().load(bao.getHinh()).into(holder.imgHinh);
        return view;
    }
}
