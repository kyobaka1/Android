package com.example.dev.the_food_house;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Food_Fragment extends Fragment {

    ListView lvMonAn;
    ArrayList<String> arrayFood;
    public View mRootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_food);
        lvMonAn = (ListView) container.findViewById(R.id.listviewMonAn);
        mRootView = inflater.inflate(R.layout.fragment_food, container, false);
        return mRootView;
    }

    public void InitList(){


        arrayFood = new ArrayList<>();

        arrayFood.add("Thịt kho hột vịt");
        arrayFood.add("Cơm chiên dương châu");
        arrayFood.add("Rau muống xào tỏi");
        arrayFood.add("Gà xào măng");
        arrayFood.add("Canh chua cá lóc");
        arrayFood.add("Thịt kho tiêu");
        arrayFood.add("Thịt luộc mắm tôm");
        arrayFood.add("Tàu hủ dồn thịt");
        arrayFood.add("Gà chiên nướng mắm");
        arrayFood.add("Cơm chiên csa mặn");
        arrayFood.add("Mì vịt tiềm");
        arrayFood.add("Mì xào dòn");
        arrayFood.add("Cá chiên");
        arrayFood.add("Cơm cháy chiên dòn");

        ArrayAdapter adapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, arrayFood);

        lvMonAn.setAdapter(adapter);
    }
}
