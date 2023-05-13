package com.example.homepage;

import java.util.List;

public class Category {
    private  String category ;
    private List<ProductLabel> lists ;

    public Category(String category, List<ProductLabel> lists) {
        this.category = category;
        this.lists = lists;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ProductLabel> getLists() {
        return lists;
    }

    public void setLists(List<ProductLabel> lists) {
        this.lists = lists;
    }
}
