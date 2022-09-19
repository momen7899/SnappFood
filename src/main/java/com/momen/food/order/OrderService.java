package com.momen.food.order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    Order update(Order order);

    void delete(Long id);

    Order getById(Long id);

    List<Order> findAll();

}
