package com.example.lab5.model;

public class Product {

    String mId;
    String mName;
    Double mPrice;
    int mImage;

    public Product(String mId, String mName, Double mPrice) {
        this.mId = mId;
        this.mName = mName;
        this.mPrice = mPrice;
    }

    public Product(String mName, Double mPrice) {
        this.mName = mName;
        this.mPrice = mPrice;
    }

    public Product() {

    }


    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Double getmPrice() {
        return mPrice;
    }

    public void setmPrice(Double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
