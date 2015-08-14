package com.example.charliebuckets.nnba_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class CurrentGameActivity extends AppCompatActivity {
    private ImageView homeTeamImage;
    private ImageView awayTeamImage;
    private String homeTeamString;
    private String awayTeamString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game);
        homeTeamString = getIntent().getStringExtra("homeTeamName");
        awayTeamString = getIntent().getStringExtra("awayTeamName");

        homeTeamImage = (ImageView)findViewById(R.id.homeTeamImage);
        homeTeamImage.setImageResource(Constants.getDrawableFromString(homeTeamString));

        awayTeamImage = (ImageView)findViewById(R.id.awayTeamImage);
        awayTeamImage.setImageResource(Constants.getDrawableFromString(awayTeamString));



    }
}
