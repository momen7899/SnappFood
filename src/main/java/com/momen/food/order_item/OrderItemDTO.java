package com.momen.food.order_item;

import com.momen.food.common.BaseDTO;
import com.momen.food.order.Order;
import com.momen.food.supply.Supply;
import lombok.Data;

@Data
public class OrderItemDTO extends BaseDTO {
    private Integer count;
    private Supply supply;
    private Order order;
}