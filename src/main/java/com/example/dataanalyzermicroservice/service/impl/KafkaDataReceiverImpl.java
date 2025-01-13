package com.example.dataanalyzermicroservice.service.impl;

import com.example.dataanalyzermicroservice.config.LocalDateTimeDeserializer;
import com.example.dataanalyzermicroservice.model.Data;
import com.example.dataanalyzermicroservice.service.KafkaDataReceiver;
import com.example.dataanalyzermicroservice.service.KafkaDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> kafkaReceiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaDataService kafkaDataService;

    @PostConstruct
    void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        localDateTimeDeserializer)
                .create();
        kafkaReceiver.receive()
                .subscribe(
                        r -> {
                            Data data = gson
                                    .fromJson(r.value().toString(), Data.class);
                            kafkaDataService.handle(data);
                            r.receiverOffset().acknowledge();
                        }
                );
    }

}
