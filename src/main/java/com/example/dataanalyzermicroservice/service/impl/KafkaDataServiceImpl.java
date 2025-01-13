package com.example.dataanalyzermicroservice.service.impl;

import com.example.dataanalyzermicroservice.model.Data;
import com.example.dataanalyzermicroservice.service.KafkaDataService;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataServiceImpl implements KafkaDataService {

    @Override
    public void handle(Data data) {
        System.out.println("Data object is received: " + data.toString());
    }

}
