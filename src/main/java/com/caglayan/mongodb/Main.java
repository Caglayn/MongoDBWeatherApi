package com.caglayan.mongodb;

import com.caglayan.mongodb.controller.CityWeatherApiController;
import com.caglayan.mongodb.utils.MongoDBUtil;

public class Main {
    public static void main(String[] args) {
        CityWeatherApiController controller = new CityWeatherApiController();
        MongoDBUtil.getInstance().getCurrentWeatherMongoCollection().insertOne(controller.getWeatherObject("Ankara"));
        System.out.println("Eklendi.");
    }
}
