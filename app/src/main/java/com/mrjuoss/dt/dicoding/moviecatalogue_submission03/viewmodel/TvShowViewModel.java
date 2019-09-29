package com.mrjuoss.dt.dicoding.moviecatalogue_submission03.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mrjuoss.dt.dicoding.moviecatalogue_submission03.model.TvShow;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TvShowViewModel extends ViewModel {

    private final String TAG = getClass().getSimpleName();
    private static final String API_KEY = "3ef012749c492463ebf91e83dabe2be7";
    private MutableLiveData<ArrayList<TvShow>> listTvShows = new MutableLiveData<>();

    public void setTvShows(final String tvShows) {
        AsyncHttpClient client = new AsyncHttpClient();

        final ArrayList<TvShow> listItems = new ArrayList<>();

        String url = "https://api.themoviedb.org/3/discover/tv?api_key=" +API_KEY+ "&language=en-US";

        Log.d(TAG, "URL: "+ url);

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray listTvShow = responseObject.getJSONArray("results");

                    Log.d(TAG, " 2. onSuccess: " +result);

                    for (int i = 0; i < listTvShow.length(); i++) {
                        JSONObject tvShowObject = listTvShow.getJSONObject(i);
                        TvShow tvShowItems = new TvShow(tvShowObject);
                        listItems.add(tvShowItems);
                    }
                    listTvShows.postValue(listItems);
                    Log.d(TAG, "onSuccess: "+listItems);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG, "onFailure: "+error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<TvShow>> getTvShows() {
        return listTvShows;
    }
}
