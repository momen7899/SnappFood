package com.momen.food.supply_category;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyCategoryRepository extends PagingAndSortingRepository<SupplyCategory, Long> {
}
