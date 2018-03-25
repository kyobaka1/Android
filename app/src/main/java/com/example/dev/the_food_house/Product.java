package com.example.dev.the_food_house;

/**
 * Created by NgocTri on 10/22/2016.
 */

public class Product {
    private int imageId;
    private String title;
    private String description;
    private int price;
    private int number=0;


    public Product(int imageId, String title, String description, int price) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.price=price;
    }

    public int getImageId() {
        return imageId;
    }

    public int getNumber() {
        return number;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
