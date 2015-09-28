package com.example.charliebuckets.nnba_android;

import android.graphics.Color;
import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by charliebuckets on 8/12/15.
 */
public class Constants {


    private static final Map<String, String> teamNameTable = Collections.unmodifiableMap(
            new HashMap<String, String>() {{
                put("atlantahawks","Hawks");
                put("bostonceltics","Celtics");
                put("brooklynnets", "Nets");
                put("charlottehornets", "Hornets");
                put("chicagobulls", "Bulls");
                put("clevelandcavaliers", "Cavaliers");
                put("dallasmavericks", "Mavericks");
                put("denvernuggets", "Nuggets");
                put("detroitpistons", "Pistons");
                put("goldenstatewarriors", "Warriors");
                put("houstonrockets", "Rockets");
                put("indianapacers", "Pacers");
                put("losangelesclippers", "Clippers");
                put("losangeleslakers", "Lakers");
                put("memphisgrizzlies", "Grizzlies");
                put("miamiheat", "Heat");
                put("milwaukeebucks", "Bucks");
                put("minnesotatimberwolves", "Timberwolves");
                put("neworleanspelicans", "Pelicans");
                put("newyorkknicks", "Knicks");
                put("oklahomacitythunder", "Thunder");
                put("orlandomagic", "Magic");
                put("philadelphia76ers", "76ers");
                put("phoenixsuns", "Suns");
                put("portlandtrailblazers", "Trail Blazers");
                put("sacramentokings", "Kings");
                put("sanantoniospurs", "Spurs");
                put("torontoraptors", "Raptors");
                put("utahjazz", "Jazz");
                put("washingtonwizards", "Wizards");
            }});
    public static String getTeamNameFromFullName(String fullName){
        return teamNameTable.get(fullName);
    }

    public static final Map<String, Integer> primaryColors = Collections.unmodifiableMap(
            new HashMap<String, Integer>() {
                {
                    put("atlantahawks", Color.rgb(225, 58, 62));
                    put("bostonceltics",  Color.rgb( 0 ,  131 ,  72));
                    put("brooklynnets" ,  Color.rgb( 6 ,  25 , 34));
                    put("charlottehornets",  Color.rgb( 29 ,  17 ,  96));
                    put("chicagobulls",  Color.rgb( 206 ,  17 ,  65 ));
                    put("clevelandcavaliers",  Color.rgb( 134 ,  0 ,  56 ));
                    put("dallasmavericks",  Color.rgb( 0 ,  125 ,  197 ));
                    put("denvernuggets",  Color.rgb( 77 ,  144 ,  205 ));
                    put("detroitpistons",  Color.rgb( 237 ,  23 ,  76 ));
                    put("goldenstatewarriors",  Color.rgb( 253 ,  185 ,  39 ));
                    put("houstonrockets",  Color.rgb( 206 ,  17 , 65 ));
                    put("indianapacers",  Color.rgb( 255 , 198 ,  51 ));
                    put("losangelesclippers",  Color.rgb( 237 ,  23 ,  76 ));
                    put("losangeleslakers",  Color.rgb( 253 ,  185 ,  39 ));
                    put("memphisgrizzlies",  Color.rgb(15 ,  88 ,  108 ));
                    put("miamiheat",  Color.rgb( 152 ,  0 ,  46 ));
                    put("milwaukeebucks",  Color.rgb( 0 ,  71 ,  27 ));
                    put("minnesotatimberwolves",  Color.rgb( 0 , 80 ,  131 ));
                    put("neworleanspelicans",  Color.rgb( 0 ,  43 ,  92 ));
                    put("newyorkknicks",  Color.rgb( 0, 107, 182 ));
                    put("oklahomacitythunder",  Color.rgb( 0 , 125 ,  197 ));
                    put("orlandomagic"  ,  Color.rgb(0 , 125 , 197 ));
                    put("philadelphia76ers",  Color.rgb( 237 ,  23 ,  76  ));
                    put("phoenixsuns",  Color.rgb( 229 ,  96 ,  32  ));
                    put("portlandtrailblazers",  Color.rgb( 225 , 58 ,  62 ));
                    put("sacramentokings",  Color.rgb(114 ,  76 ,  159 ));
                    put("sanantoniospurs",  Color.rgb(186 , 195 ,  201 ));
                    put("torontoraptors",  Color.rgb(206 ,  17 ,  65));
                    put("utahjazz"   ,  Color.rgb( 0 ,  43 ,  92));
                    put("washingtonwizards",  Color.rgb( 0 ,  43 ,  92));
                }});


