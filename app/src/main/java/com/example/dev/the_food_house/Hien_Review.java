package com.example.dev.the_food_house;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Admin on 3/9/2018.
 */

public class Hien_Review extends AppCompatActivity {
    ListView list;
    String[] web = {
            "Món ăn rất ngon",
            "Món ăn chưa ngon",
            "Ăn được",
            "Chưa ăn",
            "Chưa ngon",
            "Mùi vị được",
            "Cần chế biến lại"
    } ;
    Integer[] imageId = {
            R.drawable.monan,
            R.drawable.hinhmot,
            R.drawable.hinhhai,
            R.drawable.hinhba,
            R.drawable.hinhbon,
            R.drawable.hinhnam,
            R.drawable.hinhsau

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hien_review);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#150303")));
        Hien_CustomList adapter = new
                Hien_CustomList(Hien_Review.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Hien_Review.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
