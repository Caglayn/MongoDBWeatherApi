package com.caglayan.mongodb.utils;

import com.caglayan.mongodb.entity.CurrentWeather;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoDBUtil {
    private static MongoDBUtil instance;

    private MongoClient mongoClient;
    private MongoDatabase database;
    private PojoCodecProvider codecProvider;
    private CodecRegistry pojoCodecRegistry;
    private MongoCollection<CurrentWeather> currentWeatherMongoCollection;

    private MongoDBUtil() {
    }

    public static MongoDBUtil getInstance(){
        if (instance == null)
            instance = new MongoDBUtil();
        return instance;
    }

    private void initDatabase(){
        this.mongoClient = new MongoClient("localhost", 27017);
        this.database = this.mongoClient.getDatabase("weather_Api");
        this.codecProvider = PojoCodecProvider.builder().automatic(true).build();
        this.pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(this.codecProvider));
        currentWeatherMongoCollection = database.withCodecRegistry(pojoCodecRegistry)
                .getCollection("current_weathers", CurrentWeather.class);
    }

    public MongoCollection<CurrentWeather> getCurrentWeatherMongoCollection(){
        if (this.database == null)
            this.initDatabase();
        return this.currentWeatherMongoCollection;
    }
}
