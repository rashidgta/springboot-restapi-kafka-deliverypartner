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

    public void updateLocation(String location){
        kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME,location);
        log.info("message produced");
    }
}
