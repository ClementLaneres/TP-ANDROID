package com.example.cine.model;

import java.io.Serializable;
import java.util.List;


public class Movie implements Serializable {
    OnShow onShow;
    String display;

    public String getTitle(){
        return onShow.movie.title;
    }
    public String getActors() {
        return onShow.movie.castingShort.actors;
    }
    public String getDirectors() {
        return onShow.movie.castingShort.directors;
    }
    public String getReleaseDate(){
        return onShow.movie.release.releaseDate;
    }
    public String getDisplays(){ return display; }
    public String getPosterURL() { return onShow.movie.poster.href; }
    public String getTrailerURL() {
        if(onShow.movie.trailer != null)
            return onShow.movie.trailer.href;
        else
            return null;
    }

    public String toString(){
        return "(" + getTitle() + "," + getActors() + "," + getDirectors() + "," + getReleaseDate() + "," + getDisplays() + ")";
    }

}
