package com.example.dev.the_food_house;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by NgocTri on 10/22/2016.
 */

public class GridViewAdapter extends ArrayAdapter<Product> {
    public Context c;
    public GridViewAdapter(Context context, int resource, List<Product> objects) {

        super(context, resource, objects);
        this.c= context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(null == v) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grid_item, null);
        }
        final Product product = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        TextView txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) v.findViewById(R.id.txtDescription);
        TextView txtPrice=(TextView)v.findViewById(R.id.txtPrice);
        final TextView txtnumber=(TextView)v.findViewById(R.id.number);

        Button btplus=(Button)v.findViewById(R.id.plus);
        Button btminus=(Button)v.findViewById(R.id.minus);
        txtPrice.setText(""+product.getPrice());
        img.setImageResource(product.getImageId());
        txtTitle.setText(product.getTitle());
        txtDescription.setText(product.getDescription());
        txtnumber.setText(""+product.getNumber());

        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(product.getNumber()>0)
                {
                    int i=product.getNumber()-1;
                    product.setNumber(i);
                    txtnumber.setText(""+i);
                    Toast.makeText(getContext(),"minus"+i, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=product.getNumber()+1;
                product.setNumber(i);
                txtnumber.setText(""+i);
                Toast.makeText(getContext(),"plus"+i, Toast.LENGTH_SHORT).show();
            }
        });

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getContext(),"image",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(c,SeeOderFoodActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(intent);
                return false;
            }
        });


        return v;
    }
}
