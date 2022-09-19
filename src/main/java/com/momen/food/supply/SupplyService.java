package com.momen.food.supply;

import java.util.List;

public interface SupplyService {
    Supply save(Supply supply);

    Supply update(Supply supply);

    void delete(long id);

    List<Supply> findAll();

    List<Supply> findAllBySupplyCategory(Long supplyCategoryId);
}
