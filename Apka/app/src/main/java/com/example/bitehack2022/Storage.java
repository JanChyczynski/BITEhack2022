package com.example.bitehack2022;

import java.util.ArrayList;
import java.util.Date;
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
//        productsCache = new HashSet<>();

        // mock
        productsCache = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Product p = new Product(new Date(122, 1, 16+i), null);
            productsCache.add(p);
        }

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

    public boolean logToFridge(String newAccessToken){
        accessToken = newAccessToken;
        return true;
    }

    public void addProduct(Product product){
        productsCache.add(product); //mocked
    }

    public void removeProduct(Product product){
        productsCache.remove(product); //mocked
    }
}
