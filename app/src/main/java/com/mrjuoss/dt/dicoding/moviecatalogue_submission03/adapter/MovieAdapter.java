package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.R;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final String TAG = this.getClass().getSimpleName();

    private final Context context;
    private final ArrayList<Movie> mData;

    public MovieAdapter(Context context, ArrayList<Movie> moviesList) {
        this.context = context;
        this.mData = moviesList;
    }
    public ArrayList<Movie> getData() {
        return mData;
    }
    public void setData(ArrayList<Movie> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_view_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+mData.size());
        return mData.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPoster;
        TextView textTitle, textRelease;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.image_poster);
            textTitle = itemView.findViewById(R.id.text_title);
            textRelease = itemView.findViewById(R.id.text_release);

            itemView.setOnClickListener(this);
        }


        public void bind(Movie movie) {
            String url_poster = "https://image.tmdb.org/t/p/w185"+ movie.getPoster();

            textTitle.setText(movie.getTitle());
            textRelease.setText(movie.getReleaseDate());

            Glide.with(itemView.getContext())
                 .load(url_poster)
                 .into(imgPoster);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
