package com.example.yeasangkug.vocabulary;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.yeasangkug.vocabulary.Adapter.Adapter_ViewPager;
import com.example.yeasangkug.vocabulary.Fragment.Fragment_Tab01;
import com.example.yeasangkug.vocabulary.Fragment.Fragment_Tab02;
import com.example.yeasangkug.vocabulary.Fragment.Fragment_Tab03;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Adapter_ViewPager mAdapter;

    private Toolbar mToolbar;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_resource();

        init_setup();

        init_setup_icon();

    }

    // 리소스 로딩
    private void init_resource()
    {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    // 리소스 셋업
    private void init_setup()
    {
        setSupportActionBar(mToolbar);
        mAdapter = new Adapter_ViewPager(getSupportFragmentManager());
        mAdapter.addFragment(new Fragment_Tab01(), "단어 리스트");
        mAdapter.addFragment(new Fragment_Tab02(), "단어 사전");
        mAdapter.addFragment(new Fragment_Tab03(), "단어 입력");
        mViewPager.setAdapter(mAdapter);

        // 반드시 viewPager셋팅 후에 TabLayout에 지정 한다
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void init_setup_icon()
    {
        mTabLayout.getTabAt(0).setIcon(R.drawable.wordlist);
        mTabLayout.getTabAt(1).setIcon(R.drawable.dictionary);
        mTabLayout.getTabAt(2).setIcon(R.drawable.write);
    }

}
