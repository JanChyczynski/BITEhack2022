package com.example.bitehack2022;

import junit.framework.TestCase;

import java.io.IOException;

public class HttpRequestHandlerTest extends TestCase {

    public void testPost(){
        try {
            System.out.println(HttpRequestHandler.post("http://wilga.pw:9000/get-fridge", "{\"fridgeId\":\"8812dd\"}"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}