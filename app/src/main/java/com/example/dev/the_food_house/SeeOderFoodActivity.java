package com.example.dev.the_food_house;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SeeOderFoodActivity extends AppCompatActivity  {

    ListView list;
    ArrayList<String>web;

    static  String txname="";
    static  String txdescription="";
    static  int  position;
    int i=0;
    static String dem="";



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_see_oder_food);

        web=new ArrayList<>();

        final CustomList adapter = new CustomList(this,web);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        /// start scroll top
        list.setFocusable(false);

        list.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        TextView tv=(TextView)findViewById(R.id.description);

        tv.setText(txdescription);

        ScrollView sv=(ScrollView)findViewById(R.id.scrollview);
        sv.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });




        ScrollView svm=(ScrollView)findViewById(R.id.scrollviewmain);
        svm.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {


                //v.getParent().requestDisallowInterceptTouchEvent(true);
                //Toast.makeText(getApplication(),"cham",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        TextView txtname=(TextView)findViewById(R.id.txtName);
        txtname.setText(txname);



        Button btEdit=(Button) findViewById(R.id.btnEdit);

        final DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();


        Oder_Food_Activity of=new Oder_Food_Activity();
        final TextView tvms=(TextView)findViewById(R.id.numberms);
        final TextView tvlk=(TextView)findViewById(R.id.numberlk);

        //myFirebaseRef.child(of.namefirebase).child(of.namefirebase+(position+1)).child("countslk").setValue("0");


        myFirebaseRef.child(of.namefirebase).child(of.namefirebase+(position+1)).child("comment").addChildEventListener(new
        ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

             web.add(""+dataSnapshot.getValue().toString());
             Log.e("comment","com :"+web.size());
             adapter.notifyDataSetChanged();
             tvms.setText(""+web.size());

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


                //myFirebaseRef.child(of.namefirebase).child(of.namefirebase+(position+1)).child("countslk").setValue("0");

                myFirebaseRef.child(of.namefirebase).child(of.namefirebase + (position + 1)).child("countslk").addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                tvlk.setText("" + dataSnapshot.getValue().toString());
                                dem = dataSnapshot.getValue().toString();
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                        Button btnlk = (Button) findViewById(R.id.btnlk);
        btnlk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Oder_Food_Activity of=new Oder_Food_Activity();
                Toast.makeText(getApplication(),"dem :"+dem,Toast.LENGTH_SHORT).show();
                dem=""+(Integer.parseInt(dem)+1);
                myFirebaseRef.child(of.namefirebase).child(of.namefirebase+(position+1)).child("countslk").setValue(""+dem);

            }
        });


        // im.setImageBitmap();



        myFirebaseRef.child(of.namefirebase).child(of.namefirebase+(position+1)).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ImageView im=(ImageView)findViewById(R.id.imagefd);
                        byte[] decodedString = Base64.decode(dataSnapshot.child("image").getValue().toString(), Base64.DEFAULT);
                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                        im.setImageBitmap(decodedByte);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                btEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        EditText et = (EditText) findViewById(R.id.Edit);
                        // Log.e("edit",""+ et.getText());
                        if (et.getText().toString().equalsIgnoreCase("")) {

                        } else {
                            Oder_Food_Activity of = new Oder_Food_Activity();
                            myFirebaseRef.child(of.namefirebase).child(of.namefirebase + (position + 1)).child("comment").push().setValue("" + et.getText());
                        }

                    }
                });
    }
    @Override
    public void onResume() {
        super.onResume();

        // Display custom title
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle("Giới thiệu ");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f23057")));

        // Display the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    // Back arrow click event to go to the parent Activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }




}