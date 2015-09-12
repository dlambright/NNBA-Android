package com.example.charliebuckets.nnba_android.rest;

import android.util.Log;

import retrofit.RestAdapter;

/**
 * Created by Dustin on 9/6/15.
 */
public class GetDataRestAdapter {
    protected final String TAG = "TodaysGames";
    protected RestAdapter mRestAdapter;
    protected static NnbaApi dataInterface;
    static final String TODAYS_GAMES_URL="http://nnba.ddns.net:11358";
//    static final String TODAYS_GAMES_URL="https://api.github.com/users/dlambright";

    public GetDataRestAdapter() {
        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(TODAYS_GAMES_URL)
                .setErrorHandler(new GetDataErrorHandler())
                .build();
        dataInterface = mRestAdapter.create(NnbaApi.class); // create the interface
        Log.d(TAG, "GetGameData -- created");
    }

    public static NnbaApi getNnbaApi(){
        return dataInterface;
    }

//    public List<Game> getTodaysGames() {
//
//        Log.d(TAG, "Getting today's games");
//        List<Game> toReturn = dataInterface.getTodaysGames();
//        return toReturn;
//    }
}
