package com.example.charliebuckets.nnba_android;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class TodaysGamesView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String teamList[] = {"atlantahawks", "bostonceltics", "brooklynnets",
                "charlottehornets", "chicagobulls", "clevelandcavaliers", "dallasmavericks",
                "denvernuggets", "detroitpistons", "goldenstatewarriors", "houstonrockets",
                "indianapacers", "losangelesclippers", "losangeleslakers", "memphisgrizzlies",
                "miamiheat", "milwaukeebucks", "minnesotatimberwolves", "neworleanspelicans",
                "newyorkknicks", "oklahomacitythunder", "orlandomagic", "philadelphia76ers",
                "phoenixsuns", "portlandtrailblazers", "sacramentokings", "sanantoniospurs",
                "torontoraptors", "utahjazz", "washingtonwizards"};

        ArrayList<Game> todaysGames = new ArrayList<Game>();
        for (int i = 0; i < teamList.length/2; i ++){

            int homeId = getDrawableFromString(teamList[i*2]);//getResources().getIdentifier("res/drawable/" + teamList[i*2], null, null);
            int awayId = getDrawableFromString(teamList[(i*2)+1]);//getResources().getIdentifier("res/drawable/" + teamList[i*2]+1, null, null);
            todaysGames.add(new Game(teamList[i*2], teamList[(i*2)+1], "99", "99", homeId, awayId));
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_games);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(todaysGames);
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

    public int getDrawableFromString(String teamName){
        switch (teamName){
            case "atlantahawks":
                return R.drawable.atlantahawks;

            case "bostonceltics":
                return R.drawable.bostonceltics;

            case "brooklynnets":
                return R.drawable.brooklynnets;

            case "charlottehornets":
                return R.drawable.charlottehornets;

            case "chicagobulls":
                return R.drawable.chicagobulls;

            case "clevelandcavaliers":
                return R.drawable.clevelandcavaliers;

            case "dallasmavericks":
                return R.drawable.dallasmavericks;

            case "denvernuggets":
                return R.drawable.denvernuggets;

            case "detroitpistons":
                return R.drawable.detroitpistons;

            case "goldenstatewarriors":
                return R.drawable.goldenstatewarriors;

            case "houstonrockets":
                return R.drawable.houstonrockets;

            case "indianapacers":
                return R.drawable.indianapacers;

            case "losangelesclippers":
                return R.drawable.losangelesclippers;

            case "losangeleslakers":
                return R.drawable.losangeleslakers;

            case "memphisgrizzlies":
                return R.drawable.memphisgrizzlies;

            case "miamiheat":
                return R.drawable.miamiheat;

            case "milwaukeebucks":
                return R.drawable.milwaukeebucks;

            case "minnesotatimberwolves":
                return R.drawable.minnesotatimberwolves;

            case "neworleanspelicans":
                return R.drawable.neworleanspelicans;

            case"newyorkknicks":
                return R.drawable.newyorkknicks;

            case "oklahomacitythunder":
                return R.drawable.oklahomacitythunder;

            case "orlandomagic":
                return R.drawable.orlandomagic;

            case "philadelphia76ers":
                return R.drawable.philadelphia76ers;

            case "phoenixsuns":
                return R.drawable.phoenixsuns;

            case "portlandtrailblazers":
                return R.drawable.portlandtrailblazers;

            case "sacramentokings":
                return R.drawable.sacramentokings;

            case "sanantoniospurs":
                return R.drawable.sanantoniospurs;

            case "torontoraptors":
                return R.drawable.torontoraptors;

            case "utahjazz":
                return R.drawable.utahjazz;

            case "washingtonwizards":
                return R.drawable.washingtonwizards;

            default:
                return 200;

        }

    }
}
