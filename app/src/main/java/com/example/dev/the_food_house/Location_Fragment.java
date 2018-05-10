package com.example.dev.the_food_house;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.text.TextPaint;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.jar.Attributes;

import static java.lang.Math.toRadians;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**import java.net.URISyntaxException;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;


 import static android.widget.Toast.LENGTH_LONG;
 import static java.lang.Math.acos;
 import static java.lang.Math.toRadians;
 import static java.lang.StrictMath.cos;
 import static java.lang.StrictMath.sin;

 * Created by dev on 3/4/2018.
 */

public class Location_Fragment extends Fragment implements LocationListener {
    MapView mMapView;
    private GoogleMap googleMap;
    View rootView;

    private GoogleMap myMap;
    private ProgressDialog myProgress;
    private int dem=0;



    private static final String MYTAG = "MYTAG";
    // Mã yêu cầu uhỏi người dùng cho phép xem vị trí hiện tại của họ (***).
    // Giá trị mã 8bit (value < 256).
    public static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;
    Button btnlocation;

    LocationManager locationManager;

    private static float Latitude;
    private static float Longitude;

    private static String phone="01658380646";
    private static String namephone="";
    private static String numberphone="";


    private static String Latitude1="";
    private static String Latitude2="";
    private static String Latitude3="";

    private static String Longitude1="";
    private static String Longitude2="";
    private static String Longitude3="";



    private List<Store_Activity> StoreList;
    int i=0;
    FrameLayout fl;

    public static final int REQUEST_READ_CONTACTS = 79;

    DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

    private static String recoder="no";

    private  static  int camera=0;

    Switch sw;

    Context context;
    static String key="no";

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_location, container, false);



        /// data json
//10.817666, 106.877082
        StoreList = new ArrayList<Store_Activity>();

       /* StoreList.add(new Store_Activity("Store1","address1",10.795204,106.594444,123456));
        StoreList.add(new Store_Activity("Store2","address2",10.860181, 106.644065,123456));
        StoreList.add(new Store_Activity("Store3","address3",10.995708, 106.782485,123456));
        StoreList.add(new Store_Activity("Store4","address4",10.811113, 106.594549,123456));
        StoreList.add(new Store_Activity("Store5","address5",10.882079, 106.919590,123456));
        StoreList.add(new Store_Activity("Store6","address6",10.912024, 106.892875,123456));
        StoreList.add(new Store_Activity("Store7","address6",10.758613, 106.891647,123456));
        StoreList.add(new Store_Activity("Store8","address6",10.817666, 106.877082,123456));
        StoreList.add(new Store_Activity("Store9","address6",10.891128, 106.751151,123456));*/


//123
        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

        //        10.870111, 106.763398

        myFirebaseRef.child("tracking").child("01667123620").child("Latitude").setValue(""+10.870111);
        myFirebaseRef.child("tracking").child("01667123620").child("Longitude").setValue(""+106.763398);

//        Long Thành, Đồng Nai, Việt Nam
//        10.828623, 106.870041
        myFirebaseRef.child("tracking").child("0968859198").child("Latitude").setValue(""+10.828623);
        myFirebaseRef.child("tracking").child("0968859198").child("Longitude").setValue(""+106.870041);


