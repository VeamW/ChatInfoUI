package com.workdemo.vinjim.wchat6_0;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<>();
    private String[] mTitles = new String[]{"First Fragment","Second Fragment","Third Fragment","Fourth Fragment"};

    private FragmentPagerAdapter mAdapter;
    private List<ChangeColorIconWithText> mTabIndicators = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOverflowAlways();
      //  getSupportActionBar().setDisplayShowHomeEnabled(false);

        initView();

        initData();

        mViewPager.setAdapter(mAdapter);

        initEvent();


    }

    /**
     * 初始化所有事件
     */
    private void initEvent() {
        mViewPager.setOnPageChangeListener(this);
    }

    private void initData() {
        for (String title : mTitles) {
            TagFragment fragment = new TagFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TagFragment.TITLE, title);
            fragment.setArguments(bundle);
            mTabs.add(fragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }

        };
    }

    private void   initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        ChangeColorIconWithText one = (ChangeColorIconWithText) findViewById(R.id.one);
        ChangeColorIconWithText two = (ChangeColorIconWithText) findViewById(R.id.two);
        ChangeColorIconWithText three = (ChangeColorIconWithText) findViewById(R.id.three);
        ChangeColorIconWithText four = (ChangeColorIconWithText) findViewById(R.id.four);
        mTabIndicators.add(one);
        mTabIndicators.add(two);
        mTabIndicators.add(three);
        mTabIndicators.add(four);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        one.setIconAlpha(1.0f);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void setOverflowAlways(){
        ViewConfiguration config = ViewConfiguration.get(this);
        try {
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKey.setAccessible(true);
            menuKey.setBoolean(config,false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onClick(View v) {
        resetOtherTabs();
        switch (v.getId()) {
            case R.id.one:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.two:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.three:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.four:
                mTabIndicators.get(3).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(3, false);
                break;


        }

    }

    /*(*
   重置其他的tab
     */
    private void resetOtherTabs() {
        for (int i=0;i<mTabIndicators.size();i++) {
            mTabIndicators.get(i).setIconAlpha(0);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            ChangeColorIconWithText left = mTabIndicators.get(position);
            ChangeColorIconWithText right = mTabIndicators.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);

        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
