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

    public static Date currentDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public long getDaysToExpire(){
        Date currentDay = currentDay();
        long millisToExpire = expirationDate.getTime() - currentDay.getTime();// + 1000*60*60*24-1;
        long daysToExpire = TimeUnit.DAYS.convert(millisToExpire, TimeUnit.MILLISECONDS);
        if(openedSpoilageDate != null){
            long millisToSpoil = openedSpoilageDate.getTime() - currentDay.getTime();
            long daysToSpoil = TimeUnit.DAYS.convert(millisToSpoil, TimeUnit.MILLISECONDS);
            daysToExpire = Math.min(daysToExpire, daysToSpoil);
        }
        return daysToExpire;
    }

    public String getDaysToExpireString(){
        if (getDaysToExpire()==0){
            return "today!";
        }
        if (getDaysToExpire()==1){
            return "tomorrow";
        }
        return "in "+getDaysToExpire()+" days";
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
//        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay());
        calendar.add(Calendar.DATE, daysToSpoil);
        openedSpoilageDate = calendar.getTime();
    }

    public void close(){
        isOpened = false;
        openedSpoilageDate = null;
    }
}
