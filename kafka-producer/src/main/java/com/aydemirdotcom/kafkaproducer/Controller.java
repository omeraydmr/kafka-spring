package com.aydemirdotcom.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public Controller(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/kafka-produce")
    public void enterKafka() {
        System.out.println("Kafka log send starting...");
        for (int i = 0; i < 10; i++) {
            kafkaProducerService.sendMessage(String.format("[%d] -- Hello World", i));
        }
        System.out.println("Kafka log sent...");
    }
}
