package com.example.dev.the_food_house;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class payActivity extends AppCompatActivity {

    ArrayList<pay> listPay = new ArrayList<pay>();
    ListView lvPay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        lvPay = (ListView)findViewById(R.id.lvpay);

        pay temp = new pay("acb",R.drawable.acb_logo);
        listPay.add(temp);
        temp = new pay("agr",R.drawable.agr_logo);
        listPay.add(temp);
        temp = new pay("vtb",R.drawable.vtb_logo);
        listPay.add(temp);
        temp = new pay("vcb",R.drawable.vcb_logo);
        listPay.add(temp);


        final payadapter adapter = new payadapter(payActivity.this,R.layout.activity_rowpay,listPay);
        lvPay.setAdapter(adapter);
    }
}
