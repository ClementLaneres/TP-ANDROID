package com.example.cine.model;

import java.io.Serializable;

public class MovieDetails implements Serializable {
    String title;
    CastingShort castingShort;
    Release release;
    Poster poster;
    Trailer trailer;
}
