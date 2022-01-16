package com.example.bitehack2022;

import android.util.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class Request implements Callable {
    private final String domain;
    private final String jsonInput;

    public Request(String domain, String jsonInput, MainActivity mainActivity) {
        this.domain = domain;
        this.jsonInput = jsonInput;
    }

    @Override
    public Object call() throws Exception {
        URL endpoint = new URL(domain);
        HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();

        if (conn.getResponseCode() == 200) {
            InputStream responseBody = conn.getInputStream();
            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
            JsonReader jsonReader = new JsonReader(responseBodyReader);
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String key = jsonReader.nextName();
                if (key.equals("fridgeId")) {
                    return jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.close();
            conn.disconnect();
        } else {
            return null;
        }

        return null;
    }
}
