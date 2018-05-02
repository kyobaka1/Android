package com.example.dev.the_food_house;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Admin on 4/5/2018.
 */

public class BaoAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Bao> BaoList;
    private DatabaseReference mDatabase;

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
        private TextView txtLove;
        private TextView txtShare;
        private ImageButton love;
        private ImageButton share;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if( view == null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder = new ViewHolder();
            holder.txtTen = (TextView) view.findViewById(R.id.txt_dong_bao);
            holder.txtLove = (TextView) view.findViewById(R.id.txt_bao_love);
            holder.txtShare = (TextView) view.findViewById(R.id.txt_bao_share);
            holder.txtThoiGian = (TextView) view.findViewById(R.id.txt_time_dong_bao);
            holder.imgHinh = (ImageView) view.findViewById(R.id.img_dong_bao);
            holder.love = (ImageButton) view.findViewById(R.id.button_bao_love);
            holder.share = (ImageButton) view.findViewById(R.id.button_bao_share);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Bao bao = BaoList.get(i);
        holder.txtTen.setText(bao.getTen());
        holder.txtThoiGian.setText(bao.getThoidiem());
        holder.txtLove.setText(String.valueOf(bao.getSolove()));
        holder.txtShare.setText(String.valueOf(bao.getSoshare()));
        Picasso.get().load(bao.getHinh()).into(holder.imgHinh);

        holder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaoList.get(i).setSolove( BaoList.get(i).getSolove()+1);
                mDatabase.child("Bao").child(String.valueOf(i)).child("solove").setValue(BaoList.get(i).getSolove());
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaoList.get(i).setSoshare( BaoList.get(i).getSoshare()+1);
                mDatabase.child("Bao").child(String.valueOf(i)).child("soshare").setValue(BaoList.get(i).getSoshare());
            }
        });


        return view;
    }
}
