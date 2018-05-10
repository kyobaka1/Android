package com.example.dev.the_food_house;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.MapView;import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by dev on 3/4/2018.
 */

public class Food_Fragment  extends Fragment implements LocationListener {
    MapView mMapView;
    private GoogleMap googleMap;

    private static double Latitude;
    private static double Longitude;
    static  String locations="";

    LocationManager locationManager;
    EditText txlocation;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_food, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume(); // needed to get the map to display immediately


        try {

            locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,0,this);

        }
        catch(SecurityException e) {
            e.printStackTrace();
        }


        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
//        List<Address> addresses = null;
//        try {
//            addresses = geocoder.getFromLocationName("97 man thiện", 1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Address address = addresses.get(0);
//        Longitude = address.getLongitude();
//          Latitude = address.getLatitude();
//



//        Log.e("khong",""+PhoneNumber);


        txlocation=(EditText)rootView.findViewById(R.id.edlocation);

        txlocation.setInputType(InputType.TYPE_NULL);

        Button button = (Button) rootView.findViewById(R.id.btnloca);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Location","Long  :"+Longitude+"La :"+Latitude);
                if(Latitude==0&&Longitude==0||locations.equalsIgnoreCase(""))
                {
                    Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mMapView.getMapAsync(new OnMapReadyCallback() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onMapReady(GoogleMap mMap) {
                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);
                            //10.847556, 106.785033
                            // For dropping a marker at a point on the Map
                            //LatLng sydney = new LatLng(Latitude, Longitude);
                            LatLng sydney = new LatLng(Latitude, Longitude);
                            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
                            // For zooming automatically to the location of the marker
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                            txlocation.setText(locations);
                        }
                    });

                }

            }
        });

        Button but = (Button) rootView.findViewById(R.id.btnChonMon);

        but.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it=new Intent(getActivity(),Oder_Food_Activity.class);
                startActivity(it);
                // Toast.makeText(getContext(),"thanh",Toast.LENGTH_SHORT).show();
            }
        });

//        Intent it=new Intent(getActivity(),Oder_Food_Activity.class);
//        startActivity(it);

        Button btntime=(Button)rootView.findViewById(R.id.btnpicktime);
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FrameLayout sr=(FrameLayout)rootView.findViewById(R.id.scroll);
                FrameLayout fl=(FrameLayout)rootView.findViewById(R.id.fl);

                sr.setVisibility(View.VISIBLE);
                fl.setVisibility(View.GONE);
                Toast.makeText(getContext(),"cham !",Toast.LENGTH_SHORT).show();

            }
        });



        rootView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePicker datePicker = (DatePicker) rootView.findViewById(R.id.date_picker);
                TimePicker timePicker = (TimePicker) rootView.findViewById(R.id.time_picker);

                Calendar calendar = new GregorianCalendar(
                        datePicker.getYear(),
                        datePicker.getMonth(),
                        datePicker.getDayOfMonth(),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute());

                Log.e("time",""+calendar.getTime());

                FrameLayout sr=(FrameLayout)rootView.findViewById(R.id.scroll);
                FrameLayout fl=(FrameLayout)rootView.findViewById(R.id.fl);

                sr.setVisibility(View.GONE);
                fl.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(),"cham !",Toast.LENGTH_SHORT).show();
                TextView txttime=(TextView)rootView.findViewById(R.id.txttime);
                txttime.setText(""+calendar.getTime());


            }
        });



        txlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txlocation.setInputType(InputType.TYPE_CLASS_TEXT);
                txlocation.requestFocus();

                txlocation.setText("");
                txlocation.setHint("");


            }
        });

        txlocation.setHint("Vị trí của bạn !");

        txlocation.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (keyCode ==  KeyEvent.KEYCODE_DPAD_CENTER || keyCode ==  KeyEvent.KEYCODE_ENTER) {

                    if (event.getAction() == KeyEvent.ACTION_DOWN) {


                        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());


                        List<Address> addresses = null;
                        try {
                            addresses = geocoder.getFromLocationName(""+txlocation.getText(), 1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        Address address = addresses.get(0);
                        Longitude = address.getLongitude();
                        Latitude = address.getLatitude();


                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {

                            mMapView.getMapAsync(new OnMapReadyCallback() {
                                @SuppressLint("MissingPermission")
                                @Override
                                public void onMapReady(GoogleMap mMap) {



                                    googleMap = mMap;

                                    // For showing a move to my location button
                                    googleMap.setMyLocationEnabled(true);



                                    //10.847556, 106.785033
                                    // For dropping a marker at a point on the Map
                                    //LatLng sydney = new LatLng(Latitude, Longitude);
                                    LatLng sydney = new LatLng(Latitude, Longitude);


                                    googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

                                    // For zooming automatically to the location of the marker
                                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


                                }
                            });

                        }

                    }
                    return true;

                } else {

                    return false;
                }
            }

        });


        return rootView;
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

    @Override
    public void onLocationChanged(Location location) {

        Latitude=(float)location.getLatitude();
        Longitude=(float)location.getLongitude();
        try {
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            /*locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));*/
            Toast.makeText(getContext(),"thanh:"+"\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2),Toast.LENGTH_SHORT).show();
            locations=addresses.get(0).getAddressLine(0)+", "+ addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2);

            // location=+addresses.get(0).getAddressLine(0)+", "+addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2);

        }catch(Exception e)
        {

        }


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


}

