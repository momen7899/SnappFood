package com.momen.food.supply;

import com.momen.food.common.BaseEntity;
import com.momen.food.order_item.OrderItem;
import com.momen.food.supplier.Supplier;
import com.momen.food.supply_category.SupplyCategory;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = Supply.TABLE_NAME)
@Audited
public class Supply extends BaseEntity {
    public static final String TABLE_NAME = "supplier_tb";

    private String image;
    private String title;
    private String details;

    @ManyToOne
    private SupplyCategory category;

    @ManyToOne
    private Supplier supplier;

    @OneToMany
    private List<OrderItem> orderItem;
}