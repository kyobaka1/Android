package com.example.dev.the_food_house;
import com.example.dev.the_food_house.model.user;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    private EditText suaBL;
    Dialog suaBLDialog;
    private Button modify;
    private user loginUser = new user(true);
    private ArrayList<Bao_BinhLuan> binhLuanList;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
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
        private ImageView avarta;
        private ImageButton delete;
        private ImageButton modify;
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
            holder.avarta = (ImageView) view.findViewById(R.id.avarta_binhluan);
            holder.delete = (ImageButton) view.findViewById(R.id.delete_binhluan);
            holder.modify = (ImageButton) view.findViewById(R.id.modify_binhluan);
            suaBLDialog = new Dialog(context);
            suaBLDialog.setContentView(R.layout.dnv_bao_suabl_dialog);
            modify = (Button) suaBLDialog.findViewById(R.id.button_bao_bl_sua);
            suaBL = (EditText) suaBLDialog.findViewById(R.id.edt_sua_bl);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        final Bao_BinhLuan binhLuan = binhLuanList.get(i);
        holder.username.setText(binhLuan.getTenUser());
        holder.binhluan.setText(binhLuan.getBinhLuan());
        Picasso.get().load(binhLuan.getAvarta()).into(holder.avarta);
        if(loginUser.getUserName().equals(binhLuan.getTenUser())){
            holder.delete.setVisibility(View.VISIBLE);
            holder.modify.setVisibility(View.VISIBLE);
        }
        else{
            holder.delete.setVisibility(View.INVISIBLE);
            holder.modify.setVisibility(View.INVISIBLE);
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginUser.getUserName().equals(binhLuan.getTenUser())) {
                    mDatabase.child("BinhLuan").child("" + binhLuan.getKey()).removeValue();
                }
            }
        });
        holder.modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Window window = suaBLDialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.BOTTOM;
                window.setAttributes(wlp);
                suaBLDialog.setTitle("Sửa bình luận");
                suaBLDialog.show();
                suaBL.setText(binhLuan.getBinhLuan());
            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BL = suaBL.getText().toString();
                mDatabase.child("BinhLuan").child(""+binhLuan.getKey()).child("binhLuan").setValue(BL);
                suaBLDialog.cancel();
            }
        });
        return view;
    }
}
