package com.momen.food.supplier;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(long id);

    List<Supplier> findAll();

    List<Supplier> findAllBySupplierCategory(Long supplierCategoryId);
}
