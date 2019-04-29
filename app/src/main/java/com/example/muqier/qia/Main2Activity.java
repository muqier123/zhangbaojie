package com.example.muqier.qia;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.muqier.qia.adapter.FragAdapter;
import com.example.muqier.qia.fragment.BlankFragment;
import com.example.muqier.qia.fragment.BlankFragment2;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment>fragments;
    private FragAdapter fragAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        fragments=new ArrayList<>();

        mTab.addTab(mTab.newTab().setText("最新"));
        mTab.addTab(mTab.newTab().setText("推荐"));

        BlankFragment fragment = new BlankFragment();
        BlankFragment2 fragment2 = new BlankFragment2();

        fragments.add(fragment);
        fragments.add(fragment2);

        fragAdapter = new FragAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(fragAdapter);

       mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               mVp.setCurrentItem(tab.getPosition());
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
       mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));



    }
}
