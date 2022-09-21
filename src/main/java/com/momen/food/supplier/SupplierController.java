package com.momen.food.supplier;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Supplier/v1")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService service;

    private final SupplierMapper mapper;


    @PostMapping
    public ResponseEntity<Void> saveSupplier(@RequestBody SupplierDTO dto) {
        Supplier supplier = mapper.toSupplier(dto);
        service.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO dto) {
        Supplier supplier = mapper.toSupplier(dto);
        SupplierDTO supplierDTO = mapper.toSupplierDTO(service.update(supplier));
        return ResponseEntity.ok(supplierDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SupplierDTO> deleteSupplier(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSupplier() {
        List<SupplierDTO> supplierDTOS = mapper.toSupplierDTOs(service.findAll());

        return ResponseEntity.ok(supplierDTOS);
    }

    @GetMapping("/SupplierCategory/{id}")
    @Timed("supplier.getAll")
    public ResponseEntity<List<SupplierDTO>> getSupplierByCategoryId(@PathVariable Long id) {
        List<SupplierDTO> supplierDTOS = mapper.toSupplierDTOs(service.findAllBySupplierCategory(id));

        return ResponseEntity.ok(supplierDTOS);
    }

}
