package com.example.homepage;

public class WatchModel {
    int imageWatch ;
    String nameWatch ;

    public WatchModel(int imageWatch , String nameWatch) {
        this.imageWatch = imageWatch;
        this.nameWatch = nameWatch;

    }

    public int getImageWatch() {
        return imageWatch;
    }

    public void setImageWatch(int imageWatch) {
        this.imageWatch = imageWatch;
    }

    public String getNameWatch() {
        return nameWatch;
    }

    public void setNameWatch(String nameWatch) {
        this.nameWatch = nameWatch;
    }
}