//        Tp. Biên Hòa, Đồng Nai, Việt Nam
//        10.884594, 106.845322

        myFirebaseRef.child("tracking").child("0986007489").child("Latitude").setValue(""+10.884594);
        myFirebaseRef.child("tracking").child("0986007489").child("Longitude").setValue(""+106.845322);

        myFirebaseRef.child("tracking").child("753").child("Latitude").setValue(""+10.884894);
        myFirebaseRef.child("tracking").child("753").child("Longitude").setValue(""+106.848322);

        myFirebaseRef.child("tracking").child("951").child("Latitude").setValue(""+10.884394);
        myFirebaseRef.child("tracking").child("951").child("Longitude").setValue(""+106.843322);

        /*



        myFirebaseRef.child("stort").removeValue();

        myFirebaseRef.child("stort").child("stort1").child("address").setValue("114 võ văn ngân");//latitude
        myFirebaseRef.child("stort").child("stort1").child("latitude").setValue("10.795204");
        myFirebaseRef.child("stort").child("stort1").child("longtitude").setValue("106.594444");
        myFirebaseRef.child("stort").child("stort1").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort1").child("quan").setValue("quận 1");




        myFirebaseRef.child("stort").child("stort2").child("address").setValue("115 võ văn ngân");
        myFirebaseRef.child("stort").child("stort2").child("latitude").setValue("10.860181");
        myFirebaseRef.child("stort").child("stort2").child("longtitude").setValue("106.644065");
        myFirebaseRef.child("stort").child("stort2").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort2").child("quan").setValue("quận 1");


        myFirebaseRef.child("stort").child("stort3").child("address").setValue("116 võ văn ngân");
        myFirebaseRef.child("stort").child("stort3").child("latitude").setValue("10.995708");
        myFirebaseRef.child("stort").child("stort3").child("longtitude").setValue("106.782485");
        myFirebaseRef.child("stort").child("stort3").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort3").child("quan").setValue("quận 1");


        myFirebaseRef.child("stort").child("stort4").child("address").setValue("117 võ văn ngân");
        myFirebaseRef.child("stort").child("stort4").child("latitude").setValue("10.811113");
        myFirebaseRef.child("stort").child("stort4").child("longtitude").setValue("106.594549");
        myFirebaseRef.child("stort").child("stort4").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort4").child("quan").setValue("quận 2");


        myFirebaseRef.child("stort").child("stort5").child("address").setValue("118 võ văn ngân");
        myFirebaseRef.child("stort").child("stort5").child("latitude").setValue("10.882079");
        myFirebaseRef.child("stort").child("stort5").child("longtitude").setValue("106.919590");
        myFirebaseRef.child("stort").child("stort5").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort5").child("quan").setValue("quận 2");


        myFirebaseRef.child("stort").child("stort6").child("address").setValue("119 võ văn ngân");
        myFirebaseRef.child("stort").child("stort6").child("latitude").setValue("10.912024");
        myFirebaseRef.child("stort").child("stort6").child("longtitude").setValue("106.892875");
        myFirebaseRef.child("stort").child("stort6").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort6").child("quan").setValue("quận 2");


        myFirebaseRef.child("stort").child("stort7").child("address").setValue("120 võ văn ngân");
        myFirebaseRef.child("stort").child("stort7").child("latitude").setValue("10.758613");
        myFirebaseRef.child("stort").child("stort7").child("longtitude").setValue("106.891647");
        myFirebaseRef.child("stort").child("stort7").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort7").child("quan").setValue("quận 3");

        myFirebaseRef.child("stort").child("stort8").child("address").setValue("121 võ văn ngân");
        myFirebaseRef.child("stort").child("stort8").child("latitude").setValue("10.817666");
        myFirebaseRef.child("stort").child("stort8").child("longtitude").setValue("106.877082");
        myFirebaseRef.child("stort").child("stort8").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort8").child("quan").setValue("quận 3");

        myFirebaseRef.child("stort").child("stort9").child("address").setValue("122 võ văn ngân");
        myFirebaseRef.child("stort").child("stort9").child("latitude").setValue("10.891128");
        myFirebaseRef.child("stort").child("stort9").child("longtitude").setValue("106.751151");
        myFirebaseRef.child("stort").child("stort9").child("phone").setValue("01658380646");
        myFirebaseRef.child("stort").child("stort9").child("quan").setValue("quận 3");

        Toast.makeText(getContext(),"firebase !",Toast.LENGTH_SHORT).show();

        for (int i=1;i<=3;i++)
        {
            Bitmap bmp =  BitmapFactory.decodeResource(getResources(),R.drawable.cafehai);//your image
            ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
            bmp.recycle();
            byte[] byteArray = bYtE.toByteArray();
            String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
            myFirebaseRef.child("stort").child("stort"+i).child("image").setValue(""+encodedImage);
            Log.e("log",""+encodedImage);
        }

        for (int i=4;i<=6;i++)
        {
            Bitmap bmp =  BitmapFactory.decodeResource(getResources(),R.drawable.cafebon);//your image
            ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
            bmp.recycle();
            byte[] byteArray = bYtE.toByteArray();
            String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
            myFirebaseRef.child("stort").child("stort"+i).child("image").setValue(""+encodedImage);
            Log.e("log",""+encodedImage);
        }

        for (int i=7;i<=9;i++)
        {
            Bitmap bmp =  BitmapFactory.decodeResource(getResources(),R.drawable.cafesau);//your image
            ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
            bmp.recycle();
            byte[] byteArray = bYtE.toByteArray();
            String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
            myFirebaseRef.child("stort").child("stort"+i).child("image").setValue(""+encodedImage);
            Log.e("log",""+encodedImage);
        }*/

        //stort

        StoreList.clear();

        myFirebaseRef.child("stort").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                StoreList.add(new Store_Activity(dataSnapshot.getValue().toString(),dataSnapshot.child("address").getValue().toString(),Double.parseDouble(dataSnapshot.child("latitude").getValue().toString()),Double.parseDouble(dataSnapshot.child("longtitude").getValue().toString()),Integer.parseInt(dataSnapshot.child("phone").getValue().toString()), dataSnapshot.child("image").getValue().toString(), dataSnapshot.child("quan").getValue().toString()));
