package com.example.charliebuckets.nnba_android;

import android.graphics.Color;

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
                put("charlottehornets", "hornets");
                put("chicagobulls", "bulls");
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
                    put("newyorkknicks",  Color.rgb( 245 ,  132 ,  38 ));
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
                    put("atlantahawks", Color.rgb(0, 43, 92));
                    put("chicagobulls", Color.rgb(6, 25, 34));
                    put("dallasmavericks", Color.rgb(196, 206, 211));
                    put("detriotpistons", Color.rgb(237, 23, 76));
                    put("goldenstatewarriors", Color.rgb(253, 185, 39));
                    put("houstonrockets", Color.rgb(206, 17, 65));
                    put("losangelesclippers", Color.rgb(237, 23, 76));
                    put("losangeleslakers", Color.rgb(85, 37, 130));
                    put("neworleanspelicans", Color.rgb(227, 24, 55));
                    put("oklahomacitythunder", Color.rgb(240, 81, 51));
                    put("orlandomagic", Color.rgb(196, 206, 211));
                    put("philadelphia76ers", Color.rgb(0, 107, 182));
                    put("portlandtrailblazers", Color.rgb(186, 195, 201));
                    put("torontoraptors", Color.rgb(6, 25, 34));
                    put("utahjazz", Color.rgb(249, 160, 27));
                    put("washingtonwizards", Color.rgb(227, 24, 55));
                }});

    public static int getHomeTeamColor(String homeTeam){
        return primaryColors.get(homeTeam);
   }

    public static int getAwayTeamColor(String homeTeam, String awayTeam){
        int home = primaryColors.get(homeTeam);
        int away = primaryColors.get(awayTeam);

        if (home == away){
            return secondaryColors.get(awayTeam);
        }
        return primaryColors.get(awayTeam);
    }
}
