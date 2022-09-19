package com.momen.food.order;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order order);

    List<OrderDTO> toOrderDTOs(List<Order> orders);
}
