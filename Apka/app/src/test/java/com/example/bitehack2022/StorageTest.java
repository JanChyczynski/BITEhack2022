package com.example.bitehack2022;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class StorageTest extends TestCase {


    public void testStorage() {
        Storage storage = new Storage();
        storage.registerFridge();

        assert (storage.getProducts().isEmpty());

        int productsNumber = 3;
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productsNumber; i++) {
            Product product = new Product();
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
}