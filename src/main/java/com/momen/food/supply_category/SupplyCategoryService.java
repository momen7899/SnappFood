package com.momen.food.supply_category;


import java.util.List;

public interface SupplyCategoryService {
    SupplyCategory save(SupplyCategory supplyCategory);

    SupplyCategory update(SupplyCategory supplyCategory);

    void delete(Long id);

    List<SupplyCategory> findAll();
}