//               Log.e("stort"," name :"+dataSnapshot.getValue().toString()+" address :"+dataSnapshot.child(" address").getValue().toString()+"latitude :"+Double.parseDouble(dataSnapshot.child(" latitude").getValue().toString())+" longtitude :"+Double.parseDouble(dataSnapshot.child("longtitude").getValue().toString())+"  phone :"+Integer.parseInt(dataSnapshot.child("phone").getValue().toString()));
                Log.e("stort",""+StoreList.size());

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

        ///
        Button btsearch=(Button)rootView.findViewById(R.id.search);
        fl = (FrameLayout) rootView.findViewById(R.id.slide);

        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"cham button",Toast.LENGTH_SHORT).show();
                //Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                if(i==0) {
                    fl.setVisibility(View.VISIBLE);
                    i++;
                }
                else
                {
                    fl.setVisibility(View.GONE);
                    i=0;
                }

            }
        });

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {

            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, this);


        } catch (SecurityException e) {
            e.printStackTrace();
        }



        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        ImageButton ibtn1map=(ImageButton)rootView.findViewById(R.id.item1btn);
        ibtn1map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(Longitude1.equalsIgnoreCase("")||Latitude1.equalsIgnoreCase(""))
                {

                }
                else
                {
                    Toast.makeText(getContext(),"cham 1 !",Toast.LENGTH_SHORT).show();

                    String uri = "http://maps.google.com/maps?saddr=" +Latitude + "," + Longitude + "&daddr=" + Latitude1 + "," +Longitude1;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }

            }
        });

        ImageButton ibtn2map=(ImageButton)rootView.findViewById(R.id.item2btn);
        ibtn2map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Longitude1.equalsIgnoreCase("")||Latitude1.equalsIgnoreCase(""))
                {

                }
                else
                {
                    Toast.makeText(getContext(),"cham 2 !",Toast.LENGTH_SHORT).show();
                    String uri = "http://maps.google.com/maps?saddr=" +Latitude + "," + Longitude + "&daddr=" + Latitude2 + "," +Longitude2;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);

                }


            }
        });

        ImageButton ibtn3map=(ImageButton)rootView.findViewById(R.id.item3btn);
        ibtn3map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Longitude1.equalsIgnoreCase("")||Latitude1.equalsIgnoreCase(""))
                {

                }
                else
                {
                    Toast.makeText(getContext(),"cham 3 !",Toast.LENGTH_SHORT).show();
                    String uri = "http://maps.google.com/maps?saddr=" +Latitude + "," + Longitude + "&daddr=" + Latitude3 + "," +Longitude3;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }

            }
        });


        Button btnq1=(Button)rootView.findViewById(R.id.btnquan1);

        btnq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);
                            ll.setVisibility(View.VISIBLE);

                            DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);

                            googleMap.clear();






                            // For dropping a marker at a point on the Map
                            LatLng sydney = new LatLng(Latitude, Longitude);
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                            //Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();

                            for(int i=0;i<StoreList.size();i++)
                            {
                                StoreList.get(i).setDistance(Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                                myFirebaseRef.child("stort").child("stort"+(i+ 1)).child("distance").setValue(""+Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                            }

                            dem=0;
                            for(int i=0;i<StoreList.size();i++)
                            {

                                if(StoreList.get(i).getquan().equalsIgnoreCase("quận 1"))
                                {
                                    if(dem==0)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());

                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv1i=(ImageView)rootView.findViewById(R.id.item1image);
                                        iv1i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item1address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item1quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item1distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                        Latitude1=""+StoreList.get(i).getLatitude();
                                        Longitude1=""+StoreList.get(i).getLongitude();

                                    }else if(dem==1)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv2i=(ImageView)rootView.findViewById(R.id.item2image);
                                        iv2i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item2address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item2quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item2distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");

                                        Latitude2=""+StoreList.get(i).getLatitude();

                                        Longitude2=""+StoreList.get(i).getLongitude();
                                    }else if(dem==2)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv3i=(ImageView)rootView.findViewById(R.id.item3image);
                                        iv3i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item3address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item3quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item3distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                        Latitude3=""+StoreList.get(i).getLatitude();
                                        Longitude3=""+StoreList.get(i).getLongitude();
                                    }
                                    dem++;

                                }
                                Log.d("song1","-"+i+":"+StoreList.get(i).getDistance());

                            }
                            fl.setVisibility(View.GONE);
                            i=0;

                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                        }
                    }
                });


            }
        });


        Button btnq2=(Button)rootView.findViewById(R.id.btnquan2);

        btnq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);
                            ll.setVisibility(View.VISIBLE);

                            DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);

                            googleMap.clear();


                            // For dropping a marker at a point on the Map
                            LatLng sydney = new LatLng(Latitude, Longitude);
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                            //Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();

                            for(int i=0;i<StoreList.size();i++)
                            {
                                StoreList.get(i).setDistance(Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                                myFirebaseRef.child("stort").child("stort"+(i+ 1)).child("distance").setValue(""+Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                            }

                            dem=0;
                            for(int i=0;i<StoreList.size();i++)
                            {

                                if(StoreList.get(i).getquan().equalsIgnoreCase("quận 2"))
                                {
                                    if(dem==0)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());

                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv1i=(ImageView)rootView.findViewById(R.id.item1image);
                                        iv1i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item1address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item1quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item1distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                        Latitude1=""+StoreList.get(i).getLatitude();
                                        Longitude1=""+StoreList.get(i).getLongitude();

                                    }else if(dem==1)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv2i=(ImageView)rootView.findViewById(R.id.item2image);
                                        iv2i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item2address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item2quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item2distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");

                                        Latitude2=""+StoreList.get(i).getLatitude();

                                        Longitude2=""+StoreList.get(i).getLongitude();
                                    }else if(dem==2)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv3i=(ImageView)rootView.findViewById(R.id.item3image);
                                        iv3i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item3address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item3quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item3distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                        Latitude3=""+StoreList.get(i).getLatitude();
                                        Longitude3=""+StoreList.get(i).getLongitude();

                                    }
                                    dem++;

                                }
                                Log.d("song1","-"+i+":"+StoreList.get(i).getDistance());

                            }
                            fl.setVisibility(View.GONE);
                            i=0;

                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                        }
                    }
                });
            }
        });

        Button btnq3=(Button)rootView.findViewById(R.id.btnquan3);
        btnq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);
                            ll.setVisibility(View.VISIBLE);

                            DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);


                            googleMap.clear();


                            // For dropping a marker at a point on the Map
                            LatLng sydney = new LatLng(Latitude, Longitude);
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                            //Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();

                            for(int i=0;i<StoreList.size();i++)
                            {
                                StoreList.get(i).setDistance(Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                                myFirebaseRef.child("stort").child("stort"+(i+ 1)).child("distance").setValue(""+Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                            }

                            dem=0;
                            for(int i=0;i<StoreList.size();i++)
                            {

                                if(StoreList.get(i).getquan().equalsIgnoreCase("quận 3"))
                                {
                                    if(dem==0)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());

                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv1i=(ImageView)rootView.findViewById(R.id.item1image);
                                        iv1i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item1address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item1quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item1distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                        Latitude1=""+StoreList.get(i).getLatitude();
                                        Longitude1=""+StoreList.get(i).getLongitude();

                                    }else if(dem==1)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv2i=(ImageView)rootView.findViewById(R.id.item2image);
                                        iv2i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item2address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item2quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item2distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");

                                        Latitude2=""+StoreList.get(i).getLatitude();

                                        Longitude2=""+StoreList.get(i).getLongitude();
                                    }else if(dem==2)
                                    {
                                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                        Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                        byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                        ImageView iv3i=(ImageView)rootView.findViewById(R.id.item3image);
                                        iv3i.setImageBitmap(decodedByte);

                                        TextView tv1d=(TextView)rootView.findViewById(R.id.item3address);
                                        tv1d.setText("  "+StoreList.get(i).getAddress());

                                        TextView tv1q=(TextView)rootView.findViewById(R.id.item3quan );
                                        tv1q.setText("  "+StoreList.get(i).getquan());

                                        TextView tv1ds=(TextView)rootView.findViewById(R.id.item3distance);
                                        tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                        Latitude3=""+StoreList.get(i).getLatitude();
                                        Longitude3=""+StoreList.get(i).getLongitude();
                                    }
                                    dem++;

                                }
                                Log.d("song1","-"+i+":"+StoreList.get(i).getDistance());

                            }
                            fl.setVisibility(View.GONE);
                            i=0;


                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                        }
                    }
                });


            }
        });

        Button btnall=(Button)rootView.findViewById(R.id.btnquanall);
        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);
                            ll.setVisibility(View.VISIBLE);

                            DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);

                            googleMap.clear();

                            // For dropping a marker at a point on the Map
                            LatLng sydney = new LatLng(Latitude, Longitude);
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                            //Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();

                            for(int i=0;i<StoreList.size();i++)
                            {
                                StoreList.get(i).setDistance(Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                                myFirebaseRef.child("stort").child("stort"+(i+ 1)).child("distance").setValue(""+Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));
                            }

                            for(int i=0;i<StoreList.size();i++)
                            {
                                LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromResource(R.drawable.storett)));
                            }

                            ll = (LinearLayout) rootView.findViewById(R.id.scroll);
                            ll.setVisibility(View.GONE);

                            fl.setVisibility(View.GONE);


                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                        }
                    }
                });
            }
        });

        Button button = (Button) rootView.findViewById(R.id.btnloca);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View view)
            {

                /*Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey",""+1);
                startActivity(it);*/

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);

                            ll.setVisibility(View.VISIBLE
                            );

                            DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);

                            googleMap.clear();

                            // For dropping a marker at a point on the Map
                            LatLng sydney = new LatLng(Latitude, Longitude);
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                            //Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
//                    for(int i=0;i<StoreList.size();i++)
//                    {
//                        LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
//                        googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromResource(R.drawable.storett)));
//                    }
                            Double[] doubleslist=new Double[StoreList.size()];

                            for(int i=0;i<StoreList.size();i++)
                            {
                                StoreList.get(i).setDistance(Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));

                                doubleslist[i]=Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude()));
                                //Toast.makeText(getContext(),""+StoreList.get(i).getDistance(), Toast.LENGTH_SHORT).show();

                                myFirebaseRef.child("stort").child("stort"+(i+ 1)).child("distance").setValue(""+Double.parseDouble(""+GetDistanceFromCurrentPosition(Latitude, Longitude,
                                        StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude())));

                            }
                            Double emp;
                            for(int i=0;i<StoreList.size();i++)
                            {
                                for(int j=i+1;j<StoreList.size();j++)
                                {
                                    if(doubleslist[i]>doubleslist[j])
                                    {
                                        emp=doubleslist[i];
                                        doubleslist[i]=doubleslist[j];
                                        doubleslist[j]=emp;
                                    }
                                }
                            }

                            for(int i=0;i<StoreList.size();i++)
                            {

                                if((""+doubleslist[0]).equalsIgnoreCase(""+StoreList.get(i).getDistance()))
                                {

                                    LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());

                                    Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                    Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                    googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                    byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                    ImageView iv1i=(ImageView)rootView.findViewById(R.id.item1image);
                                    iv1i.setImageBitmap(decodedByte);

                                    TextView tv1d=(TextView)rootView.findViewById(R.id.item1address);
                                    tv1d.setText("  "+StoreList.get(i).getAddress());

                                    TextView tv1q=(TextView)rootView.findViewById(R.id.item1quan );
                                    tv1q.setText("  "+StoreList.get(i).getquan());

                                    TextView tv1ds=(TextView)rootView.findViewById(R.id.item1distance);
                                    tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                    Latitude1=""+StoreList.get(i).getLatitude();

                                    Longitude1=""+StoreList.get(i).getLongitude();


                                }
                                if((""+doubleslist[1]).equalsIgnoreCase(""+StoreList.get(i).getDistance()))
                                {
                                    LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                    Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                    Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                    googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                    byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                    ImageView iv2i=(ImageView)rootView.findViewById(R.id.item2image);
                                    iv2i.setImageBitmap(decodedByte);

                                    TextView tv1d=(TextView)rootView.findViewById(R.id.item2address);
                                    tv1d.setText("  "+StoreList.get(i).getAddress());

                                    TextView tv1q=(TextView)rootView.findViewById(R.id.item2quan );
                                    tv1q.setText("  "+StoreList.get(i).getquan());

                                    TextView tv1ds=(TextView)rootView.findViewById(R.id.item2distance);
                                    tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");

                                    Latitude2=""+StoreList.get(i).getLatitude();

                                    Longitude2=""+StoreList.get(i).getLongitude();

                                }
                                if((""+doubleslist[2]).equalsIgnoreCase(""+StoreList.get(i).getDistance()))
                                {
                                    LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                    Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.pickmarhet);
                                    Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 50, 50, true);

                                    googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)));

                                    byte[] decodedString = Base64.decode(StoreList.get(i).getimage(), Base64.DEFAULT);
                                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                                    ImageView iv3i=(ImageView)rootView.findViewById(R.id.item3image);
                                    iv3i.setImageBitmap(decodedByte);

                                    TextView tv1d=(TextView)rootView.findViewById(R.id.item3address);
                                    tv1d.setText("  "+StoreList.get(i).getAddress());

                                    TextView tv1q=(TextView)rootView.findViewById(R.id.item3quan );
                                    tv1q.setText("  "+StoreList.get(i).getquan());

                                    TextView tv1ds=(TextView)rootView.findViewById(R.id.item3distance);
                                    tv1ds.setText("  "+Math.round(StoreList.get(i).getDistance()/100)/10+" km");


                                    Latitude3=""+StoreList.get(i).getLatitude();
                                    Longitude3=""+StoreList.get(i).getLongitude();

                                }

                                Log.d("song1","-"+i+":"+StoreList.get(i).getDistance());
                                Log.d("song2",""+doubleslist[i]);

                            }

                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                        }
                    }
                });
            }
        });

