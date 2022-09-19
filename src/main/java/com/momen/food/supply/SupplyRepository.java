package com.momen.food.supply;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends PagingAndSortingRepository<Supply, Long> {

    List<Supply> findAllByCategory_Id(Long category_id);
}
