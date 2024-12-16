package org.sawaklaudia.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "events.guardhouse.homeoffice", groupId = "home-office-consumers")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
