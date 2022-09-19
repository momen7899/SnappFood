package com.momen.food.order_item;

import com.momen.food.common.BaseEntity;
import com.momen.food.order.Order;
import com.momen.food.supply.Supply;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "order_item_tb")
@Audited
public class OrderItem extends BaseEntity {
    private Integer count;
    @ManyToOne
    private Supply supply;
    @ManyToOne
    private Order order;
}
