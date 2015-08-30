package com.example.charliebuckets.nnba_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charliebuckets.nnba_android.util.NetworkUtility;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
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
    private TextView txtChartHeader;

// Chart variables
    LineChartView lineChartView;
    private LineChartData data;

    private int numberOfLines = 2;
    private int maxNumberOfLines = 4;
    private int numberOfPoints;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    private boolean hasAxes = true;
    private boolean hasAxesNames = true;
    private boolean hasLines = true;
    private boolean hasPoints = false;
    private ValueShape shape = ValueShape.CIRCLE;
    private boolean isFilled = false;
    private boolean hasLabels = false;
    private boolean isCubic = false;
    private boolean hasLabelForSelected = false;
    private boolean pointsHaveDifferentColor = false;


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
                            homeTeamStats[homeTeamStats.length - 36].replaceAll("\\s+", ""));
                    txtHomeThreePointFieldGoals.setText(homeTeamStats[homeTeamStats.length - 34].replaceAll("\\s+", "") + "/" +
                            homeTeamStats[homeTeamStats.length - 33].replaceAll("\\s+", ""));
                    txtHomeFreeThrows.setText(homeTeamStats[homeTeamStats.length - 31].replaceAll("\\s+", "") + "/" +
                            homeTeamStats[homeTeamStats.length - 30].replaceAll("\\s+", ""));
                    txtHomeRebounds.setText(homeTeamStats[homeTeamStats.length - 28].replaceAll("\\s+", "") + "/" +
                            homeTeamStats[homeTeamStats.length - 27].replaceAll("\\s+", "") + "/" +
                            homeTeamStats[homeTeamStats.length - 26].replaceAll("\\s+", ""));
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

//        initializeViews();



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

        txtChartHeader = (TextView) findViewById(R.id.txtTableHeader);
//        txtChartHeader.setBackgroundColor(getResources().getColor(R.color.NNBA_Blue));
        lineChartView = (LineChartView) findViewById(R.id.chart);

    }


    //Check this method
    public void onClick (View v){
        TextView tv = (TextView)v;

        String statsCategory = tv.getText().toString();
        txtChartHeader.setText(statsCategory);

        setChartData(getTableValuesFromView(tv));
    }

    private int getTableValuesFromView(View v) {
        switch (v.getId()) {
            case R.id.winPctMiddle:
                return 37; //Check this

            case R.id.scoreMiddle:
                return 0;

            case R.id.fieldGoalsMiddle:
                return 2;

            case R.id.threePointMiddle:
                return 5;

            case R.id.freeThrowsMiddle:
                return 8;

            case R.id.reboundsMiddle:
                return 13;

            case R.id.stealsMiddle:
                return 15;

            case R.id.blocksMiddle:
                return 16;

            case R.id.assistsMiddle:
                return 14;

            case R.id.tspMiddle:
                return 36;
        }
        return -1;
    }

    private ArrayList<PointValue> getIntPointsFromString(int index, String[] string){
        int statsLineLength = 38;
        ArrayList<PointValue> listToReturn = new ArrayList<>();
        int forLoopLength = (string.length/statsLineLength) -1;
        for (int i = 0; i < forLoopLength; i ++){
            listToReturn.add(new PointValue(i, Integer.parseInt(string[index + (statsLineLength * i)].replaceAll("\\s+",""))));
        }
        return listToReturn;
    }

    private ArrayList<PointValue> getFloatPointsFromString(int index, String[] string){
        int statsLineLength = 38;
        ArrayList<PointValue> listToReturn = new ArrayList<>();
        int forLoopLength = (string.length/statsLineLength) -1;

        for (int i = 0; i < forLoopLength; i ++){
            listToReturn.add(new PointValue(i, Float.parseFloat(string[index + (statsLineLength * i)])));
        }
        return listToReturn;
    }

    private void setChartData(int index){
        List<Line> lines = new ArrayList<Line>();
        ArrayList<PointValue> homeValues;
        ArrayList<PointValue> awayValues;

        if (index >35){
            homeValues = getFloatPointsFromString(index, homeTeamStats);
            awayValues = getFloatPointsFromString(index, awayTeamStats);
        }
        else{
            homeValues = getIntPointsFromString(index, homeTeamStats);
            awayValues = getIntPointsFromString(index, awayTeamStats);
        }


        Line homeLine = new Line(homeValues);
        homeLine.setColor(Constants.getHomeTeamColor(homeTeamString));
        homeLine.setShape(shape);
        homeLine.setCubic(isCubic);
        homeLine.setFilled(isFilled);
        homeLine.setHasLabels(hasLabels);
        homeLine.setHasLabelsOnlyForSelected(hasLabelForSelected);
        homeLine.setHasLines(hasLines);
        homeLine.setHasPoints(hasPoints);
        lines.add(homeLine);

        Line awayLine = new Line(awayValues);
        awayLine.setColor(Constants.getAwayTeamColor(homeTeamString, awayTeamString));
        awayLine.setShape(shape);
        awayLine.setCubic(isCubic);
        awayLine.setFilled(isFilled);
        awayLine.setHasLabels(hasLabels);
        awayLine.setHasLabelsOnlyForSelected(hasLabelForSelected);
        awayLine.setHasLines(hasLines);
        awayLine.setHasPoints(hasPoints);
        lines.add(awayLine);




        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisX.setName("Axis X");
                axisY.setName("Axis Y");
            }
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        lineChartView.setLineChartData(data);

    }
}
