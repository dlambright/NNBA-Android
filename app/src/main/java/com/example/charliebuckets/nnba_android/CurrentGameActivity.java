package com.example.charliebuckets.nnba_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charliebuckets.nnba_android.util.NetworkUtility;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;

public class CurrentGameActivity extends AppCompatActivity {
    DecimalFormat df = new DecimalFormat("#.#%");

    private ImageView homeTeamImage;
    private ImageView awayTeamImage;
    private String homeTeamString;
    private String awayTeamString;
    private String[] homeTeamStats;
    private String[] awayTeamStats;

    private TextView txtHomeWinProbability, txtAwayWinProbability;
    private TextView txtHomeScore, txtAwayScore;
    private TextView txtHomeFieldGoals, txtAwayFieldGoals;
    private TextView txtHomeThreePointFieldGoals, txtAwayThreePointFieldGoals;
    private TextView txtHomeFreeThrows, txtAwayFreeThrows;
    private TextView txtHomeRebounds, txtAwayRebounds;
    private TextView txtHomeSteals, txtAwaySteals;
    private TextView txtHomeBlocks, txtAwayBlocks;
    private TextView txtHomeAssists, txtAwayAssists;
    private TextView txtHomeTSP, txtAwayTSP;


    private String baseUrl = "http://192.168.1.81/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game);

        initializeViews();


        NetworkUtility.getTeamStats(baseUrl + homeTeamString)
                .observeOn(AndroidSchedulers.mainThread())
//                .toList()
                .subscribe(statsList -> {
                    homeTeamStats = statsList;
                    txtHomeWinProbability.setText(df.format(Float.parseFloat(homeTeamStats[homeTeamStats.length - 2])));
                    txtHomeScore.setText(homeTeamStats[homeTeamStats.length - 39].replaceAll("\\s+", ""));
                    txtHomeFieldGoals.setText(homeTeamStats[homeTeamStats.length - 37].replaceAll("\\s+", "") + "/" +
                                                homeTeamStats[homeTeamStats.length - 36].replaceAll("\\s+",""));
                    txtHomeThreePointFieldGoals.setText(homeTeamStats[homeTeamStats.length - 34].replaceAll("\\s+", "") + "/" +
                                                homeTeamStats[homeTeamStats.length - 33].replaceAll("\\s+",""));
                    txtHomeFreeThrows.setText(homeTeamStats[homeTeamStats.length - 31].replaceAll("\\s+", "") + "/" +
                                                homeTeamStats[homeTeamStats.length - 30].replaceAll("\\s+",""));
                    txtHomeRebounds.setText(homeTeamStats[homeTeamStats.length - 28].replaceAll("\\s+", "") + "/" +
                                                homeTeamStats[homeTeamStats.length - 27].replaceAll("\\s+", "") + "/" +
                                                homeTeamStats[homeTeamStats.length - 26].replaceAll("\\s+",""));
                    txtHomeSteals.setText(homeTeamStats[homeTeamStats.length - 24].replaceAll("\\s+", ""));
                    txtHomeBlocks.setText(homeTeamStats[homeTeamStats.length - 23].replaceAll("\\s+", ""));
                    txtHomeAssists.setText(homeTeamStats[homeTeamStats.length - 25].replaceAll("\\s+", ""));
                    txtHomeTSP.setText(df.format(Float.parseFloat(homeTeamStats[homeTeamStats.length - 3])));
                });

