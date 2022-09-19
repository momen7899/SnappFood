package com.momen.food.supplier_category;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/SupplierCategory/v1")
@AllArgsConstructor
public class SupplierCategoryController {

    private final SupplierCategoryService service;
    private SupplierCategoryMapper mapper;


    @PostMapping
    public ResponseEntity<Void> saveSupplierCategory(@RequestBody SupplierCategoryDTO dto) {
        SupplierCategory category = mapper.toSupplierCategory(dto);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<SupplierCategoryDTO> updateSupplierCategory(@RequestBody SupplierCategoryDTO dto) {
        SupplierCategory category = mapper.toSupplierCategory(dto);
        SupplierCategoryDTO categoryDTO = mapper.toSupplierCategoryDTO(service.update(category));
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SupplierCategoryDTO> deleteSupplierCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierCategoryDTO>> getSupplierCategory() {
        List<SupplierCategoryDTO> categoryDTOS = mapper.toSupplierCategoryDTOs(service.findAll());

        return ResponseEntity.ok(categoryDTOS);
    }

}
