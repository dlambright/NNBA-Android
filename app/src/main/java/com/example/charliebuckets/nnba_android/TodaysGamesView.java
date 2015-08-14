package com.example.charliebuckets.nnba_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentNavigableMap;

public class TodaysGamesView extends AppCompatActivity {

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

        ArrayList<Game> todaysGames = new ArrayList<Game>();
        for (int i = 0; i < teamList.length/2; i ++){

            int homeId = Constants.getDrawableFromString(teamList[i*2]);//getResources().getIdentifier("res/drawable/" + teamList[i*2], null, null);
            int awayId = Constants.getDrawableFromString(teamList[(i*2)+1]);//getResources().getIdentifier("res/drawable/" + teamList[i*2]+1, null, null);
            todaysGames.add(new Game(teamList[i*2], teamList[(i*2)+1], "99", "99", homeId, awayId));
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_games);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
//        rv.setHasFixedSize(true);

        // Look this up, Dustin
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(todaysGames, getApplicationContext());
        rv.setAdapter(adapter);


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

    public void goToTodaysGames(View view){
        int a = 0;
    }


}
