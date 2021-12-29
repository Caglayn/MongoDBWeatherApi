package com.caglayan.mongodb.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApi {
    private static WeatherApi instance;

    private String rootUrl = "http://api.openweathermap.org/data/2.5/weather?";
    private String apiKey = "&appid=246a2bf08c730aed2f8a547f8d85943a";

    private WeatherApi() {
    }

    public static WeatherApi getInstance() {
        if (instance == null)
            instance = new WeatherApi();
        return instance;
    }

    public String getCityWeatherData(String cityName) {
        String url = rootUrl + "q=" + cityName + apiKey;
        String result = "";
        URL obj;
        try {
            obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
