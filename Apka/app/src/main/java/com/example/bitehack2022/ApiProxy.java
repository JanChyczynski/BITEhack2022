package com.example.bitehack2022;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class ApiProxy {
    private static String TAG = "ApiProxyTAG";
    private String domain;

    public ApiProxy(String domain) {
        this.domain = domain;
    }

    public Future<String> getNewFridgeToken(){
        Log.d(TAG, "");
        HttpRequestHandler handler = new HttpRequestHandler();
        try {
            String reply = handler.post("domain"+"/add-fridge", "");

            return reply;
        } catch (Exception e) {
            Log.e(TAG, "error :((((");
            return null;
        }
    }

    public Future<List<Product>> getProducts(){
        return new Future(ArrayList<>()); //mocked
    }

    public void putProduct(Product product){

    }

    public void deleteProduct(Product product){

    }
}
