package com.techsummit.provedorespr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;

import com.astuetz.PagerSlidingTabStrip;
import com.techsummit.provedorespr.fragment.ProviderFragment;
import com.techsummit.provedorespr.fragment.SearchFragment;


public class MainActivity extends ActionBarActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get references of views
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        tabs.setShouldExpand(true);
        //set pager adapter
        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"Provedores", "Buscar"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0: {
                    return ProviderFragment.newInstance();
                }
                case 1: {
                    return SearchFragment.newInstance();
                }
            }
            return null;
        }

    }


}
