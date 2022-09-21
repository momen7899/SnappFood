package com.momen.food.supplier;

import com.momen.food.aop.LogExecutionTime;
import com.momen.food.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Override
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier savedBefore = getById(supplier.getId());
        savedBefore.setTitle(supplier.getTitle());
        savedBefore.setImage(supplier.getImage());
        return repository.save(savedBefore);
    }

    private Supplier getById(Long id) {
        Optional<Supplier> optionalSupplier = repository.findById(id);
        if (optionalSupplier.isEmpty()) throw new NotFoundException("Supplier NotFound");
        return optionalSupplier.get();
    }

    @Override
    public void delete(long id) {
        Supplier supplier = getById(id);
        repository.delete(supplier);
    }

    @Override
    @LogExecutionTime
    public List<Supplier> findAll() {
        return (List<Supplier>) repository.findAll();
    }

    @Override
    @LogExecutionTime
    public List<Supplier> findAllBySupplierCategory(Long supplierCategoryId) {
        return repository.findAllByCategory_Id(supplierCategoryId);
    }
}
