package com.momen.food.order_item;

import com.momen.food.aop.LogExecutionTime;
import com.momen.food.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository repository;

    @Override
    public OrderItem save(OrderItem item) {
        return repository.save(item);
    }

    @Override
    public OrderItem add(Long id) {
        OrderItem savedBefore = getById(id);
        savedBefore.setCount(savedBefore.getCount() + 1);
        return repository.save(savedBefore);
    }

    @Override
    public OrderItem minus(Long id) {
        OrderItem savedBefore = getById(id);
        savedBefore.setCount(savedBefore.getCount() - 1);
        return repository.save(savedBefore);
    }

    private OrderItem getById(Long id) {
        Optional<OrderItem> optionalOrderItem = repository.findById(id);
        if (optionalOrderItem.isEmpty()) throw new NotFoundException("Order Item not found");
        return optionalOrderItem.get();
    }

    @Override
    public void delete(Long id) {
        OrderItem item = getById(id);
        repository.delete(item);
    }

    @Override
    @LogExecutionTime
    public List<OrderItem> findAll() {
        return (List<OrderItem>) repository.findAll();
    }
}
