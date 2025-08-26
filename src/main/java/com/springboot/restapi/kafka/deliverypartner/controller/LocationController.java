package com.springboot.restapi.kafka.deliverypartner.controller;

import com.springboot.restapi.kafka.deliverypartner.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    KafkaService kafkaService;

    @RequestMapping("/update")
    public ResponseEntity<?> updateLocation(){

        for (int i = 1; i <= 10; i ++ ) {
            kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + ","
                    + Math.round(Math.random() * 100) + ")");
        }
            return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }
}
