package com.example.moviefinal3;

import java.util.ArrayList;

public class user implements Observer {
    String email;
    String pass ;

    public user() {

    }
    public user(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    private Subject movie;
    public user(Subject movie){
        this.movie= movie;
        this.movie.registerObserver(this);
    }
    public void Update(ArrayList<movie> movies){
        System.out.print("get new notification");
        for(int i=0; i<movies.size(); i++){
            System.out.print("");
        }
}
}
