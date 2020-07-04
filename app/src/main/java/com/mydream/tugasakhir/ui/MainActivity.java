package com.mydream.tugasakhir.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.mydream.tugasakhir.menu.Ppolicy;
import com.mydream.tugasakhir.menu.about;
import com.mydream.tugasakhir.menu.contactus;
import com.mydream.tugasakhir.menu.helpsupport;
import com.mydream.tugasakhir.models.Movie;
import com.mydream.tugasakhir.adapters.MovieAdapter;
import com.mydream.tugasakhir.adapters.MovieItemClickListener;
import com.mydream.tugasakhir.R;
import com.mydream.tugasakhir.models.Slide;
import com.mydream.tugasakhir.adapters.SliderPagerAdapter;
import com.mydream.tugasakhir.utils.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstslides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView moviesRV, moviesRVWeek, viewAgain, indoMovie, aktor;
    private MenuItem item;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();
        iniViewAgain();
        iniIndoMovies();
        iniAktor();

    }

    private void iniAktor() {

        MovieAdapter againAdapter = new MovieAdapter(this, DataSource.getAktorMovie(), this);
        aktor.setAdapter(againAdapter);
        aktor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniIndoMovies() {

        MovieAdapter againAdapter = new MovieAdapter(this, DataSource.getIndoMovie(), this);
        indoMovie.setAdapter(againAdapter);
        indoMovie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniViewAgain() {

        MovieAdapter againAdapter = new MovieAdapter(this, DataSource.getViewAgain(), this);
        viewAgain.setAdapter(againAdapter);
        viewAgain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniWeekMovies() {

        MovieAdapter weekMovieAdapter = new MovieAdapter(this, DataSource.getWeekMovies(), this);
        moviesRVWeek.setAdapter(weekMovieAdapter);
        moviesRVWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void iniPopularMovies() {
        //Recyclerview Setup
        // ini data

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        moviesRV.setAdapter(movieAdapter);
        moviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        //prepare a list of slides..
        lstslides = new ArrayList<>();
        lstslides.add(new Slide(R.drawable.jokerslide, "JOKER \n 2019"));
        lstslides.add(new Slide(R.drawable.aladdinslide, "ALADDIN \n 2019"));
        lstslides.add(new Slide(R.drawable.busan, "TRAIN TO BUSAN \n 2017"));
        lstslides.add(new Slide(R.drawable.slide3, "BLACK BIRD \n 2015"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstslides);
        sliderpager.setAdapter(adapter);
        indicator.setupWithViewPager(sliderpager, true);
        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        moviesRV = findViewById(R.id.Rv_movies);
        moviesRVWeek = findViewById(R.id.Rv_movies_week);
        viewAgain = findViewById(R.id.Rv_view_again);
        indoMovie = findViewById(R.id.Rv_indonesia);
        aktor = findViewById(R.id.Rv_aktor);

    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        //here we send movie information to detail activity
        //also we ll create the transition animation between the two activity

        Intent intent = new Intent(this, MovieDetailActivity.class);
        //send movie information to detailActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        // startActivity(intent);

        //create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView, "sharedName");
        startActivity(intent, options.toBundle());

        // i l make a simple test to see if the click works

        Toast.makeText(this, "item clicked : " + movie.getTitle(), Toast.LENGTH_LONG).show();

    }

    public void about(MenuItem item) {
    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem() < lstslides.size() - 1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                    } else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
      //  final MenuItem myActionMenuItem=menu.findItem(R.id.action_search);
       // searchView=(SearchView) myActionMenuItem.getActionView();
       // changeSearchViewTextColor(searchView);
       // ((EditText) searchView.findViewById(androidx.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
       // searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

         //   @Override
          //  public boolean onQueryTextSubmit(String query) {
           //     if (!searchView.isIconified()){
            //        searchView.setIconified(true);
             //   }
              //  myActionMenuItem.expandActionView();
               // return false;
            //}

          //  @Override
           // public boolean onQueryTextChange(String newText) {
            //    return false;
         //   }
       // });
        return  true;
    }
//private  List<Movie> filter(List<Movie> pl,String query)
//{
 //   query=query.toLowerCase();
  //  final List<Movie> filteredModeList=new ArrayList<>();
   // for (Movie model:pl)
   // {
    //    final String text=model.getTitle().toLowerCase();
     //   if (text.startsWith(query))
      //  {
       //     filteredModeList.add(model);
        //}
  //  }
   // return  filteredModeList;
//}
 //   private void changeSearchViewTextColor(View view) {
  //      if (view != null) {
   //         if (view instanceof TextView) {
    //            ((TextView) view).setTextColor(Color.WHITE);
     //           return;
      //      } else if (view instanceof ViewGroup) {
       //         ViewGroup viewGroup = (ViewGroup) view;
        //        for (int i = 0; i < viewGroup.getChildCount(); i++){
         //           changeSearchViewTextColor(viewGroup.getChildAt(i));
          //      }
           // }
//}
 //   }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) {

            Intent intent = new Intent(MainActivity.this, about.class);
            startActivity(intent);
            return false;
        }
        else
        if (id == R.id.privacy_policy) {

            Intent intent = new Intent(MainActivity.this, Ppolicy.class);
            startActivity(intent);
            return false;
        }
        else
        if (id == R.id.help_support) {

            Intent intent = new Intent(MainActivity.this, helpsupport.class);
            startActivity(intent);
            return false;
        }
        else
        if (id == R.id.contact) {

            Intent intent = new Intent(MainActivity.this, contactus.class);
            startActivity(intent);
            return false;
        }

        return  super.onOptionsItemSelected(item);
    }
}

