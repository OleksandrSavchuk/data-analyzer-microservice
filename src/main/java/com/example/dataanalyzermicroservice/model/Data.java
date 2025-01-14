package com.example.dataanalyzermicroservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "data")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sensorId;
    private double measurement;
    private LocalDateTime timestamp;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private MeasurementType measurementType;

}
