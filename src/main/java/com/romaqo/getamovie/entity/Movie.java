package com.romaqo.getamovie.entity;

import java.util.List;
import lombok.Data;

@Data
public class Movie {
    private int id;
    private boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
