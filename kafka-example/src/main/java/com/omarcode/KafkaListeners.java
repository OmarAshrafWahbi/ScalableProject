package com.omarcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
//    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "omarcode", groupId = "groupId")
    void listener(String data) {

        System.out.println("Listener Received:" + data);
//        LOGGER.trace("Received Kafka message: {}", data);
    }
}
