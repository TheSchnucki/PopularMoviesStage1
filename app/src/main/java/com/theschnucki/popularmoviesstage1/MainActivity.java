package com.theschnucki.popularmoviesstage1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.theschnucki.popularmoviesstage1.model.Movie;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieAdapterOnClickHandler {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String API_KEY = BuildConfig.API_KEY;

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;

    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        *Using findViewById to get a reference to the grid RecyclerView
        *allows to set adapter and toggle visibility
        */
        mRecyclerView = (RecyclerView) findViewById(R.id.grid_rv);

        mErrorMessageDisplay = (TextView) findViewById(R.id.error_message_tv);

        //GridLayoutManager supports different number of columns
        int numberOfColumns = 2;
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        // MovieAdapter is responsible for linking the Movie data to the Views that will be displayed
        mMovieAdapter = new MovieAdapter(this);

        //Attach the Adapter to the RecyclerView
        mRecyclerView.setAdapter(mMovieAdapter);

        //Progress bar indicates that Data is loading
        mLoadingIndicator = (ProgressBar) findViewById(R.id.loading_indicator_pb);

        //TODO implement the loadMovieData method
        //Once all of the views are set up, load Movie data
        //loadMovieData;
    }

    @Override
    public void onClick(Movie movie) {
        Context context = this;
    }
}
