package com.momen.food.order_item;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem toOrderItem(OrderItemDTO dto);

    OrderItemDTO toOrderItemDTO(OrderItem item);

    List<OrderItemDTO> toOrderItemDTOs(List<OrderItem> items);

}
