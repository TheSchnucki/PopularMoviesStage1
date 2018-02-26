package com.theschnucki.popularmoviesstage1;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.theschnucki.popularmoviesstage1.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>{

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private List<Movie>  mMovieList;

    //An on click Handler to interface with the RecyclerView
    private final MovieAdapterOnClickHandler mClickHandler;

    //TODO modify interface for final use, different data different Type
    public interface MovieAdapterOnClickHandler {
        void onClick (Movie movie);
    }


    //TODO change the constructor to use onClickHandler
    public MovieAdapter(MovieAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    //TODO implement OnClickListener
    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public MovieAdapterViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        //this gets called by the child views on click
        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Movie movie = mMovieList.get(adapterPosition);
            mClickHandler.onClick(movie);
        }

    }

    //this method gets called when new ViewHolder is created
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        return new MovieAdapterViewHolder(view);
    }

    //called by RecyclerView to put Data into ViewHolder
    @Override
    public void onBindViewHolder(MovieAdapterViewHolder movieAdapterViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        if (null == mMovieList) return 0;
        return mMovieList.size();
    }

    public void setMovieList(List<Movie> movieList){
        mMovieList = movieList;
        notifyDataSetChanged();
    }
}
