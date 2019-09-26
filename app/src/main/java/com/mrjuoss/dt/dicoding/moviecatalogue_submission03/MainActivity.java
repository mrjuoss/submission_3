package com.mrjuoss.dt.dicoding.moviecatalogue_submission03;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.adapter.TabPageAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.movie.MovieFragment;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.tv.TvShowFragment;

public class MainActivity extends AppCompatActivity implements MovieFragment.OnFragmentInteractionListener, TvShowFragment.OnFragmentInteractionListener {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        configureTabLayout();

    }


    private void configureTabLayout() {
        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        final ViewPager viewPager = findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.tab_movie)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_tv)));

        final PagerAdapter adapter = new TabPageAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount()
        );

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d(TAG, "onTabSelected !!!");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}