package com.example.charliebuckets.nnba_android.rest;

import com.example.charliebuckets.nnba_android.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Dustin on 9/5/15.
 */
public interface NnbaApi {

    @GET("/todaysGames")
    Observable<ArrayList<Game>> getTodaysGames();
}
