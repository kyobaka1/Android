package com.example.dev.the_food_house;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
        private TextView txtShare;
        private CheckBox love;
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
            holder.txtShare = (TextView) view.findViewById(R.id.txt_bao_share);
            holder.txtThoiGian = (TextView) view.findViewById(R.id.txt_time_dong_bao);
            holder.imgHinh = (ImageView) view.findViewById(R.id.img_dong_bao);
            holder.share = (ImageButton) view.findViewById(R.id.button_bao_share);
            holder.love = (CheckBox) view.findViewById(R.id.button_bao_love);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Bao bao = BaoList.get(i);
        holder.txtTen.setText(bao.getTen());
        holder.txtThoiGian.setText(bao.getThoidiem());
        holder.txtShare.setText(String.valueOf(bao.getSoshare()));
        holder.love.setText(String.valueOf(bao.getSolove()));
        Picasso.get().load(bao.getHinh()).into(holder.imgHinh);
        if(bao.getLove()){
            holder.love.setChecked(true);
        }
        else holder.love.setChecked(false);

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaoList.get(i).setSoshare( BaoList.get(i).getSoshare()+1);
                mDatabase.child("Bao").child(String.valueOf(i)).child("soshare").setValue(BaoList.get(i).getSoshare());
            }
        });
        holder.love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.love.isChecked()){
                    BaoList.get(i).setSolove( BaoList.get(i).getSolove()+1);
                    mDatabase.child("Bao").child(""+BaoList.get(i).getIDBao()).child("solove").setValue(BaoList.get(i).getSolove());
                    BaoList.get(i).setLove(true);
                    mDatabase.child("BaoLove").child("0").child(""+BaoList.get(i).getIDBao()).setValue(true);
                }
                else{
                    BaoList.get(i).setSolove( BaoList.get(i).getSolove()-1);
                    mDatabase.child("Bao").child("0").child("solove").setValue(BaoList.get(i).getSolove());
                    BaoList.get(i).setLove(false);
                    mDatabase.child("BaoLove").child("0").child(""+BaoList.get(i).getIDBao()).setValue(false);
                }
            }
        });
        return view;
    }
}
