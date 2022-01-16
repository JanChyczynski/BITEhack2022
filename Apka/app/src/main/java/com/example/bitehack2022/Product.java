package com.example.bitehack2022;

import android.graphics.Bitmap;

import java.util.Date;

public class Product {
    private Date expirationDate;
    private Bitmap bitmap;

    public Product(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Product(Date expirationDate, Bitmap bitmap) {
        this.expirationDate = expirationDate;
        this.bitmap = bitmap;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
