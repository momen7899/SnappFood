package com.momen.food.supplier_category;

import com.momen.food.common.BaseEntity;
import com.momen.food.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = SupplierCategory.TABLE_NAME)
@Audited
public class SupplierCategory extends BaseEntity {

    public static final String TABLE_NAME = "supplier_category_tb";

    private String name;
    private String icon;

    @OneToMany
    private List<Supplier> suppliers;
}