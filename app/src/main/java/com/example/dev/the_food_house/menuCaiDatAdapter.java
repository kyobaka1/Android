package com.example.dev.the_food_house;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 3/9/2018.
 */

public class menuCaiDatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MenuCaiDat> menuCaiDatList;

    public menuCaiDatAdapter(Context context, int layout, ArrayList<MenuCaiDat> menuCaiDatList) {
        this.context = context;
        this.layout = layout;
        this.menuCaiDatList = menuCaiDatList;
    }

    @Override
    public int getCount() {
        return menuCaiDatList.size();
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
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if( view == null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.text_menu_caidat);
            holder.imgHinh = (ImageView) view.findViewById(R.id.img_menu_caidat);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        MenuCaiDat menuCaiDat = menuCaiDatList.get(i);

        holder.txtTen.setText(menuCaiDat.getTen());
        holder.imgHinh.setImageResource(menuCaiDat.getHinh());
        return view;
    }
}
