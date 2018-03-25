package com.example.dev.the_food_house;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextPaint;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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

    private static final String MYTAG = "MYTAG";
    // Mã yêu cầu uhỏi người dùng cho phép xem vị trí hiện tại của họ (***).
    // Giá trị mã 8bit (value < 256).
    public static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;
    Button btnlocation;

    LocationManager locationManager;

    private static float Latitude;
    private static float Longitude;
    private List<Store_Activity> StoreList;
    int i=0;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_location, container, false);

        /// data json
//10.817666, 106.877082
        StoreList = new ArrayList<Store_Activity>();
        StoreList.add(new Store_Activity("Store1","address1",10.795204,106.594444,123456));
        StoreList.add(new Store_Activity("Store2","address2",10.860181, 106.644065,123456));
        StoreList.add(new Store_Activity("Store3","address3",10.995708, 106.782485,123456));
        StoreList.add(new Store_Activity("Store4","address4",10.811113, 106.594549,123456));
        StoreList.add(new Store_Activity("Store5","address5",10.882079, 106.919590,123456));
        StoreList.add(new Store_Activity("Store6","address6",10.912024, 106.892875,123456));
        StoreList.add(new Store_Activity("Store6","address6",10.758613, 106.891647,123456));
        StoreList.add(new Store_Activity("Store6","address6",10.817666, 106.877082,123456));
        StoreList.add(new Store_Activity("Store6","address6",10.891128, 106.751151,123456));

        ///
        try {
            locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }

        Button btsearch=(Button)rootView.findViewById(R.id.search);
        final FrameLayout fl = (FrameLayout) rootView.findViewById(R.id.slide);

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
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button button = (Button) rootView.findViewById(R.id.btnloca);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                /*Intent it=new Intent(getActivity(),MainActivity.class);
                it.putExtra("YourValueKey",""+1);
                startActivity(it);*/


                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {

                        if(Latitude==0&&Longitude==0)
                        {
                            Toast.makeText(getContext(),"Vui Lòng bật tìm vị trí !",Toast.LENGTH_SHORT).show();
                        }
                        else {

                            googleMap = mMap;
                            // For showing a move to my location button
                            googleMap.setMyLocationEnabled(true);
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
                                StoreList.get(i).setDistance((double) getDistanceMeters(Latitude,Longitude,StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude()));
                                doubleslist[i]=(double) getDistanceMeters(Latitude,Longitude,StoreList.get(i).getLatitude(),StoreList.get(i).getLongitude());
                                //Toast.makeText(getContext(),""+StoreList.get(i).getDistance(), Toast.LENGTH_SHORT).show();

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
                                    googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromResource(R.drawable.storett)));
                                }
                                if((""+doubleslist[1]).equalsIgnoreCase(""+StoreList.get(i).getDistance()))
                                {
                                    LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                    googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromResource(R.drawable.storett)));
                                }
                                if((""+doubleslist[2]).equalsIgnoreCase(""+StoreList.get(i).getDistance()))
                                {
                                    LatLng store = new LatLng(StoreList.get(i).getLatitude(), StoreList.get(i).getLongitude());
                                    googleMap.addMarker(new MarkerOptions().position(store).icon(BitmapDescriptorFactory.fromResource(R.drawable.storett)));
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

        return rootView;
    }


    public static long getDistanceMeters(double lat1, double lng1, double lat2, double lng2) {
        double l1 = toRadians(lat1);
        double l2 = toRadians(lat2);
        double g1 = toRadians(lng1);
        double g2 = toRadians(lng2);
        double dist = cos(sin(l1) * sin(l2) + cos(l1) * cos(l2) * cos(g1 - g2));
        if(dist < 0) {
            dist = dist + Math.PI;
        }
        return Math.round(dist * 6378100);
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


    @Override
    public void onLocationChanged(Location location) {
        //locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());

        Latitude=(float)location.getLatitude();
        Longitude=(float)location.getLongitude();


        try {
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            /*locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));*/
//            Toast.makeText(getContext(),"thanh:"+"\n"+addresses.get(0).getAddressLine(0)+", "+
//                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2),Toast.LENGTH_SHORT).show();
        }catch(Exception e)
        {

        }

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getContext(), "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }


}