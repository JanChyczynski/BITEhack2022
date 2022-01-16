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
        Product product = new Product(new Date(2022-1900, 2-1, 5));
        product.open(-5);
        assertEquals(-5, product.getDaysToExpire());
        assert (product.isOpened());
    }

    public void testSpoilsToday(){
//        Product product = new Product(new Date());
//        Product product = new Product();
        assertEquals(0,  new Product(new Date()).getDaysToExpire());

        for (int i = -1; i < 3; i++) {
            assertEquals(i,  new Product(new Date(2022-1900, 1-1, 16+i)).getDaysToExpire());
        }

//        System.out.println(product.getDaysToExpire());
    }

    public void testGetDaysToExpire(){
        System.out.println( new Product(new Date(2022-1900, 2-1, 1)).getDaysToExpire());
        System.out.println( new Product(new Date(2022-1900, 1-1, 1)).getDaysToExpire());
    }
}