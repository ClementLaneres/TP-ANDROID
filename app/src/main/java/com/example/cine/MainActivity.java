package com.example.cine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.cine.model.Movie;
import com.example.cine.model.Movies;

public class MainActivity extends AppCompatActivity {

    MainActivity _THIS_ = this;
    MovieAdapter mov_adapter;
    Movies movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        APIHelper.getInstance().getCineAPI().getMovies().enqueue(new Callback<Movies>(){
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response){
                if (response.isSuccessful()) {
                    movies = response.body();

                    final RecyclerView list = findViewById(R.id.list);
                    mov_adapter = new MovieAdapter(_THIS_, movies.movieShowtimes);
                    list.setAdapter(mov_adapter);
                    // Set layout manager to position the items
                    list.setLayoutManager(new LinearLayoutManager(_THIS_));
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e("comm", "Failure");
            }
        });

    }
    public void clicked(int position){
        Movie mov = movies.get(position);

        Intent intent = new Intent(this, MovDetails.class);
        intent.putExtra("Movie",mov);

        startActivity(intent);
    }

}
