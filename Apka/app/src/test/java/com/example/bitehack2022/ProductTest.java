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

    public void testSpoilageDate(){
        Product product = new Product(new Date(2022-1900, 2-1, 1));
        product.open(-5);
        assertEquals(-5, product.getDaysToExpire());
        assert (product.isOpened());
    }

    public void testGetDaysToExpire(){
        System.out.println( new Product(new Date(2022-1900, 2-1, 1)).getDaysToExpire());
        System.out.println( new Product(new Date(2022-1900, 1-1, 1)).getDaysToExpire());
    }
}