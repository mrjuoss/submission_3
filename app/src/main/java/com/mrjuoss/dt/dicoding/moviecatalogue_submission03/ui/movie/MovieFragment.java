package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.movie;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.adapter.MovieAdapter;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model.Movie;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.viewmodel.MovieViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();

    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;
    //private OnFragmentInteractionListener mListener;
    private ProgressBar progressBarMovie;
    private RecyclerView recyclerViewMovie;

    private ArrayList<Movie> mDataMovie = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        progressBarMovie = view.findViewById(R.id.progress_bar_movie);

        recyclerViewMovie = view.findViewById(R.id.recycler_view_movie);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewMovie.setHasFixedSize(true);

        movieAdapter = new MovieAdapter(getContext(), mDataMovie);
        recyclerViewMovie.setAdapter(movieAdapter);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovies().observe(this, getMovie);
        movieViewModel.setMovies("EXTRA_MOVIE");
        movieAdapter.notifyDataSetChanged();

        showLoading(true);
        return view;
    }

    private Observer<ArrayList<Movie>> getMovie = new Observer<ArrayList<Movie>>() {
        @Override
        public void onChanged(ArrayList<Movie> movieList) {
            if (movieList != null) {
                Log.d(TAG, "onChanged !!!");
                movieAdapter.setData(movieList);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBarMovie.setVisibility(View.VISIBLE);
        } else {
            progressBarMovie.setVisibility(View.GONE);
        }
    }


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
