package com.example.dev.the_food_house;

import android.app.FragmentController;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dev on 3/4/2018.
 */

public class Adapter extends FragmentStatePagerAdapter {
    private String ListTab[] = {"Fragment_Home","Fragment_Food","Fragment_Location","Fragment_Oder", "Dnv_Bao","Dnv_Bao"};
    private Home_Fragment mHomeFragment;
    private Food_Fragment mFoodFragment;
    private Location_Fragment mLocationFragment;
    private Oder_Fragment mOderFragment;
    private Coupon_Fragment mCoupon_Fragment;
    private Bao_Fragment mBao_Fragment;

    public Adapter(FragmentManager fm) {
        super(fm);
        mHomeFragment = new Home_Fragment();
        mFoodFragment = new Food_Fragment();
        mOderFragment = new Oder_Fragment();
        mLocationFragment = new Location_Fragment();
        mCoupon_Fragment = new Coupon_Fragment();
        mBao_Fragment = new Bao_Fragment();
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) return mHomeFragment;
        if (position == 1) return mFoodFragment;
        if (position == 2) return mOderFragment;
        if (position == 3) return mLocationFragment;
        if (position == 4) return mCoupon_Fragment;
        if (position == 5) return mBao_Fragment;
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
