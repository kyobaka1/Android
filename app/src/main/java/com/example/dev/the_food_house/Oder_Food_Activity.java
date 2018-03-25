package com.example.dev.the_food_house;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

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
    private Toolbar mTopToolbar;

    private int min_distance = 100;
    private float downX, downY, upX, upY;

@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.oder_food_activity);



        ActionBar ab = getSupportActionBar();


        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    // set background for action bar
    ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0c2354")));

// set background for action bar tab
    ab.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#B5C0D0")));


    // Three tab to display in actionbar
        ab.addTab(ab.newTab().setText("Nổi bật").setTabListener(this));
        ab.addTab(ab.newTab().setText("Thức Uống").setTabListener(this));
        ab.addTab(ab.newTab().setText("Bánh").setTabListener(this));


        }



    @Override
public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        //Called when a tab is selected
        int nTabSelected = tab.getPosition();

        switch (nTabSelected) {
        case 0: {

            setContentView(R.layout.actionbar_tab_1);

            stubList = (ViewStub) findViewById(R.id.stub_list);
            stubGrid = (ViewStub) findViewById(R.id.stub_grid);

            //Inflate ViewStub before get view

            stubList.inflate();
            stubGrid.inflate();

            listView = (ListView) findViewById(R.id.mylistview);
            gridView = (GridView) findViewById(R.id.mygridview);

            //get list of product
            getProductList();

            //Get current view mode in share reference
            SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
            currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
            //Register item lick
            listView.setOnItemClickListener(onItemClick);
            gridView.setOnItemClickListener(onItemClick);


            switchView();

                break;
        }
        case 1: {

                setContentView(R.layout.actionbar_tab_2);


                stubList = (ViewStub) findViewById(R.id.stub_list);
                stubGrid = (ViewStub) findViewById(R.id.stub_grid);

                //Inflate ViewStub before get view

                stubList.inflate();
                stubGrid.inflate();

                listView = (ListView) findViewById(R.id.mylistview);
                gridView = (GridView) findViewById(R.id.mygridview);

                //get list of product
                getProductList();

                //Get current view mode in share reference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
                //Register item lick
                listView.setOnItemClickListener(onItemClick);

                gridView.setOnItemClickListener(onItemClick);


             switchView();
                break;
        }
        case 2: {


            setContentView(R.layout.actionbar_tab_3);

            stubList = (ViewStub) findViewById(R.id.stub_list);
            stubGrid = (ViewStub) findViewById(R.id.stub_grid);

            //Inflate ViewStub before get view

            stubList.inflate();
            stubGrid.inflate();

            listView = (ListView) findViewById(R.id.mylistview);
            gridView = (GridView) findViewById(R.id.mygridview);

            //get list of product
            getProductList();

            //Get current view mode in share reference
            SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
            currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
            //Register item lick
            listView.setOnItemClickListener(onItemClick);
            gridView.setOnItemClickListener(onItemClick);

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

        public List<Product> getProductList() {
                //pseudo code to get product, replace your code to get real product here

                productList = new ArrayList<>();
                productList.add(new Product(R.drawable.foodmot, "Title 1", "This is description 1",100));
                productList.add(new Product(R.drawable.foodhai, "Title 2", "This is description 2",100));
                productList.add(new Product(R.drawable.foodba, "Title 3", "This is description 3",100));
                productList.add(new Product(R.drawable.foodbon, "Title 4", "This is description 4",100));
                productList.add(new Product(R.drawable.foodnam, "Title 5", "This is description 5",100));
                productList.add(new Product(R.drawable.foodsau, "Title 6", "This is description 6",100));
                productList.add(new Product(R.drawable.foodbay, "Title 7", "This is description 7",100));
                productList.add(new Product(R.drawable.foodtam, "Title 8", "This is description 8",100));
                productList.add(new Product(R.drawable.foodchin, "Title 9", "This is description 9",100));
                productList.add(new Product(R.drawable.foodmuoi, "Title 10", "This is description 10",100));
                productList.add(new Product(R.drawable.foodmuoi, "Title 11", "This is description 11",100));

                return productList;
        }
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
        setAdapters();
    }

    private void setAdapters() {
        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

        AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Do any thing when user click to item


                        Toast.makeText(getApplicationContext(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();

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




}
