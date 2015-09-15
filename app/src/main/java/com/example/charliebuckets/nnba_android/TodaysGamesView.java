package com.example.charliebuckets.nnba_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.charliebuckets.nnba_android.rest.GetDataRestAdapter;
import com.example.charliebuckets.nnba_android.util.NetworkUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;
import rx.android.schedulers.AndroidSchedulers;

public class TodaysGamesView extends AppCompatActivity {

    private GetDataRestAdapter getDataRestAdapter = new GetDataRestAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_games);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
//        rv.setHasFixedSize(true);

        // Look this up, Dustin
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        GetDataRestAdapter.getNnbaApi().getTodaysGames()
                .map(gamesList -> {
                    Log.i("Dustin", "Shiv");
                    for (Game game : gamesList) {
                        game.setGameIds();
                    }
                    return gamesList;

                })
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(gamesList -> {
                    RVAdapter adapter = new RVAdapter(gamesList, this);
                    rv.setAdapter(adapter);
                });

        getSupportActionBar().setTitle("NNBA");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.nnba_logo);

    }

}
