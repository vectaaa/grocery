package com.example.groscerry;

public class ModelCart {

        private int image;
        private String name,  price;
        private boolean isSelected;


    public ModelCart(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isSelected() {
        return isSelected();
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}