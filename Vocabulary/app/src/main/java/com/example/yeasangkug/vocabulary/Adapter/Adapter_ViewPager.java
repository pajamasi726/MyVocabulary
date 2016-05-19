package com.example.yeasangkug.vocabulary.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yeasangkug.vocabulary.MainActivity;

import java.util.ArrayList;

/**
 * Created by yeasangkug on 2016. 5. 19..
 */
public class Adapter_ViewPager extends FragmentPagerAdapter {

    private final int PAGE = 3;

    ArrayList<Fragment> mList_fragment;
    ArrayList<String>   mList_tabTitle;

    public Adapter_ViewPager(FragmentManager fm) {
        super(fm);
        mList_fragment = new ArrayList<Fragment>(1);
        mList_tabTitle = new ArrayList<String>(1);

    }

    @Override
    public Fragment getItem(int position) {

        return mList_fragment.get(position);
    }

    @Override
    public int getCount() {
        return PAGE;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mList_tabTitle.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        this.mList_fragment.add(fragment);
        this.mList_tabTitle.add(title);
    }
}