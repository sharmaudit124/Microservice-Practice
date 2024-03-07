package com.saga.orderservice.events;

import com.saga.orderservice.entitites.Order;

public class OrderCreatedEvent {
    private Order order;

    public OrderCreatedEvent(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
