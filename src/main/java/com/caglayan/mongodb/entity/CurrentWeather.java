package com.caglayan.mongodb.entity;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CurrentWeather {
    private Coordinate coord;
    private List<Weather> weather;
    private String base;
    private MainValues main;
    private long visibility;
    private Wind wind;
    private Cloud clouds;
    private long dt;
    private MoreData sys;
    private long timezone;
    private long id;
    private String name;
    private int cod;
}
