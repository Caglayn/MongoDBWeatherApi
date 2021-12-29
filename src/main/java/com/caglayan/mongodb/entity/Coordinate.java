package com.caglayan.mongodb.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Coordinate {
    private double lon;
    private double lat;
}
