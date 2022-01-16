package com.example.bitehack2022;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class ApiProxy {
    private static String TAG = "ApiProxyTAG";
    private String domain;

    public ApiProxy(String domain) {
        this.domain = domain;
    }

    public String getNewFridgeToken(){
        HttpRequestHandler handler = new HttpRequestHandler();
        try {
            String reply = handler.post("domain"+"/add-fridge", "");

            return reply;
        } catch (Exception e) {
            Log.e(TAG, "error :((((");
            return null;
        }

    }

    public List<Product> getProducts(){
        return new ArrayList<>(); //mocked
    }

    public void putProduct(Product product){

    }

    public void deleteProduct(Product product){

    }
}
