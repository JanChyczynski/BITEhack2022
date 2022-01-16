package com.example.bitehack2022;

import static java.util.Objects.isNull;

import android.graphics.Bitmap;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

    public long getDaysToExpire(){
        long millisToExpire = expirationDate.getTime() - new Date().getTime();
        long daysToExpire = TimeUnit.DAYS.convert(millisToExpire, TimeUnit.MILLISECONDS);
        if(openedSpoilageDate != null){
            long millisToSpoil = openedSpoilageDate.getTime() - new Date().getTime();
            long daysToSpoil = TimeUnit.DAYS.convert(millisToSpoil, TimeUnit.MILLISECONDS);
            daysToExpire = Math.min(daysToExpire, daysToSpoil);
        }
        return daysToExpire;
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
