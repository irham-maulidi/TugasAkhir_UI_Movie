package com.mydream.tugasakhir.utils;

import com.mydream.tugasakhir.R;
import com.mydream.tugasakhir.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies(){
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("NightmareSide", R.drawable.mv_image,R.drawable.hororcover));
        lstMovies.add(new Movie("Fast and Forius",R.drawable.mv_image1,R.drawable.hororcover));
        lstMovies.add(new Movie("This Friday",R.drawable.mv_image2,R.drawable.hororcover));
        lstMovies.add(new Movie("Free Guy",R.drawable.mv_image4,R.drawable.hororcover));
        lstMovies.add(new Movie("Gost Writer",R.drawable.mv_image3,R.drawable.hororcover));

        return lstMovies;
    }

    public static List<Movie> getWeekMovies (){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("The Kid King",R.drawable.thekidking,R.drawable.hororcover));
        lstMovies.add(new Movie("The Withcer",R.drawable.thewitcher,R.drawable.hororcover));
        lstMovies.add(new Movie("Aladdin",R.drawable.aladdin,R.drawable.hororcover));
        lstMovies.add(new Movie("Gost Writer", R.drawable.mv_image4,R.drawable.hororcover));
        lstMovies.add(new Movie("NightmareSide",R.drawable.mv_image,R.drawable.hororcover));
        lstMovies.add(new Movie("FREE GUY",R.drawable.mv_image3,R.drawable.hororcover));
        lstMovies.add(new Movie("NightmareSide", R.drawable.mv_image,R.drawable.hororcover));
        lstMovies.add(new Movie("Us",R.drawable.mv_image1,R.drawable.hororcover));

        return lstMovies;

    }

    public static List<Movie> getViewAgain (){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Book Smart",R.drawable.booksmart,R.drawable.hororcover));
        lstMovies.add(new Movie("Hellboy",R.drawable.hellboy,R.drawable.hororcover));
        lstMovies.add(new Movie("FREE GUY",R.drawable.mv_image3,R.drawable.hororcover));
        lstMovies.add(new Movie("NightmareSide", R.drawable.mv_image,R.drawable.hororcover));
        lstMovies.add(new Movie("Us",R.drawable.mv_image1,R.drawable.hororcover));
        lstMovies.add(new Movie("The Kid King",R.drawable.thekidking,R.drawable.hororcover));
        lstMovies.add(new Movie("The Withcer",R.drawable.thewitcher,R.drawable.hororcover));
        lstMovies.add(new Movie("Aladdin",R.drawable.aladdin,R.drawable.hororcover));

        return lstMovies;

    }

    public static List<Movie> getIndoMovie (){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("The Raid",R.drawable.theraid,R.drawable.hororcover));
        lstMovies.add(new Movie("Sesuai Aplikasi",R.drawable.sesuaiaplikasi,R.drawable.hororcover));
        lstMovies.add(new Movie("Sang Pemimpi",R.drawable.sangpemimpi,R.drawable.hororcover));
        lstMovies.add(new Movie("Kabayan Milyuner", R.drawable.mv_image4,R.drawable.hororcover));
        lstMovies.add(new Movie("How to Train your Dragon",R.drawable.traindragon,R.drawable.hororcover));

        return lstMovies;

    }
    public static List<Movie> getAktorMovie (){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Joe Taslim",R.drawable.aktor,R.drawable.hororcover));
        lstMovies.add(new Movie("Iko Uwais",R.drawable.aktor3,R.drawable.hororcover));
        lstMovies.add(new Movie("Yayan Ruhian",R.drawable.aktor1,R.drawable.hororcover));
        lstMovies.add(new Movie("Arif Rahman", R.drawable.aktor,R.drawable.hororcover));

        return lstMovies;

    }
}
