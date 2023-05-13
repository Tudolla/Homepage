package com.example.homepage;

public class CartModel {
    private int cartImage;
    private String title;
    private String price ;

    public CartModel(int cartImage, String title, String price) {
        this.cartImage = cartImage;
        this.title = title;
        this.price = price;
    }

    public int getCartImage() {
        return cartImage;
    }

    public void setCartImage(int cartImage) {
        this.cartImage = cartImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
