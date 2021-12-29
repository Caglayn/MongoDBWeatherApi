package com.caglayan.mongodb.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Wind {
    private double speed;
    private double deg;
    private double gust;
}
