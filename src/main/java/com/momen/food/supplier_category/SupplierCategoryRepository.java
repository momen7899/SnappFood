package com.momen.food.supplier_category;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierCategoryRepository extends PagingAndSortingRepository<SupplierCategory, Long> {
}
