package com.example.dev.the_food_house;

import android.app.FragmentController;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dev on 3/4/2018.
 */

public class Adapter extends FragmentStatePagerAdapter {
    private String ListTab[] = {"Fragment_Home","Fragment_Food"};
    private Home_Fragment mHomeFragment;
    private Food_Fragment mFoodFragment;
    public Adapter(FragmentManager fm) {
        super(fm);
        mHomeFragment = new Home_Fragment();
        mFoodFragment = new Food_Fragment();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) return mHomeFragment;
        if (position == 1) return mFoodFragment;
        return null;
    }

    @Override
    public int getCount() {
        return ListTab.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
         return ListTab[position];
    }


}
