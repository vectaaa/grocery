package com.example.groscerry;

import java.io.Serializable;

public class ModelGrocery implements Serializable {

    private int image;
    private String name, days, time, price;
    private int rating;
    private boolean checkbox;



    public ModelGrocery(int image, String name, String days, String time, String price, int rating, boolean checkbox) {
        this.image = image;
        this.name = name;
        this.days = days;
        this.time = time;
        this.price = price;
        this.rating = rating;
        this.checkbox = checkbox;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}
