package com.example.charliebuckets.nnba_android.util;

/**
 * Created by Dustin on 9/3/15.
 */
public class RecyclerViewGame {

    private String homeTeam;
    private String awayTeam;
    private String homeScore;
    private String awayScore;
    private String time;
    private String gameId;

    public RecyclerViewGame(String newHomeTeamName, String newAwayTeamString, String newHomeTeamScore, String newAwayTeamScore, String newTime, String newGameId){
        this.homeTeam = newHomeTeamName;
        this.awayTeam = newAwayTeamString;
        this.homeScore = newHomeTeamScore;
        this.awayScore = newAwayTeamScore;
        this.time = newTime;
        this.gameId = newGameId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(String awayScore) {
        this.awayScore = awayScore;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }


}
