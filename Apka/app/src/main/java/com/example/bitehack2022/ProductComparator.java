package com.example.bitehack2022;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getDaysToExpire() < o2.getDaysToExpire()) {
            return -1;
        }
        else if(o1.getDaysToExpire() == o2.getDaysToExpire()){
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
        else{
            return 1;
        }

    }
}