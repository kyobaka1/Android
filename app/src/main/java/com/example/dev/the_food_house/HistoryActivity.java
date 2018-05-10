package com.example.dev.the_food_house;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hoans_000 on 5/1/2018.
 */

public class HistoryActivity extends AppCompatActivity {

    private List<Product> productList;
    private ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ListView listView = (ListView) findViewById(R.id.mylistview);

        productList = new ArrayList<>();

        listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);

        listView.setAdapter(listViewAdapter);

        productList.clear();

        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

        myFirebaseRef.child("history").child("thanh").addChildEventListener(new
          ChildEventListener() {
                                                                       @Override
                                                                       public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                                                                           if(dataSnapshot.child("number").getValue().toString().equalsIgnoreCase("0"))
                                                                           {

                                                                           }
                                                                           else
                                                                           {
                                                                               productList.add(new Product(dataSnapshot.child("image").getValue().toString(), dataSnapshot.child("name").getValue().toString(),dataSnapshot.child("des").getValue().toString(),Integer.parseInt(dataSnapshot.child("price").getValue().toString()),Integer.parseInt(dataSnapshot.child("number").getValue().toString())));
                                                                               listViewAdapter.notifyDataSetChanged();

                                                                               //Log.e("log",""+dataSnapshot);

                                                                           }
                                                                           Log.e("firebase",""+productList.size() );
                                                                       }

                                                                       @Override
                                                                       public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                                                       }

                                                                       @Override
                                                                       public void onChildRemoved(DataSnapshot dataSnapshot) {

                                                                       }

                                                                       @Override
                                                                       public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                                                       }

                                                                       @Override
                                                                       public void onCancelled(DatabaseError databaseError) {

                                                                       }
                                                                   });



    }
}
