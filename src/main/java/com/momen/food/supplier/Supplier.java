package com.momen.food.supplier;

import com.momen.food.common.BaseEntity;
import com.momen.food.supplier_category.SupplierCategory;
import com.momen.food.supply.Supply;
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
@Table(name = "supplier_tb")
@Audited
public class Supplier extends BaseEntity {

    private String title;
    private String image;

    @OneToMany
    private List<Supply> supplies;

    @ManyToOne
    private SupplierCategory category;

    @OneToMany
    private List<SupplyCategory> supplyCategories;
}
