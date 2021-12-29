package com.caglayan.mongodb.controller;

import com.caglayan.mongodb.entity.CurrentWeather;
import com.caglayan.mongodb.utils.WeatherApi;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CityWeatherApiController {
    public CurrentWeather getWeatherObject(String cityName){
        String jsonString = WeatherApi.getInstance().getCityWeatherData(cityName);
        ObjectMapper mapper = new ObjectMapper();
        CurrentWeather currentWeather = null;
        try {
            currentWeather = mapper.readValue(jsonString, CurrentWeather.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return currentWeather;
    }
}
