package com.example.bitehack2022;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {

    //    private final static String DOMAIN = "https://wilga.pw:9000"; //mocked
    private final static String DOMAIN = "http:192.168.3.56:9000";
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

    public String registerFridge() {
        this.accessToken = apiProxy.getNewFridgeToken();
        return this.accessToken;
    }

    public List<Product> getProducts() {
//        apiProxy.getProducts();
        ArrayList<Product> products = new ArrayList<>(productsCache);
        Collections.sort(products, new ProductComparator());
//        Collections.sort(products, Comparator.comparing(Product::getDaysToExpire).thenComparing(Product::hashCode)));
//        products.sort(Comparator.comparing(Product::getDaysToExpire).thenComparing(Product::hashCode));
        return products;
    }

    public boolean logToFridge(String newAccessToken) {
        accessToken = newAccessToken;
        return true;
    }

    public void loadMockProducts(Context c) {

        File root = Environment.getExternalStorageDirectory();
        Log.i("DEBUGTAG", root.toString());

        for (int i = 0; i< 4; i++) {
            Bitmap bmp = null;
            Date date = new Date(122, 1, 15+2*i);
            Product product = new Product(date, bmp);
            addProduct(product);
        }

    }

    public void addProduct(Product product) {
        productsCache.add(product); //mocked
    }

    public void removeProduct(Product product) {
        productsCache.remove(product); //mocked
    }
}
