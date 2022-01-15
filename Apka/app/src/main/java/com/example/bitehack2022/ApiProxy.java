package com.example.bitehack2022;

import java.util.ArrayList;
import java.util.List;

public class ApiProxy {
    private String domain;

    public ApiProxy(String domain) {
        this.domain = domain;
    }

    public String getNewFridgeToken(){
        return "mocked";
    }

    public List<Product> getProducts(){
        return new ArrayList<>(); //mocked
    }

    public void putProduct(Product product){

    }

    public void deleteProduct(Product product){

    }
}
