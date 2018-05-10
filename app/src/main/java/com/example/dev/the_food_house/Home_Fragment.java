//HomeFragment
package com.example.dev.the_food_house;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by dev on 3/4/2018.
 */


public class Home_Fragment extends Fragment {
    private View mRootView;
    Button  btndt;
    Button  btndt1;
    Button  btndt3;
    Button  btndt4;
    Button  btndt2;
    Button  btndt5;
    Button  btndt6;
    Button  btndt7;
    Button  btndt8;
    Button  btndt9;
    TextView tv;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    ImageView im;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        mRootView = inflater.inflate(R.layout.hson_fragment_home,container,false);


        btndt=(Button)mRootView.findViewById(R.id.buttondathang);


        Button  btndt=(Button)mRootView.findViewById(R.id.buttondathang);
        Button  review=(Button)mRootView.findViewById(R.id.btn2);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),Hien_Review.class);
                startActivity(it);
            }
        });

        btndt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);


            }
        });

        btndt1=(Button)mRootView.findViewById(R.id.btndathang1);

        btndt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);


            }
        });

        btndt2=(Button)mRootView.findViewById(R.id.btndathang2);
        btndt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
            }
        });

        btndt3=(Button)mRootView.findViewById(R.id.btndathang3);
        btndt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
            }
        });

        btndt4=(Button)mRootView.findViewById(R.id.btndathang4);
        btndt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
            }
        });


        btndt5=(Button)mRootView.findViewById(R.id.btn2); //button xem them
        btndt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);


            }
        });


        btndt6=(Button)mRootView.findViewById(R.id.btn3);
        btndt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey2",""+1);
                startActivity(it);

            }
        });

        btndt7=(Button)mRootView.findViewById(R.id.btn4);
        btndt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey3",""+1);
                startActivity(it);


            }
        });

        btndt8=(Button)mRootView.findViewById(R.id.btn5);
        btndt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey4",""+1);
                startActivity(it);


            }
        });

        btndt9=(Button)mRootView.findViewById(R.id.history);

        btndt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getActivity(),HistoryActivity.class);

                it.putExtra("YourValueKey5",""+1);

                startActivity(it);


            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();


                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey1",""+1);
                startActivity(it);
                return false;
            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton1);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();


                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey2",""+1);
                startActivity(it);
                return false;
            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton2);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();

                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey3",""+1);
                startActivity(it);
                return false;
            }
        });

        im=(ImageView)mRootView.findViewById(R.id.picture_imagebutton3);
        im.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(),"touch",Toast.LENGTH_SHORT).show();


                Intent it=new Intent(getActivity(),ReadmoreActivity.class);
                it.putExtra("YourValueKey4",""+1);
                startActivity(it);
                return false;
            }
        });





        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();
        myFirebaseRef.child("home").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                if(dataSnapshot.getKey().toString().equalsIgnoreCase("text1"))
                {
                    tv=(TextView)mRootView.findViewById(R.id.text);
                    tv.setText(""+dataSnapshot.getValue().toString());
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());

                }
                if(dataSnapshot.getKey().toString().equalsIgnoreCase("text2"))
                {
                    TextView tv1=(TextView)mRootView.findViewById(R.id.text1);
                    tv1.setText(""+dataSnapshot.getValue().toString());
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());
                }
                if(dataSnapshot.getKey().toString().equalsIgnoreCase("text3"))
                {
                    TextView tv1=(TextView)mRootView.findViewById(R.id.text2);
                    tv1.setText(""+dataSnapshot.getValue().toString());
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());
                }
                if(dataSnapshot.getKey().toString().equalsIgnoreCase("text4"))
                {
                    TextView tv1=(TextView)mRootView.findViewById(R.id.text3);
                    tv1.setText(""+dataSnapshot.getValue().toString());
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());

                }

                if(dataSnapshot.getKey().toString().equalsIgnoreCase("image1"))
                {
                     ImageView iv=(ImageView)mRootView.findViewById(R.id.picture_imagebutton);

                     byte[] decodedString = Base64.decode(dataSnapshot.getValue().toString(), Base64.DEFAULT);
                     Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                     iv.setImageBitmap(decodedByte);
                     Log.e("thanh khong",""+dataSnapshot.getValue().toString());

                }

                if(dataSnapshot.getKey().toString().equalsIgnoreCase("image2"))
                {
                    ImageView iv=(ImageView)mRootView.findViewById(R.id.picture_imagebutton1);

                    byte[] decodedString = Base64.decode(dataSnapshot.getValue().toString(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    iv.setImageBitmap(decodedByte);
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());

                }

                if(dataSnapshot.getKey().toString().equalsIgnoreCase("image3"))
                {
                    ImageView iv=(ImageView)mRootView.findViewById(R.id.picture_imagebutton2);

                    byte[] decodedString = Base64.decode(dataSnapshot.getValue().toString(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    iv.setImageBitmap(decodedByte);
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());

                }
                if(dataSnapshot.getKey().toString().equalsIgnoreCase("image4"))
                {
                    ImageView iv=(ImageView)mRootView.findViewById(R.id.picture_imagebutton3);

                    byte[] decodedString = Base64.decode(dataSnapshot.getValue().toString(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    iv.setImageBitmap(decodedByte);
                    Log.e("thanh khong",""+dataSnapshot.getValue().toString());

                }


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









        return mRootView;
    }
}
