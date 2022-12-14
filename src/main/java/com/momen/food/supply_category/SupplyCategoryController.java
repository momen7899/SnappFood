package com.momen.food.supply_category;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/SupplyCategory/v1")
@AllArgsConstructor
public class SupplyCategoryController {
    private final SupplyCategoryService service;
    private SupplyCategoryMapper mapper;


    @PostMapping
    @RolesAllowed({"supplier"})
    public ResponseEntity<Void> saveSupplyCategory(@RequestBody SupplyCategoryDTO dto) {
        SupplyCategory category = mapper.toSupplyCategory(dto);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @RolesAllowed({"supplier"})
    public ResponseEntity<SupplyCategoryDTO> updateSupplierCategory(@RequestBody SupplyCategoryDTO dto) {
        SupplyCategory category = mapper.toSupplyCategory(dto);
        SupplyCategoryDTO categoryDTO = mapper.toSupplyCategoryDTO(service.update(category));
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("{id}")
    @RolesAllowed({"supplier"})
    public ResponseEntity<SupplyCategoryDTO> deleteSupplierCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    @Timed("supply_category.getAll")
    @RolesAllowed({"admin", "supplier"})
    public ResponseEntity<List<SupplyCategoryDTO>> getSupplierCategory() {
        List<SupplyCategoryDTO> categoryDTOS = mapper.toSupplyCategoryDTOs(service.findAll());

        return ResponseEntity.ok(categoryDTOS);
    }
}
