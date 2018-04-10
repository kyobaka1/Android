package com.example.dev.the_food_house;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Admin on 4/2/2018.
 */

public class Bao_Activity extends AppCompatActivity {
    private TextView txt1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnv_bao);
    }
}
