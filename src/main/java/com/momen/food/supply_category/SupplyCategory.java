package com.momen.food.supply_category;

import com.momen.food.common.BaseEntity;
import com.momen.food.supplier.Supplier;
import com.momen.food.supply.Supply;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = SupplyCategory.TABLE_NAME)
@Audited
public class SupplyCategory extends BaseEntity {
    public static final String TABLE_NAME = "supply_tb";

    private String name;
    private String icon;

    @ManyToOne
    private Supplier supplier;

    @OneToMany
    private List<Supply> supplies;
}
