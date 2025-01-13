package com.example.dataanalyzermicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {

    private Long sensorId;
    private double measurement;
    private LocalDateTime timestamp;
    private MeasurementType measurementType;

}
