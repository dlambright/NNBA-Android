package com.example.charliebuckets.nnba_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charliebuckets.nnba_android.util.ImageUtility;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by charliebuckets on 8/8/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CellViewHolder> {
    private ArrayList<Game> gameDataSet;
    private Context context;


    public RVAdapter(ArrayList <Game> newGameList, Context c){
        context = c;
        this.gameDataSet = newGameList;
    }

    @Override
    public CellViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gamecard, parent, false);

        return new CellViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CellViewHolder cellViewHolder, int i) {
        final Game tempGame = gameDataSet.get(i);

        // TODO: Find a way to clear context variable so the TodaysGames activity context isnt leaked


        ImageUtility.getTeamLogoObservable(context.getResources(),
                tempGame.homeTeamId,
                ImageUtility.TEAM_LOGO_TODAYS_GAMES_WIDTH,
                ImageUtility.TEAM_LOGO_TODAYS_GAMES_HEIGHT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        cellViewHolder.homeTeam.setImageBitmap(bitmap);
                    }
                })
        ;
        ImageUtility.getTeamLogoObservable(context.getResources(),
                tempGame.awayTeamId,
                ImageUtility.TEAM_LOGO_TODAYS_GAMES_WIDTH,
                ImageUtility.TEAM_LOGO_TODAYS_GAMES_HEIGHT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        cellViewHolder.awayTeam.setImageBitmap(bitmap);
                    }
                });

        cellViewHolder.awayTeamColorView.setColor(Constants.getAwayTeamColor(tempGame.homeTeam, tempGame.awayTeam));
        cellViewHolder.homeTeamColorView.setAlpha(.5f);

        cellViewHolder.homeTeamColorView.setColor(Constants.getHomeTeamColor(tempGame.homeTeam));
        cellViewHolder.awayTeamColorView.setAlpha(.5f);

        cellViewHolder.homeTeamName = tempGame.homeTeam;
        cellViewHolder.awayTeamName = tempGame.awayTeam;

        cellViewHolder.txtHomeTeamScore.setText(tempGame.homeTeamScore);
        cellViewHolder.txtAwayTeamScore.setText(tempGame.awayTeamScore);

    }

    @Override
    public int getItemCount() {
        return gameDataSet == null ? 0 : gameDataSet.size();
    }





    public static class CellViewHolder extends RecyclerView.ViewHolder {
        public ImageView homeTeam;
        public ImageView awayTeam;
        public String homeTeamName;
        public String awayTeamName;
        public HomeTeamBackground homeTeamColorView;
        public AwayTeamBackground awayTeamColorView;
        public TextView txtHomeTeamScore;
        public TextView txtAwayTeamScore;




        public CellViewHolder(View itemView) {
            super(itemView);

            homeTeam = (ImageView)itemView.findViewById(R.id.homeTeamImage);
            awayTeam = (ImageView)itemView.findViewById(R.id.awayTeamImage);
            homeTeamColorView = (HomeTeamBackground)itemView.findViewById(R.id.homeTeamColorView);
            awayTeamColorView = (AwayTeamBackground)itemView.findViewById(R.id.awayTeamColorView);
            txtHomeTeamScore = (TextView)itemView.findViewById(R.id.homeTeamScore);
            txtAwayTeamScore = (TextView)itemView.findViewById(R.id.awayTeamScore);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), CurrentGameActivity.class);
                    i.putExtra("homeTeamName", homeTeamName);
                    i.putExtra("awayTeamName", awayTeamName);
                    v.getContext().startActivity(i);
                }
            });

        }



    }

}
