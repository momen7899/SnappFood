package com.momen.food.order;


import com.momen.food.address.Address;
import com.momen.food.common.BaseEntity;
import com.momen.food.order_item.OrderItem;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "order_tb")
@Audited
public class Order extends BaseEntity {

    private OrderStatus orderStatus;
    private BigDecimal totalPrice;


    @OneToMany
    private List<OrderItem> items;

    @ManyToOne
    private Address address;
}
