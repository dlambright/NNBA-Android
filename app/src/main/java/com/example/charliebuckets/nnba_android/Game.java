package com.example.charliebuckets.nnba_android;

/**
 * Created by charliebuckets on 8/8/15.
 */
public class Game {
    public String homeTeam;
    public String awayTeam;
    public String homeTeamScore;
    public String awayTeamScore;
    public int homeTeamId; //intFix
    public int awayTeamId; //intFix
    public String time;
    public String gameId;



    public Game(String newHomeTeam, String newHomeTeamScore,  String newAwayTeam, String newAwayTeamScore, int newHomeId, int newAwayId){
        homeTeam = newHomeTeam;
        awayTeam = newAwayTeam;
        homeTeamScore = newHomeTeamScore;
        awayTeamScore = newAwayTeamScore;
        homeTeamId = newHomeId;
        awayTeamId = newAwayId;
    }

    public Game(String newHomeTeam, String newHomeTeamScore, String newAwayTeam, String newAwayTeamScore){
        homeTeam = newHomeTeam;
        awayTeam = newAwayTeam;
        homeTeamScore = newHomeTeamScore;
        awayTeamScore = newAwayTeamScore;
        homeTeamId = Constants.getDrawableFromString(newHomeTeam.toLowerCase());
        awayTeamId = Constants.getDrawableFromString(newAwayTeam.toLowerCase());
    }
    public void setGameIds(){
        this.homeTeamId = Constants.getDrawableFromString(this.homeTeam.toLowerCase());
        this.awayTeamId = Constants.getDrawableFromString(this.awayTeam.toLowerCase());
    }

}
