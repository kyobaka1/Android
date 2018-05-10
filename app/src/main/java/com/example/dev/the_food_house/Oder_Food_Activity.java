package com.example.dev.the_food_house;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Oder_Food_Activity extends AppCompatActivity implements ActionBar.TabListener{
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;

    private List<Product> productList;
    private int currentViewMode = 0;
    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    static int number ;
    static int total ;
    static TextView tvtotal;
    static TextView tvnumber;
    static FrameLayout fl;
    static String com ="";

    static String namefirebase="food";


    private Toolbar mTopToolbar;


    private BroadcastReceiver ReceivefromService;


    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.oder_food_activity);

        ActionBar ab = getSupportActionBar();

        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // set background  action bar
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f23057")));
        // set background faction bar tab
        ab.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#88b4fc")));

        /*ab.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        ab.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        ab.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));*/

        // Three tab
        ab.addTab(ab.newTab().setText("Nổi  bật").setTabListener(this));
        ab.addTab(ab.newTab().setText("Thức Uống").setTabListener(this));
        ab.addTab(ab.newTab().setText("Bánh").setTabListener(this));

        ///add fire base
       /* Bitmap bmp =  BitmapFactory.decodeResource(getResources(),R.drawable.drinknam);//your image
        ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
        bmp.recycle();
        byte[] byteArray = bYtE.toByteArray();
        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        Log.e("log",""+encodedImage);*/

        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

        //myFirebaseRef.child("drink").child("drink5").child("image").setValue(""+encodedImage);

        /*for(int i=1;i<=5;i++)
        {
            myFirebaseRef.child("drink").child("drink"+i).child("comment").child("commet1").setValue("ngon như nước cống !");
            myFirebaseRef.child("drink").child("drink"+i).child("numbercomment").setValue("1");
        }*/

        // FirebaseNumber(2,3);

        // for(int i=0;i)

       /* byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        */

        /*ImageView iv=(ImageView)findViewById(R.id.test);
        iv.setImageBitmap(decodedByte);*/


       /* Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://app-f-e5a6e.firebaseio.com");
        for (int i = 0; i <= 10; i++) {
          }*/
        //getProductList();

        //FirebaseComment(0);


    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        //Called when a tab is selected
        int nTabSelected = tab.getPosition();

        switch (nTabSelected) {
            case 0: {

                namefirebase="food";
                setContentView(R.layout.actionbar_tab_1);

                stubList = (ViewStub) findViewById(R.id.stub_list);
                stubGrid = (ViewStub) findViewById(R.id.stub_grid);

                //Inflate ViewStub before get view
                stubList.inflate();
                stubGrid.inflate();

                listView = (ListView) findViewById(R.id.mylistview);
                gridView = (GridView) findViewById(R.id.mygridview);
                productList = new ArrayList<>();

                listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
                listView.setAdapter(listViewAdapter);
                gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
                gridView.setAdapter(gridViewAdapter);

                //get list of product
                //getProductList();


                productList.clear();


                DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                myFirebaseRef.child("food").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        productList.add(new Product(dataSnapshot.child("image").getValue().toString(), dataSnapshot.child("name").getValue().toString(),dataSnapshot.child("des").getValue().toString(),Integer.parseInt(dataSnapshot.child("price").getValue().toString()),Integer.parseInt(dataSnapshot.child("number").getValue().toString())));

                        listViewAdapter.notifyDataSetChanged();
                        gridViewAdapter.notifyDataSetChanged();

                        //Log.e("firebase",""+ dataSnapshot.child("food1").getValue().toString());
                   /* byte[] decodedString = Base64.decode(dataSnapshot.child("image").getValue().toString(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    ImageView iv=(ImageView)findViewById(R.id.test);
                    iv.setImageBitmap(decodedByte);*/

                        //  Log.e("firebase","---"+Integer.parseInt(dataSnapshot.child("price").getValue().toString())+"---"+Integer.parseInt(dataSnapshot.child("number").getValue().toString()) );

                        Log.e("connect","thanh"+dataSnapshot);
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


                //Get current view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview

                //Register item lick
                listView.setOnItemClickListener(onItemClick);
                gridView.setOnItemClickListener(onItemClick);


                Button btclose=(Button)findViewById(R.id.close);
                final FrameLayout flt=(FrameLayout)findViewById(R.id.dialog);

                btclose.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        flt.setVisibility(View.GONE);
                    }
                });

                tvtotal=(TextView)findViewById(R.id.total);
                tvnumber=(TextView)findViewById(R.id.number);
                fl=(FrameLayout)findViewById(R.id.border);

                if(number==0)
                {
                    fl.setVisibility(View.GONE);
                    tvtotal.setVisibility(View.GONE);

                }

                tvtotal.setText(""+total+" đ");

                tvnumber.setText(""+number);


                Button btxdh=(Button)findViewById(R.id.btnxemdo);
                btxdh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(),"cham !",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),XemDoHangActivity.class);
                        startActivity(intent);


                    }
                });




                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                switchView();
                break;
            }
            case 1: {
                namefirebase="drink";
                setContentView(R.layout.actionbar_tab_2);

                stubList = (ViewStub) findViewById(R.id.stub_list);
                stubGrid = (ViewStub) findViewById(R.id.stub_grid);

                //Inflate ViewStub before get view
                stubList.inflate();
                stubGrid.inflate();

                listView = (ListView) findViewById(R.id.mylistview);
                gridView = (GridView) findViewById(R.id.mygridview);
                productList = new ArrayList<>();

                listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
                listView.setAdapter(listViewAdapter);
                gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
                gridView.setAdapter(gridViewAdapter);

                //get list of product
                //getProductList();


                productList.clear();
                DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();

                myFirebaseRef.child("drink").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        productList.add(new Product(dataSnapshot.child("image").getValue().toString(), dataSnapshot.child("name").getValue().toString(),dataSnapshot.child("des").getValue().toString(),Integer.parseInt(dataSnapshot.child("price").getValue().toString()),Integer.parseInt(dataSnapshot.child("number").getValue().toString())));

                        listViewAdapter.notifyDataSetChanged();
                        gridViewAdapter.notifyDataSetChanged();
                        //Log.e("firebase",""+ dataSnapshot.child("food1").getValue().toString());
                   /* byte[] decodedString = Base64.decode(dataSnapshot.child("image").getValue().toString(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    ImageView iv=(ImageView)findViewById(R.id.test);
                    iv.setImageBitmap(decodedByte);*/

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


                //Get current view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview

                //Register item lick
                listView.setOnItemClickListener(onItemClick);
                gridView.setOnItemClickListener(onItemClick);


                Button btclose=(Button)findViewById(R.id.close);
                final FrameLayout flt=(FrameLayout)findViewById(R.id.dialog);

                btclose.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        flt.setVisibility(View.GONE);
                    }
                });

                tvtotal=(TextView)findViewById(R.id.total);
                tvnumber=(TextView)findViewById(R.id.number);
                fl=(FrameLayout)findViewById(R.id.border);
                if(number==0)
                {
                    fl.setVisibility(View.GONE);
                    tvtotal.setVisibility(View.GONE);

                }
                tvtotal.setText(""+total+" đ");
                tvnumber.setText(""+number);

                Button btxdh=(Button)findViewById(R.id.btnxemdo);
                btxdh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(),"cham !",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),XemDoHangActivity.class);
                        startActivity(intent);


                    }
                });

                switchView();
                break;
            }
            case 2: {
                namefirebase="food";

                setContentView(R.layout.actionbar_tab_3);

                stubList = (ViewStub) findViewById(R.id.stub_list);
                stubGrid = (ViewStub) findViewById(R.id.stub_grid);

                //Inflate ViewStub before get view
                stubList.inflate();
                stubGrid.inflate();

                listView = (ListView) findViewById(R.id.mylistview);
                gridView = (GridView) findViewById(R.id.mygridview);
                productList = new ArrayList<>();

                listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
                listView.setAdapter(listViewAdapter);
                gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
                gridView.setAdapter(gridViewAdapter);

                //get list of product
                //getProductList();


                productList.clear();
                DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();


                myFirebaseRef.child("food").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        productList.add(new Product(dataSnapshot.child("image").getValue().toString(), dataSnapshot.child("name").getValue().toString(),dataSnapshot.child("des").getValue().toString(),Integer.parseInt(dataSnapshot.child("price").getValue().toString()),Integer.parseInt(dataSnapshot.child("number").getValue().toString())));

                        listViewAdapter.notifyDataSetChanged();
                        gridViewAdapter.notifyDataSetChanged();

                        //Log.e("firebase",""+ dataSnapshot.child("food1").getValue().toString());
                   /* byte[] decodedString = Base64.decode(dataSnapshot.child("image").getValue().toString(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    ImageView iv=(ImageView)findViewById(R.id.test);
                    iv.setImageBitmap(decodedByte);*/

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


                //Get current view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview

                //Register item lick
                listView.setOnItemClickListener(onItemClick);
                gridView.setOnItemClickListener(onItemClick);


                Button btclose=(Button)findViewById(R.id.close);
                final FrameLayout flt=(FrameLayout)findViewById(R.id.dialog);

                btclose.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        flt.setVisibility(View.GONE);
                    }
                });

                tvtotal=(TextView)findViewById(R.id.total);
                tvnumber=(TextView)findViewById(R.id.number);
                fl=(FrameLayout)findViewById(R.id.border);
                if(number==0)
                {
                    fl.setVisibility(View.GONE);
                    tvtotal.setVisibility(View.GONE);

                }
                tvtotal.setText(""+total+" đ");

                tvnumber.setText(""+number);

                Button btxdh=(Button)findViewById(R.id.btnxemdo);
                btxdh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(getApplicationContext(),"cham !",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),XemDoHangActivity.class);
                        startActivity(intent);


                    }
                });
                switchView();
                break;
            }
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public void FirebaseNumber(int position,int value)
    {
        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();
        myFirebaseRef.child(namefirebase).child(namefirebase+(position+1)).child("number").setValue(""+value);
        // Log.e("lod",""+namefirebase);

    }



    public void FirebaseDes(int position)
    {

        DatabaseReference myFirebaseRef = FirebaseDatabase.getInstance().getReference();


        myFirebaseRef.child(namefirebase).child(namefirebase+(position+1)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                SeeOderFoodActivity sf=new SeeOderFoodActivity();
                sf.txname="   "+dataSnapshot.child("name").getValue().toString();
                sf.txdescription="      "+dataSnapshot.child("details").getValue().toString();
                //Log.e("lod","  "+dataSnapshot.child("details").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }
/*
    public void FirebaseComment( int position)
    {

        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://app-f-e5a6e.firebaseio.com");


        myFirebaseRef.child(namefirebase).child(namefirebase+(position+1)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               SeeOderFoodActivity sf=new SeeOderFoodActivity();
                com= dataSnapshot.child("numbercomment").getValue().toString();
                dataSnapshot.child("numbercomment").getRef().setValue(""+(Integer.parseInt(com)+1));
                dataSnapshot.child("comment").child("commet"+com).getRef().setValue("the gioi cua thanh ");



            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
*/
    //Log.e("lod","thanh !"+ com);
        /*SeeOderFoodActivity sf=new SeeOderFoodActivity();
        com=dataSnapshot.child("numbercomment").getValue().toString();
        dataSnapshot.child("comment").child("commet"+com).

                Log.e("lod","thanh !"+ com);

        //myFirebaseRef.child(namefirebase).child(namefirebase+(position+1)).child("comment").child("commet"+i).setValue("ngon hơn nước cống !");
    }
*/

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //Display listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
            stubGrid.setVisibility(View.GONE);
        } else {
            //Hide listview
            stubList.setVisibility(View.GONE);
            //Display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }



    }



    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do any thing when user click to item

            //Toast.makeText(getApplicationContext(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
            Intent in=new Intent(getApplication(),InFo_Food_Activity.class);
            startActivity(in);

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode) {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                } else {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }
                //Switch view
                switchView();
                //Save view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return true;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Display custom title
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle(" Thực đơn");


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