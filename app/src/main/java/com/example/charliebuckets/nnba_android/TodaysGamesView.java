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
        String teamList[] = {"atlantahawks", "bostonceltics", "brooklynnets",
                "charlottehornets", "chicagobulls", "clevelandcavaliers", "dallasmavericks",
                "denvernuggets", "detroitpistons", "goldenstatewarriors", "houstonrockets",
                "indianapacers", "losangelesclippers", "losangeleslakers", "memphisgrizzlies",
                "miamiheat", "milwaukeebucks", "minnesotatimberwolves", "neworleanspelicans",
                "newyorkknicks", "oklahomacitythunder", "orlandomagic",   "philadelphia76ers",
                "phoenixsuns", "portlandtrailblazers", "sacramentokings", "sanantoniospurs",
                "torontoraptors",  "utahjazz", "washingtonwizards" };


        //List<Game> whatevs = getDataRestAdapter.getTodaysGames();
        //Log.i("whatves", whatevs);


        //String todaysGamesURL = "http://192.168.1.81/todaysGames";
        //String todaysGamesURL = "http://127.0.0.1/todaysGames";
        //String todaysGamesURL = "https://api.github.com/users/cgudea";



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_games);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
//        rv.setHasFixedSize(true);

        // Look this up, Dustin
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        GetDataRestAdapter.getNnbaApi().getTodaysGames()
                .map(gamesList-> {
                    Log.i("Dustin", "Shiv");
                    for (Game game : gamesList){
                        game.setGameIds();
                    }
                    return gamesList;

                })
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(gamesList -> {
                    RVAdapter adapter = new RVAdapter(gamesList, this);
                    rv.setAdapter(adapter);
                });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todays_games_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
