package com.example.cine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cine.model.Movie;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class MovDetails extends AppCompatActivity {

    Movie mov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movdetails);

        Movie mov = (Movie)getIntent().getSerializableExtra("Movie");

        TextView title = findViewById(R.id.title);
        title.setText(mov.getTitle());

        TextView directors = findViewById(R.id.directors);
        directors.setText("Directors: " + mov.getDirectors());

        TextView actors = findViewById(R.id.actors);
        actors.setText("Actors: " + mov.getActors());

        TextView relDate = findViewById(R.id.relesase_date);
        relDate.setText("Release Date: " + mov.getReleaseDate());

        TextView displays = findViewById(R.id.displays);
        displays.setText(mov.getDisplays());


        ImageView poster_link = findViewById(R.id.poster_link);
        Picasso.get().load(mov.getPosterURL()).into(poster_link);

        ImageButton poster_play = findViewById(R.id.poster_play);
        if(mov.getTrailerURL() != null) {
            poster_play.setOnClickListener(v -> {

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mov.getTrailerURL()));

                startActivity(i);
            });
        }
        else
        {
            poster_play.setVisibility(View.INVISIBLE);
        }
    }
}
