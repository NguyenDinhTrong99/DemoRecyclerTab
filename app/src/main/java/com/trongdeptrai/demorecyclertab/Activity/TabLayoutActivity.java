package com.trongdeptrai.demorecyclertab.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.trongdeptrai.demorecyclertab.Adapter.MyViewPagerAdapter;
import com.trongdeptrai.demorecyclertab.Fragment.PageOneFragment;
import com.trongdeptrai.demorecyclertab.Fragment.PageThreeFragment;
import com.trongdeptrai.demorecyclertab.Fragment.PageTwoFragment;
import com.trongdeptrai.demorecyclertab.R;

import java.util.Objects;

public class TabLayoutActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyViewPagerAdapter mAdapter;
    private int [] tabIcons = {
                            R.drawable.tab_one, R.drawable.tab_two,
                            R.drawable.tab_three, R.drawable.tab_four,
                            R.drawable.tab_five
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        initView();
        setUpViewPager();
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewpager_MyViewPager);
        mTabLayout = findViewById(R.id.tablayout_MyTab);
    }

    private void setUpViewPager() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        addTabs();
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        addIcons();
    }
    private void addTabs() {
        mAdapter.addTab(new PageOneFragment(), "One");
        mAdapter.addTab(new PageTwoFragment(), "Two");
        mAdapter.addTab(new PageThreeFragment(), "Three");
        mAdapter.addTab(new PageOneFragment(), "Four");
        mAdapter.addTab(new PageTwoFragment(), "Fire");
    }
    private void addIcons() {
        for(int i = 0; i < 5; i ++){
            Objects.requireNonNull(mTabLayout.getTabAt(i)).setIcon(tabIcons[i]);
        }
    }


}