//987



        sw=(Switch)rootView.findViewById(R.id.simpleSwitch);

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//987
                if(sw.isChecked())
                {

                    Toast.makeText(getContext(), "Switch is on", Toast.LENGTH_LONG).show();
                    key="yes";
                    LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);
                    ll.setVisibility(View.GONE);
                    camera = 0;


                }
                else {

                    Toast.makeText(getContext(), "Switch is Off", Toast.LENGTH_LONG).show();
                    key="no";
                    mMapView.getMapAsync(new OnMapReadyCallback() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onMapReady(GoogleMap mMap) {
                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);
                            googleMap.clear();

                        }
                    });
                    LinearLayout ll=(LinearLayout)rootView.findViewById(R.id.scroll);
                    ll.setVisibility(View.GONE);
                    camera = 0;


                }

            }
        });


        // getContacts();
        return rootView;
    }

    public void getContacts(String number) {

        String phoneNumber = null;

        Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
        String _ID = ContactsContract.Contacts._ID;
        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

        Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
        String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;


        StringBuffer output = new StringBuffer();

        ContentResolver contentResolver = getContext().getContentResolver();

        Cursor cursor = contentResolver.query(CONTENT_URI, null,null, null, null);

        // Loop for every contact in the phone
        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                String contact_id = cursor.getString(cursor.getColumnIndex( _ID ));
                String name = cursor.getString(cursor.getColumnIndex( DISPLAY_NAME ));

                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex( HAS_PHONE_NUMBER )));

                if (hasPhoneNumber > 0) {

                    output.append("\n First Name:" + name);

                    Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[] { contact_id }, null);
                    while (phoneCursor.moveToNext()) {

                        phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
                        output.append("\n Phone number:" + phoneNumber);
//987
                        if(phoneNumber.equalsIgnoreCase(number)) {

                            recoder="yes";
                            namephone=name;
                            numberphone=phoneNumber;
                        }


                    }
                    phoneCursor.close();

                }
                output.append("\n ------------------");

            }
            Log.e("contactTextView",""+output.toString());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
