package com.example.charliebuckets.nnba_android.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.IntegerRes;
import android.util.Log;

import com.example.charliebuckets.nnba_android.Constants;
import com.example.charliebuckets.nnba_android.Game;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by charliebuckets on 8/19/15.
 */
public class NetworkUtility {

    // parsing
    private static String getGamesFromHtml(String stringURL){

        try {

            URL url = new URL(stringURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream is = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader in =new BufferedReader(new InputStreamReader(is));
            String tmp="";
            StringBuilder sb = new StringBuilder();

            while((tmp=in.readLine())!=null){
                sb.append(tmp);
            }

            urlConnection.disconnect();
            return sb.toString();

        }
        catch(Exception e){
            Log.i("Error", e.toString());
        }

        return null;
    }


    private static Game createGameFromParsedHtml(String[] s){
        return new Game(s[0], s[1], s[2], s[3]);
    }



    public static Observable<Game>htmlObersevableTest(final String stringURL){
        return Observable.defer(() -> Observable.just(getGamesFromHtml(stringURL)))
                .subscribeOn(Schedulers.io())
                .map(o -> o.toString())
                .flatMap(s -> Observable.from(s.split(";")))
                .map(s -> s.split(" "))
                .map(s -> new Game(s[0], s[1], s[2], s[3]))
                ;

    }



    public static Observable<ArrayList<Game>> getTodaysGames(final String urlString) {
//        return Observable.defer(new Func0<Observable<ArrayList<Game>>>() {
//            @Override
//            public Observable<ArrayList<Game>> call() {
//                return Observable.just(getGamesFromHtml(urlString))
//                        .doOnNext(new Action1<Bitmap>() {
//                                      @Override
//                                      public void call(Bitmap bitmap) {
//                                          logo_cache.put(resId, bitmap);
//                                      }
//                                  }
//                        );
//            }
//        });
        return null;
    }


}
