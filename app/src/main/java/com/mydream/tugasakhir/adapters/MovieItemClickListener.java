package com.mydream.tugasakhir.adapters;

import android.widget.ImageView;

import com.mydream.tugasakhir.models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageView to make the shared animation between the two activity

}
