package com.example.netflix_clone;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieModel {

    private String poster_path;
    private int id;
    private String title;
    private double vote_average;

    private static List<String> listTitle = new ArrayList<>();

    public MovieModel(){}

    public static List<String> getListTitle(){
        return listTitle;
    }

    public void setPoster_path(String posterPath){
        this.poster_path = posterPath;
    }

    public String getPoster_path(){ return this.poster_path; }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){return this.id;}

    public void setTitle(String title){
        this.title = title;
        listTitle.add(title);
    }

    public String getTitle() {return this.title;}

    public void setVote_average(double vote_average){
        this.vote_average = vote_average;
    }

    public double getVote_average() {return this.vote_average;}






}
