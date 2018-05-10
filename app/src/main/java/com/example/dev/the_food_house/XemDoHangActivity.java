package com.example.dev.the_food_house;

import android.content.Intent;
import android.content.Loader;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class XemDoHangActivity extends AppCompatActivity {

    private List<Product> productList;
    private ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_do_hang);


        ListView listView = (ListView) findViewById(R.id.mylistview);

        productList = new ArrayList<>();

        listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);

        listView.setAdapter(listViewAdapter);

        productList.clear();

        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();
        myFirebaseRef.child("history").child("thanh").removeValue();

        myFirebaseRef.child("drink").addChildEventListener(new
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

                                                                               DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                                                                               myFirebaseRef.child("history").child("thanh").push().setValue(dataSnapshot.getValue());


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



        myFirebaseRef.child("food").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        if (dataSnapshot.child("number").getValue().toString().equalsIgnoreCase("0")) {
                        } else {
                            productList.add(new Product(dataSnapshot.child("image").getValue().toString(), dataSnapshot.child("name").getValue().toString(), dataSnapshot.child("des").getValue().toString(), Integer.parseInt(dataSnapshot.child("price").getValue().toString()), Integer.parseInt(dataSnapshot.child("number").getValue().toString())));
                            listViewAdapter.notifyDataSetChanged();

                            DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                            myFirebaseRef.child("history").child("thanh").push().setValue(dataSnapshot.getValue());

                        }
                        Log.e("firebase", "" + productList.size());

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

        Button btnthanhtoan=(Button)findViewById(R.id.btnthanhtoan);
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                myFirebaseRef.child("drink").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                        //myFirebaseRef.
                        myFirebaseRef.child("drink").child(dataSnapshot.getKey().toString()).child("number").setValue("0");

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

                myFirebaseRef.child("food").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();
                        myFirebaseRef.child("food").child(dataSnapshot.getKey().toString()).child("number").setValue("0");



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
                productList.clear();
                listViewAdapter.notifyDataSetChanged();
                Oder_Food_Activity of=new Oder_Food_Activity();

                of.tvtotal.setVisibility(View.GONE);
                of.tvnumber.setVisibility(View.GONE);

                of.total=0;
                of.number=0;

                TextView tvprice=(TextView)findViewById(R.id.tvprice);
                tvprice.setVisibility(View.GONE);

            }
        });

        Oder_Food_Activity of=new Oder_Food_Activity();
        TextView tvprice=(TextView)findViewById(R.id.tvprice);
        if(of.total==0)
        {
            tvprice.setVisibility(View.GONE);
        }
        else {
            tvprice.setText(of.total+"đ");
        }

        Log.d("thanh","thanh khong nghẻ:"+of.total+"-"+of.number);


    }

    @Override
    public void onResume() {
        super.onResume();

        // Display custom title
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle(" Xem Giỏ hàng ");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f23057")));

        // Display the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    // Back arrow click event to go to the parent Activity
    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(this, Oder_Food_Activity.class));
        onBackPressed();

        return true;
    }


}
