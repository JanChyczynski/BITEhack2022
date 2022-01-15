package com.example.bitehack2022;

import java.util.Date;

public class Product {
    private Date expirationDate;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Product(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
