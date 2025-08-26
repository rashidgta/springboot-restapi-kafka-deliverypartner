package com.springboot.restapi.kafka.deliverypartner.controller;

import com.springboot.restapi.kafka.deliverypartner.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    KafkaService kafkaService;

    //URL localhost:8080/location/update
    @RequestMapping("/update")
    public ResponseEntity<?> updateLocation(){

        for (int i = 1; i <= 10; i ++ ) {
            kafkaService.sendLocation("(" + Math.round(Math.random() * 100) + ","
                    + Math.round(Math.random() * 100) + ")");
        }
            return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }

    //URL localhost:8080/location/publish?msg=
    @RequestMapping("/publish")
    public ResponseEntity<?> publish(@RequestParam String sendMessage ) {
        kafkaService.displayMessage(sendMessage);
        log.info("this is the SLF4J message -> {}",sendMessage);
        return ResponseEntity.ok("Message published to topic");
    }
}
