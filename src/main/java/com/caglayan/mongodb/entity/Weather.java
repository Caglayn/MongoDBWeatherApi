package com.caglayan.mongodb.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Weather {
    private long id;
    private String main;
    private String description;
    private String icon;
}
