package com.tino.rangeseekbar.demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tino.rangeseekbar.demo.fragments.BaseFragment;
import com.tino.rangeseekbar.demo.fragments.RangeSeekBarFragment;
import com.tino.rangeseekbar.demo.fragments.SingleSeekBarFragment;
import com.tino.rangeseekbar.demo.fragments.StepsSeekBarFragment;
import com.tino.rangeseekbar.demo.fragments.VerticalSeekBarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String[] types = new String[]{"SINGLE", "RANGE", "STEP", "VERTICAL"};

    List<BaseFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragments.clear();
        fragments.add(new RangeSeekBarFragment());
        fragments.add(new SingleSeekBarFragment());
        fragments.add(new StepsSeekBarFragment());
        fragments.add(new VerticalSeekBarFragment());

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.layout_tab);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        for (String s : types) {
            tabLayout.newTab().setText(s);
        }
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return types.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return types[position];
        }
    }

}