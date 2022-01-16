package com.example.bitehack2022;

import android.graphics.Bitmap;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StorageTest extends TestCase {


    public void testStorage() {
        Storage storage = new Storage();
        storage.registerFridge();

        assert (storage.getProducts().isEmpty());

        int productsNumber = 3;
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productsNumber; i++) {

            Product product = new Product(new Date(2022-1900,12,30));
            products.add(product);
            storage.addProduct(product);
        }
        assertEquals (productsNumber, storage.getProducts().size());


        for(Product product : products){
            storage.removeProduct(product);
            assertFalse(storage.getProducts().contains(product));
        }

        assertTrue(storage.getProducts().isEmpty());
    }

    public void testSortedGetProducts(){
        Storage storage = new Storage();
        for (int i = 0; i < 5; i++) {
            storage.addProduct(new Product(new Date(2022-1900, 3-1, 14-i)));
        }
        System.out.println(Arrays.toString(storage.getProducts().stream().map(Product::getDaysToExpire).toArray()));
//        isSorted
    }
}