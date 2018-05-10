package com.example.dev.the_food_house;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
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

        txtPrice.setText(""+product.getPrice()+"đ");
        byte[] decodedString = Base64.decode(product.getImageId(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        Log.e("thanh","thanh :"+decodedString);

        img.setImageBitmap(decodedByte);
        txtTitle.setText(product.getTitle());
        txtDescription.setText("  "+product.getDescription());
        txtnumber.setText(""+product.getNumber());

        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(product.getNumber()>0)
                {
                    int i=product.getNumber()-1;
                    product.setNumber(i);
                    txtnumber.setText(""+i);
                    Toast.makeText(getContext(),"minus"+i+"p:"+position, Toast.LENGTH_SHORT).show();
                    Oder_Food_Activity of=new Oder_Food_Activity();
                    of.number= of.number-1;
                    of.total=of.total-product.getPrice();
                    of.tvtotal.setText(""+of.total +" đ");
                    of.tvnumber.setText(""+of.number);
                    of.fl.setVisibility(View.VISIBLE);
                    of.tvtotal.setVisibility(View.VISIBLE);
                    of.FirebaseNumber(position,i);

                }
            }
        });
        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=product.getNumber()+1;
                product.setNumber(i);
                txtnumber.setText(""+i);
                Toast.makeText(getContext(),"plus"+i+"p:"+position, Toast.LENGTH_SHORT).show();
                Oder_Food_Activity of=new Oder_Food_Activity();
                of.number= of.number+1;
                of.total=of.total+product.getPrice();
                of.tvtotal.setText(""+of.total +" đ");
                of.tvnumber.setText(""+of.number);
                of.fl.setVisibility(View.VISIBLE);
                of.tvtotal.setVisibility(View.VISIBLE);
                of.FirebaseNumber(position,i);


            }
        });
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getContext(),"image",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(c,SeeOderFoodActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(intent);
                Oder_Food_Activity of=new Oder_Food_Activity();
                of.FirebaseDes(position);

                SeeOderFoodActivity sf=new SeeOderFoodActivity();
                sf.position=position;


                return false;
            }
        });

        return v;
    }
}
