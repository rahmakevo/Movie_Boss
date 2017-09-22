package com.example.rahmak.movie_boss;

/**
 * Created by rahmak on 9/22/17.
 */

public class Results {

    private String title;
    private Double vote_average;
    private String poster_path;

    public Results(String title, Double vote_average, String poster_path) {
        this.title = title;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }


}
