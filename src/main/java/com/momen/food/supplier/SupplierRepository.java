package com.momen.food.supplier;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {

    List<Supplier> findAllByCategory_Id(Long category_id);
}
