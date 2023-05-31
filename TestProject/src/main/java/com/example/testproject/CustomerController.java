package com.example.testproject;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Customers")
public class CustomerController {
    private KafkaTemplate<String, String> kafkaTemplate;
    public CustomerController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
        System.out.println(this.kafkaTemplate.getProducerFactory().getConfigurationProperties());
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request){
        kafkaTemplate.send("omarcode", request.message());
    }

}
