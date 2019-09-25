package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import org.json.*;public class TvShow implements Parcelable {
    private String name;
    private String firstAirDate;
    private String overview;
    private String poster;

    public TvShow(JSONObject object) {
        try {
            String name = object.getString("name");
            String firstAirDate = object.getString("first_air_date");
            String overview = object.getString("overview");
            String poster = object.getString("poster_path");

            this.name = name;
            this.firstAirDate = firstAirDate;
            this.overview = overview;
            this.poster = poster;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.firstAirDate);
        dest.writeString(this.overview);
        dest.writeString(this.poster);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.name = in.readString();
        this.firstAirDate = in.readString();
        this.overview = in.readString();
        this.poster = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
