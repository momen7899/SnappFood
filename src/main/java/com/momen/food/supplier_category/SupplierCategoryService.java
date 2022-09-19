package com.momen.food.supplier_category;


import java.util.List;

public interface SupplierCategoryService {

    SupplierCategory save(SupplierCategory category);

    SupplierCategory update(SupplierCategory category);

    void delete(long id);

    List<SupplierCategory> findAll();

}
