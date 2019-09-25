package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Movie implements Parcelable {
    private int id;
    private String title;
    private String poster;
    private String backdrop;
    private String overview;
    private String releaseDate;
    private double rating;

    public Movie(JSONObject object) {
        try {
            int id = object.getInt("id");
            String title = object.getString("title");
            String poster = object.getString("poster_path");
            String backdrop = object.getString("backdrop_path");
            String overview = object.getString("overview");
            String releaseDate = object.getString("overview");
            double rating = object.getDouble("vote_average");

            this.id = id;
            this.title = title;
            this.poster = poster;
            this.backdrop = backdrop;
            this.overview = overview;
            this.releaseDate = releaseDate;
            this.rating = rating;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.poster);
        dest.writeString(this.backdrop);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeDouble(this.rating);
    }

    protected Movie(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.poster = in.readString();
        this.backdrop = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.rating = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
