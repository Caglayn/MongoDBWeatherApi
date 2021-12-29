package com.caglayan.mongodb.controller;

import com.caglayan.mongodb.entity.CurrentWeather;
import com.caglayan.mongodb.utils.MongoDBUtil;
import com.caglayan.mongodb.utils.WeatherApi;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.mongodb.client.model.Filters.eq;

import java.util.LinkedList;
import java.util.UUID;

public class CityWeatherApiController {
    public CurrentWeather getWeatherObjectFromAPI(String cityName){
        String jsonString = WeatherApi.getInstance().getCityWeatherData(cityName);
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CurrentWeather currentWeather = null;
        try {
            currentWeather = mapper.readValue(jsonString, CurrentWeather.class);
            currentWeather.setId(UUID.randomUUID().toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return currentWeather;
    }

    public CurrentWeather findOneWeatherObjectFromDBByCityName(String cityName) {
        CurrentWeather weather = MongoDBUtil.getInstance()
                .getCurrentWeatherMongoCollection().find(eq("name", cityName)).first();
        return weather;
    }

    public LinkedList<CurrentWeather> getAllWeathersFromDB(){
        Iterable<CurrentWeather> iterable = MongoDBUtil.getInstance().getCurrentWeatherMongoCollection().find();
        LinkedList<CurrentWeather> weathers = null;
        if (iterable != null){
            weathers = new LinkedList<>();
            iterable.forEach(weathers::add);
        }
        return weathers;
    }
}
