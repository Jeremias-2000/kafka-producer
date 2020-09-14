package com.example.demo.resource;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/kafka")
public class UsersResource {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public UsersResource(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String TOPIC = "Kafka_Message";
    @GetMapping("/get/{name}")
    public String postMessage(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC,new User(name,"Queijo","pizzas"));

        return "ok";
    }
}
