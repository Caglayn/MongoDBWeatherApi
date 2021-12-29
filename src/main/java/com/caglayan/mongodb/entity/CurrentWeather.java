package com.caglayan.mongodb.entity;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CurrentWeather {
    private String id;
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
    private String name;
    private int cod;
}
