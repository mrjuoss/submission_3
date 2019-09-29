package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.ui.tv.TvShowDetailActivity;

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

    public ArrayList<TvShow> getDataTvShow() {
        return mDataTvShow;
    }

    public void setDataTvShow(ArrayList<TvShow> items) {
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
        ImageView imagePosterTv;
        TextView textNameTv, textReleaseTv, textOverviewTv;
        public TvShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePosterTv = itemView.findViewById(R.id.image_poster_tv);
            textNameTv = itemView.findViewById(R.id.text_title_tv);
            textReleaseTv = itemView.findViewById(R.id.text_release_tv);
            textOverviewTv = itemView.findViewById(R.id.text_overview_tv);

            itemView.setOnClickListener(this);
        }

        public void bind(TvShow tvShow) {
            String url_poster_tv = "https://image.tmdb.org/t/p/w185" + tvShow.getPoster();

            textNameTv.setText(tvShow.getName());
            textReleaseTv.setText(tvShow.getFirstAirDate());
            textOverviewTv.setText(tvShow.getOverview());

            Glide.with(itemView.getContext())
                    .load(url_poster_tv)
                    .placeholder(R.color.colorPrimary)
                    .dontAnimate().into(imagePosterTv);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            TvShow tvShow = mDataTvShow.get(position);

            Intent intentDetailTv = new Intent(itemView.getContext(), TvShowDetailActivity.class);
            intentDetailTv.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow);
            itemView.getContext().startActivity(intentDetailTv);
        }
    }
}