    public static final Map<String, Integer> secondaryColors = Collections.unmodifiableMap(
            new HashMap<String, Integer>() {
                {
                    put("atlantahawks", Color.rgb(196, 214, 0));
                    put("bostonceltics",  Color.rgb(187, 151, 83));
                    put("brooklynnets" ,  Color.rgb(186 , 195 ,  201));
                    put("charlottehornets",  Color.rgb(0, 140, 168));
                    put("chicagobulls", Color.rgb(6, 25, 34));
                    put("clevelandcavaliers",  Color.rgb(253, 187, 48));
                    put("dallasmavericks", Color.rgb(196, 206, 211));
                    put("denvernuggets",  Color.rgb(253, 185, 39));
                    put("detriotpistons", Color.rgb(0, 107, 182));
                    put("goldenstatewarriors", Color.rgb(0, 107, 182));
                    put("houstonrockets", Color.rgb(196, 206, 211));
                    put("indianapacers",  Color.rgb(0, 39, 93));
                    put("losangelesclippers", Color.rgb(0, 107, 182));
                    put("losangeleslakers", Color.rgb(85, 37, 130));
                    put("memphisgrizzlies",  Color.rgb(115, 153, 198));
                    put("miamiheat",  Color.rgb(249, 160, 27));
                    put("milwaukeebucks",  Color.rgb(6, 25, 34));
                    put("minnesotatimberwolves",  Color.rgb(0, 169, 79));
                    put("neworleanspelicans", Color.rgb(227, 24, 55));
                    put("newyorkknicks",  Color.rgb( 245 ,  132 ,  38 ));
                    put("oklahomacitythunder", Color.rgb(240, 81, 51));
                    put("orlandomagic", Color.rgb(196, 206, 211));
                    put("phoenixsuns",  Color.rgb(29, 17, 96));
                    put("philadelphia76ers", Color.rgb(0, 107, 182));
                    put("portlandtrailblazers", Color.rgb(186, 195, 201));
                    put("sacramentokings",  Color.rgb(142, 144, 144));
                    put("sanantoniospurs",  Color.rgb(6, 25, 34 ));
                    put("torontoraptors", Color.rgb(6, 25, 34));
                    put("utahjazz", Color.rgb(0, 71, 27));
                    put("washingtonwizards", Color.rgb(227, 24, 55));
                }});

    public static int getHomeTeamColor(String homeTeam){
        return primaryColors.get(homeTeam.toLowerCase());
   }

    public static int getAwayTeamColor(String homeTeam, String awayTeam){

        int home = primaryColors.get(homeTeam.toLowerCase());
        int away = primaryColors.get(awayTeam.toLowerCase());
        

        if(getDistanceFromColors(home, away) < 80){
            return secondaryColors.get(awayTeam.toLowerCase());
        }

        return primaryColors.get(awayTeam.toLowerCase());
    }

    public static double getDistanceFromColors(int homeTeamInt, int awayTeamInt){
        int homeBlue = (homeTeamInt)&0xFF;
        int homeGreen = (homeTeamInt>>8)&0xFF;
        int homeRed = (homeTeamInt>>16)&0xFF;

        int awayBlue = (awayTeamInt)&0xFF;
        int awayGreen = (awayTeamInt>>8)&0xFF;
        int awayRed = (awayTeamInt>>16)&0xFF;

        return  Math.sqrt((Math.pow((homeBlue - awayBlue), 2) + Math.pow((homeGreen - awayGreen), 2) + Math.pow((homeRed - awayRed), 2)));

    }

    public static int getDrawableFromString(String teamName){
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

            case "newyorkknicks":
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
