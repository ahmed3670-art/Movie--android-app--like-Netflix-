package com.example.moviefinal3;
import java.util.ArrayList;
public class movie implements Subject {
    ArrayList<movie> movies =new ArrayList<movie>() ;
    ArrayList<Observer> observers= new  ArrayList<Observer>() ;
    private String title,studio,descrption,rating,streaminglink,NAME1,Cast;
    private int reso,cover;

    public movie() {
        this.movies = new ArrayList<movie>();
        this.observers= new ArrayList();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){

        int i=observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }
    public void notifyObserver(String msg){
        for(int i=0;i<observers.size();i++){
            Observer observer = (Observer) observers.get(i) ;
            observer.Update(this.movies);

        }
    }


    public String getCast() {
        return Cast;
    }

    public void setCast(String cast) {
        Cast = cast;
    }

    public movie(String title, int reso, int cover, String descrption, String NAME1, String Cast) {
        this.title = title;
        this.reso = reso;
        this.cover = cover;
        this.descrption=descrption;
        this.NAME1=NAME1;
        this.Cast=Cast;


    }
    public movie(String title, String descrption, String NAME1, String Cast) {
        this.title = title;
        this.descrption=descrption;
        this.NAME1=NAME1;
        this.Cast=Cast;


    }


    public String getNMAE1() {
        return NAME1;
    }

    public void setNMAE1(String NMAE1) {
        this.NAME1 = NMAE1;
    }

    public movie(String title, int reso) {
        this.title = title;
        this.reso = reso;
    }

    public movie(String title, String studio, String descrption, String rating, String streaminglink, int thum) {
        this.title = title;
        this.studio = studio;
        this.descrption = descrption;
        this.rating = rating;
        this.streaminglink = streaminglink;
        this.reso = thum;
    }

    public String getTitle() {
        return title;
    }

    public String getStudio() {
        return studio;
    }

    public String getDescrption() {
        return descrption;
    }

    public String getRating() {
        return rating;
    }

    public String getStreaminglink() {
        return streaminglink;
    }

    public int getReso() {
        return reso;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



    public void setReso(int reso) {
        this.reso = reso;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
