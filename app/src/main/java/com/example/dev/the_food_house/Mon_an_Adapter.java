package com.example.dev.the_food_house;

import android.app.Activity;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Admin on 5/10/2018.
 */

public class Mon_an_Adapter extends BaseExpandableListAdapter {
    Activity context;
    List<Mon_an> mon_ans;
    SQLite sqLite;
    public Mon_an_Adapter(Activity context, List<Mon_an> mon_ans, SQLite sqLite) {
        this.context = context;
        this.mon_ans = mon_ans;
        this.sqLite=sqLite;
    }


    @Override
    public int getGroupCount() {
        return mon_ans.size();
    }

    @Override
    public int getChildrenCount(int pos) {
        return 1;
    }

    @Override
    public Object getGroup(int pos) {
        return mon_ans.get(pos);
    }

    @Override
    public Object getChild(int pos, int child) {
        return mon_ans.get(pos).getHuongDanNauAn();
    }

    @Override
    public long getGroupId(int pos) {// lay note thu may
        return pos;
    }

    @Override
    public long getChildId(int pos, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int pos, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.item_cha,null);
        TextView textView=(TextView)view.findViewById(R.id.textTenmonan);
        Mon_an mon_an=mon_ans.get(pos);
        textView.setText(mon_an.getTenMonAn());
        return view;
    }

    @Override
    public View getChildView(final int pos, int child, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.item_con,null);
        TextView textView=(TextView)view.findViewById(R.id.textHDMA);
        final Mon_an mon_an=mon_ans.get(pos);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(mon_an.getHuongDanNauAn());
        Button img=(Button)view.findViewById(R.id.buttonMA);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent(mon_an);
            }
        });
        return view;
    }
    private void addEvent(Mon_an pos) {
        sqLite.Delete(pos.getIdMonAn());
        mon_ans.clear();
        mon_ans.addAll(sqLite.getNote());
        Toast.makeText(context,"Xóa thành công",Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}