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
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model.TvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> {

    private final String TAG = getClass().getSimpleName();
    private final Context context;
    private final ArrayList<TvShow> mDataTvShow;
    //private ArrayList<TvShow> mDataTvShow = new ArrayList<>();

    public TvShowAdapter(Context context, ArrayList<TvShow> mDataTvShow) {
        this.context = context;
        this.mDataTvShow = mDataTvShow;
    }

    public void setmDataTvShow(ArrayList<TvShow> items) {
        mDataTvShow.clear();
        mDataTvShow.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TvShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_tv, parent, false);
        return new TvShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowViewHolder holder, int position) {
        holder.bind(mDataTvShow.get(position));
        Log.d(TAG, "onBindViewHolderTvShow: "+mDataTvShow.get(position));
    }

    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount TV Show: "+mDataTvShow.size());
        return mDataTvShow.size();
    }

    public class TvShowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagePoster;
        TextView textName, textFirstAirDate, textOverview;
        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePoster = itemView.findViewById(R.id.image_poster_tv);
            textName = itemView.findViewById(R.id.text_title_tv);
            textFirstAirDate = itemView.findViewById(R.id.text_release_tv);
            textOverview = itemView.findViewById(R.id.text_overview_tv);

            itemView.setOnClickListener(this);
        }

        public void bind(TvShow tvShow) {
            String url_poster = "https://image.tmdb.org/t/p/w185" + tvShow.getPoster();

            textName.setText(tvShow.getName());
            textFirstAirDate.setText(tvShow.getFirstAirDate());
            textOverview.setText(tvShow.getOverview());

            Glide.with(itemView.getContext()).load(url_poster).placeholder(R.color.colorPrimary).dontAnimate().into(imagePoster);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            TvShow tvShow = mDataTvShow.get(position);
            tvShow.setName(tvShow.getName());
            tvShow.setOverview(tvShow.getOverview());

        }
    }
}
