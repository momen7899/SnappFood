package com.momen.food.order;


import com.momen.food.address.Address;
import com.momen.food.common.BaseDTO;
import com.momen.food.order_item.OrderItem;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO {

    private OrderStatus orderStatus;
    private BigDecimal totalPrice;

    private List<OrderItem> items;

    private Address address;
}
