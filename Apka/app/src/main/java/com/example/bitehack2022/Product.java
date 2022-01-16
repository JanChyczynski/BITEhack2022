package com.example.bitehack2022;

import android.graphics.Bitmap;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class Product {
    private Date expirationDate;
    private Date openedSpoilageDate;
    private Bitmap bitmap;
    private boolean isOpened;

    public Product(Date expirationDate) {
        this.expirationDate = expirationDate;
        isOpened = false;
    }

    public Product(Date expirationDate, Bitmap bitmap) {
        this(expirationDate);
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

    public boolean isOpened() {
        return isOpened;
    }

    public void open(int daysToSpoil){
        isOpened = true;
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, daysToSpoil);
        openedSpoilageDate = calendar.getTime();
    }

    public void close(){
        isOpened = false;
        openedSpoilageDate = null;
    }
}
