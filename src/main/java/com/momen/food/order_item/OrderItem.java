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
@Table(name = OrderItem.TABLE_NAME)
@Audited
public class OrderItem extends BaseEntity {
    public static final String TABLE_NAME = "order_item_tb";

    private Integer count;
    @ManyToOne
    private Supply supply;
    @ManyToOne
    private Order order;
}
