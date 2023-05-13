package com.example.homepage;

public class MusicClass {
    private String name ;
    private  int song ;
    public MusicClass(String name , int song) {
        this.name = name;
        this.song = song ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}