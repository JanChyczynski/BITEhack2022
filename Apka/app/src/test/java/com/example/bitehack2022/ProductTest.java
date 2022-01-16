package com.example.bitehack2022;

import junit.framework.TestCase;

import java.util.Date;

public class ProductTest extends TestCase {
    public void testOpenClose(){
        Product product = new Product(new Date());
        assert (product.isOpened() == false);
        product.open(5);
        assert (product.isOpened());
        product.close();
        assert (product.isOpened() == false);
    }
}