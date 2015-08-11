package com.example.charliebuckets.nnba_android;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by charliebuckets on 8/8/15.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CellViewHolder> {
    private ArrayList<Game> gameDataSet;

    @Override
    public CellViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gamecard, parent, false);

        //set the view's layout paddings, margins blah blah blah

        return new CellViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CellViewHolder cellViewHolder, int i) {
        Game tempGame = gameDataSet.get(i);

//        int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);



        cellViewHolder.homeTeam.setImageResource(tempGame.homeTeamId);

        cellViewHolder.awayTeam.setImageResource(tempGame.awayTeamId);

    }

    @Override
    public int getItemCount() {
        return gameDataSet == null ? 0 : gameDataSet.size();
    }

    public RVAdapter(ArrayList <Game> newGameList){
        this.gameDataSet = newGameList;
    }
    public static class CellViewHolder extends RecyclerView.ViewHolder {
        public ImageView homeTeam;
        public ImageView awayTeam;

        public CellViewHolder(View itemView) {
            super(itemView);

            homeTeam = (ImageView)itemView.findViewById(R.id.homeTeamImage);
            awayTeam = (ImageView)itemView.findViewById(R.id.awayTeamImage);


        }
    }
}