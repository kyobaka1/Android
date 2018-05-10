package com.example.dev.the_food_house;

/**
 * Created by Administrator on 3/25/2018.
 */


import android.app.Activity;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final ArrayList<String> web;

    public CustomList(Activity context,
                      ArrayList<String> web) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;


    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        txtTitle.setText(web.get(position));

        imageView.setImageResource(R.drawable.user);
        return rowView;
    }
}