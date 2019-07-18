package com.trongdeptrai.demorecyclertab.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private ArrayList<String> mTitleList = new ArrayList<>();
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //tiến hành set title cho tab theo position
        return mTitleList.get(position);
    }
    //hàm thêm fragment và title cho tab
    public void addTab(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mTitleList.add(title);
    }
}
