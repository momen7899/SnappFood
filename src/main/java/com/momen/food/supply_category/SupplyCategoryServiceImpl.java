package com.momen.food.supply_category;

import com.momen.food.aop.LogExecutionTime;
import com.momen.food.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplyCategoryServiceImpl implements SupplyCategoryService {

    private final SupplyCategoryRepository repository;

    @Override
    public SupplyCategory save(SupplyCategory supplyCategory) {
        return repository.save(supplyCategory);
    }

    @Override
    public SupplyCategory update(SupplyCategory supplyCategory) {
        SupplyCategory savedBefore = getById(supplyCategory.getId());
        savedBefore.setIcon(supplyCategory.getIcon());
        savedBefore.setName(supplyCategory.getName());
        return repository.save(savedBefore);
    }

    private SupplyCategory getById(Long id) {
        Optional<SupplyCategory> categoryOptional = repository.findById(id);

        if (categoryOptional.isEmpty()) throw new NotFoundException("Supply Category NotFound");

        return categoryOptional.get();
    }

    @Override
    public void delete(Long id) {
        SupplyCategory category = getById(id);
        repository.delete(category);
    }

    @Override
    @LogExecutionTime
    public List<SupplyCategory> findAll() {
        return (List<SupplyCategory>) repository.findAll();
    }
}
