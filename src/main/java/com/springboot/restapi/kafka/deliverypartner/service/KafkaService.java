package com.springboot.restapi.kafka.deliverypartner.service;

import com.springboot.restapi.kafka.deliverypartner.config.AppConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendLocation(String location){
        kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME,location);
        log.info("Location sent");
    }

    public void displayMessage(String sendMessage) {
        kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME,sendMessage);
        log.info("Message sent");


    }
}
