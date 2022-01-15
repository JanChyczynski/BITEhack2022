package com.example.bitehack2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {

    private final static String DOMAIN = "https://wilga.pw:9000"; //mocked

    private final ApiProxy apiProxy;
    private String accessToken;

    private Set<Product> productsCache;
//    private List<Product> productsAddQueue;
//    private List<Product> productsRemoveQueue;

    public Storage() {
        productsCache = new HashSet<>();
        apiProxy = new ApiProxy(DOMAIN);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String registerFridge(){
        this.accessToken = apiProxy.getNewFridgeToken();
        return this.accessToken;
    }

    public List<Product> getProducts(){
//        apiProxy.getProducts();

        return new ArrayList<>(productsCache);
    }

    public List<Product> logToFridge(String newAccessToken){
        accessToken = newAccessToken;
        return getProducts();
    }

    public void addProduct(Product product){
        productsCache.add(product); //mocked
    }

    public void removeProduct(Product product){
        productsCache.remove(product); //mocked
    }
}