//////////// location ..


    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }
//789

    @Override
    public void onLocationChanged(Location location) {
        //locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

        if(key.equalsIgnoreCase("yes"))
        {

            Latitude = (float) location.getLatitude();
            Longitude = (float) location.getLongitude();

//        10.870111, 106.763398

            mMapView.getMapAsync(new OnMapReadyCallback() {
                @SuppressLint("MissingPermission")
                @Override
                public void onMapReady(GoogleMap mMap) {

                    googleMap = mMap;

                    // For showing a move to my location button
                    googleMap.setMyLocationEnabled(true);

                    //10.847556, 106.785033
                    googleMap.clear();

                    myFirebaseRef.child("tracking").child(phone).child("Latitude").setValue("" + Latitude);
                    myFirebaseRef.child("tracking").child(phone).child("Longitude").setValue("" + Longitude);

                    myFirebaseRef.child("tracking").addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(final DataSnapshot dataSnapshot, String s) {


                            recoder = "no";
                            getContacts(dataSnapshot.getKey().toString());

                            if (recoder.equalsIgnoreCase("yes")) {
//icon

                                // For dropping a marker at a point on the Map
                                LatLng sydney = new LatLng(Double.parseDouble(dataSnapshot.child("Latitude").getValue().toString()), Double.parseDouble(dataSnapshot.child("Longitude").getValue().toString()));

                                Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.friend);
                                Bitmap bMapScaled = Bitmap.createScaledBitmap(bMap, 100, 100, true);


//icon
                                googleMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromBitmap(bMapScaled)).title(namephone).snippet(numberphone).visible(true)).showInfoWindow();
                                Log.e("namephone", "" + namephone);

                                //googleMap.add
                                // For zooming automatically to the location of the marker

                                if (camera == 0) {
                                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                                    camera++;
                                } else {

                                }

                            }

                            Log.e("tracking", "" + dataSnapshot.getValue().toString() + "  re :" + recoder + "  key :" + dataSnapshot.getKey().toString());
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
            });

            try {

                Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            /*locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));*/
                Toast.makeText(getContext(), "thanh:" + "\n" + addresses.get(0).getAddressLine(0) + ", " +
                        addresses.get(0).getAddressLine(1) + ", " + addresses.get(0).getAddressLine(2), Toast.LENGTH_SHORT).show();

            } catch (Exception e) {

            }


        }

    }



    public Bitmap createPureTextIcon(String text) {

        Paint textPaint = new Paint(); // Adapt to your needs

        float textWidth = textPaint.measureText(text);
        float textHeight = textPaint.getTextSize();
        int width = (int) (textWidth);
        int height = (int) (textHeight);

        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);

        canvas.translate(0, height);

        // For development only:
        // Set a background in order to see the
        // full size and positioning of the bitmap.
        // Remove that for a fully transparent icon.
        canvas.drawColor(Color.RED);


        canvas.drawText(text, 0, 0, textPaint);
        // BitmapDescriptor icon = BitmapDescriptorFactory.fromBitmap(image);

        return image;
    }


    @Override
    public void onProviderDisabled(String provider) {


        Toast.makeText(getContext(), "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();

    }

    public static float GetDistanceFromCurrentPosition(double lat1,double lng1, double lat2, double lng2)
    {
        double earthRadius = 3958.75;

        double dLat = Math.toRadians(lat2 - lat1);

        double dLng = Math.toRadians(lng2 - lng1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2)
                * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double dist = earthRadius * c;

        int meterConversion = 1609;

        return new Float(dist * meterConversion).floatValue();

    }


}

