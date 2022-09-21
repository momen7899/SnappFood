package com.momen.food.supplier_category;

import com.momen.food.aop.LogExecutionTime;
import com.momen.food.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierCategoryServiceImpl implements SupplierCategoryService {

    private SupplierCategoryRepository repository;


    @Override
    public SupplierCategory save(SupplierCategory category) {
        return repository.save(category);
    }

    @Override
    public SupplierCategory update(SupplierCategory category) {

        return null;
    }

    private SupplierCategory getById(Long id) {
        Optional<SupplierCategory> optionalSupplierCategory = repository.findById(id);

        if (optionalSupplierCategory.isEmpty()){
            throw new NotFoundException("Not Found Supplier Category");
        }

        return optionalSupplierCategory.get();
    }

    @Override
    public void delete(long id) {
        val category = getById(id);
        repository.delete(category);
    }

    @Override
    @LogExecutionTime
    public List<SupplierCategory> findAll() {
        return (List<SupplierCategory>) repository.findAll();
    }
}
