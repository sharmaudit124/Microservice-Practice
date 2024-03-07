package com.saga.orderservice.controllers;

import com.saga.orderservice.entitites.Order;
import com.saga.orderservice.events.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        // Save the order to the database or perform any required business logic

        // Publish the OrderCreatedEvent
        eventPublisher.publishEvent(new OrderCreatedEvent(order));

        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }
}
