package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.tv;


import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.adapter.TvShowAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model.TvShow;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.viewmodel.TvShowViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();

    private TvShowAdapter tvShowAdapter;
    private ProgressBar progressBarTvShow;
    private TvShowViewModel tvShowViewModel;
    private RecyclerView recyclerViewTv;
    private ArrayList<TvShow> mDataTvShow = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        progressBarTvShow = view.findViewById(R.id.progress_bar_tv);

        recyclerViewTv = view.findViewById(R.id.recycler_view_tv);
        recyclerViewTv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewTv.setHasFixedSize(true);

        tvShowAdapter = new TvShowAdapter(getContext(), mDataTvShow);
        recyclerViewTv.setAdapter(tvShowAdapter);

        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
        tvShowViewModel.getTvShows().observe(this, getTvShow);
        tvShowViewModel.setTvShows("EXTRA_TV_SHOW");
        tvShowAdapter.notifyDataSetChanged();

        showLoading(true);
        return view;
    }

    private Observer<ArrayList<TvShow>> getTvShow = new Observer<ArrayList<TvShow>>() {
        @Override
        public void onChanged(ArrayList<TvShow> tvShows) {
            if (tvShows != null) {
                Log.d(TAG, "onChanged !!!");
                tvShowAdapter.setDataTvShow(tvShows);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBarTvShow.setVisibility(View.VISIBLE);
        } else {
            progressBarTvShow.setVisibility(View.GONE);
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
