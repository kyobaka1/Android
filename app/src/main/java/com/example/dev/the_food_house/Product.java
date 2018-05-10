package com.example.dev.the_food_house;

/**
 * Created by NgocTri on 10/22/2016.
 */

public class Product {
    private String imageId;
    private String title;
    private String description;
    private int price;
    private int number;


    public Product(String imageId, String title, String description, int price,int number) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.price=price;
        this.number=number;
    }

    public String getImageId() {
        return imageId;
    }

    public int getNumber() {
        return number;
    }

    public void setImageId(String imageId) {
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
