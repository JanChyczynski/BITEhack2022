package com.example.bitehack2022;

import java.time.LocalDate;

public class Product {
    private String expirationDate;

    public Product(String expirationDate) {
        this.expirationDate = expirationDate;
    }
//    Potential future implementation
//    LocalDate expirationDate;
//
//    public Product(LocalDate expirationDate) {
//        this.expirationDate = expirationDate;
//    }
//
//    public Product(String expirationDate){
//        this(LocalDate.parse(expirationDate));
//    }
}