        NetworkUtility.getTeamStats(baseUrl + awayTeamString)
                .observeOn(AndroidSchedulers.mainThread())
//                .toList()
                .subscribe(statsList -> {
                    awayTeamStats = statsList;
                    txtAwayWinProbability.setText(df.format(Float.parseFloat(awayTeamStats[awayTeamStats.length - 2])));
                    txtAwayScore.setText(awayTeamStats[awayTeamStats.length - 39].replaceAll("\\s+", ""));
                    txtAwayFieldGoals.setText(awayTeamStats[awayTeamStats.length - 37].replaceAll("\\s+", "") + "/" +
                            awayTeamStats[awayTeamStats.length - 36].replaceAll("\\s+",""));
                    txtAwayThreePointFieldGoals.setText(awayTeamStats[awayTeamStats.length - 34].replaceAll("\\s+", "") + "/" +
                            awayTeamStats[awayTeamStats.length - 33].replaceAll("\\s+",""));
                    txtAwayFreeThrows.setText(awayTeamStats[awayTeamStats.length - 31].replaceAll("\\s+", "") + "/" +
                            awayTeamStats[awayTeamStats.length - 30].replaceAll("\\s+",""));
                    txtAwayRebounds.setText(awayTeamStats[awayTeamStats.length - 28].replaceAll("\\s+", "") + "/" +
                            awayTeamStats[awayTeamStats.length - 27].replaceAll("\\s+", "") + "/" +
                            awayTeamStats[awayTeamStats.length - 26].replaceAll("\\s+",""));
                    txtAwaySteals.setText(awayTeamStats[awayTeamStats.length - 24].replaceAll("\\s+", ""));
                    txtAwayBlocks.setText(awayTeamStats[awayTeamStats.length - 23].replaceAll("\\s+", ""));
                    txtAwayAssists.setText(awayTeamStats[awayTeamStats.length - 25].replaceAll("\\s+", ""));
                    txtAwayTSP.setText(df.format(Float.parseFloat(awayTeamStats[awayTeamStats.length - 3])));
                });

        initializeViews();

    }

    private void initializeViews(){
        homeTeamString = getIntent().getStringExtra("homeTeamName");
        awayTeamString = getIntent().getStringExtra("awayTeamName");

        homeTeamImage = (ImageView)findViewById(R.id.homeTeamImage);
        homeTeamImage.setImageResource(Constants.getDrawableFromString(homeTeamString.toLowerCase()));

        awayTeamImage = (ImageView)findViewById(R.id.awayTeamImage);
        awayTeamImage.setImageResource(Constants.getDrawableFromString(awayTeamString.toLowerCase()));

        txtHomeWinProbability = (TextView)findViewById(R.id.homeWinPct);
        txtHomeScore = (TextView)findViewById(R.id.homeScore);
        txtHomeFieldGoals = (TextView)findViewById(R.id.homeFieldGoals);
        txtHomeThreePointFieldGoals = (TextView)findViewById(R.id.homeThreePointFieldGoals);
        txtHomeFreeThrows = (TextView)findViewById(R.id.homefreeThrows);
        txtHomeRebounds = (TextView)findViewById(R.id.homeRebounds);
        txtHomeSteals = (TextView)findViewById(R.id.homeSteals);
        txtHomeBlocks = (TextView)findViewById(R.id.homeBlocks);
        txtHomeAssists = (TextView)findViewById(R.id.homeAssists);
        txtHomeTSP= (TextView)findViewById(R.id.homeTSP);
        txtHomeAssists = (TextView)findViewById(R.id.homeAssists);

        txtAwayWinProbability = (TextView)findViewById(R.id.awayWinPct);
        txtAwayScore = (TextView)findViewById(R.id.awayScore);
        txtAwayFieldGoals = (TextView)findViewById(R.id.awayFieldGoals);
        txtAwayThreePointFieldGoals = (TextView)findViewById(R.id.awayThreePointFieldGoals);
        txtAwayFreeThrows = (TextView)findViewById(R.id.awayFreeThrows);
        txtAwayRebounds = (TextView)findViewById(R.id.awayRebounds);
        txtAwaySteals = (TextView)findViewById(R.id.awaySteals);
        txtAwayBlocks = (TextView)findViewById(R.id.awayBlocks);
        txtAwayAssists = (TextView)findViewById(R.id.awayAssists);
        txtAwayTSP= (TextView)findViewById(R.id.awayTSP);
        txtAwayAssists = (TextView)findViewById(R.id.awayAssists);





    }
}
