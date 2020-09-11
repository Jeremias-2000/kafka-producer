package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/kafka")
public class Users {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private static final String TOPIC = "Kafka_Message";
    @GetMapping("/get/{message}")
    public String postMessage(@PathVariable("message") final String message){
        kafkaTemplate.send(TOPIC,message);

        return "ok";
    }
}
