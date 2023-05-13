package com.example.homepage;

public class ProductLabel {
    private int resoureImage ;
    private String name;

    public ProductLabel(int resoureImage, String name) {
        this.resoureImage = resoureImage;
        this.name = name;
    }

    public int getResoureImage() {
        return resoureImage;
    }

    public void setResoureImage(int resoureImage) {
        this.resoureImage = resoureImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
