package com.momen.food.supply;

import com.momen.food.aop.LogExecutionTime;
import com.momen.food.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository repository;

    @Override
    public Supply save(Supply supply) {
        return repository.save(supply);
    }

    @Override
    public Supply update(Supply supply) {
        Supply savedBefore = getById(supply.getId());
        savedBefore.setTitle(supply.getTitle());
        savedBefore.setImage(supply.getImage());
        savedBefore.setDetails(supply.getDetails());
        return repository.save(savedBefore);
    }

    private Supply getById(Long id) {
        Optional<Supply> optionalSupplier = repository.findById(id);
        if (optionalSupplier.isEmpty()) throw new NotFoundException("Supplier NotFound");
        return optionalSupplier.get();
    }

    @Override
    public void delete(long id) {
        Supply supply = getById(id);
        repository.delete(supply);
    }

    @Override
    @LogExecutionTime
    public List<Supply> findAll() {
        return (List<Supply>) repository.findAll();
    }

    @Override
    @LogExecutionTime
    public List<Supply> findAllBySupplyCategory(Long supplyCategoryId) {
        return repository.findAllByCategory_Id(supplyCategoryId);
    }
}
