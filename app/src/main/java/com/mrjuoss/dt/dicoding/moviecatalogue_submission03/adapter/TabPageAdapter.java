package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.movie.MovieFragment;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.tv.TvShowFragment;

public class TabPageAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public TabPageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm, numberOfTabs);
        this.tabCount = numberOfTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new TvShowFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
