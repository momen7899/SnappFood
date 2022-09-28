package com.momen.food.supply;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/Supply/v1")
@AllArgsConstructor
public class SupplyController {

    private final SupplyService service;

    private final SupplyMapper mapper;

    @PostMapping
    @RolesAllowed({"supplier"})
    public ResponseEntity<Void> saveSupply(@RequestBody SupplyDTO dto) {
        Supply supply = mapper.toSupply(dto);
        service.save(supply);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    @RolesAllowed({"supplier"})
    public ResponseEntity<SupplyDTO> updateSupply(@RequestBody SupplyDTO dto) {
        Supply supply = mapper.toSupply(dto);
        SupplyDTO supplyDTO = mapper.toSupplyDto(service.update(supply));
        return ResponseEntity.ok(supplyDTO);
    }

    @DeleteMapping("{id}")
    @RolesAllowed({"admin","supplier"})
    public ResponseEntity<SupplyDTO> deleteSupply(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    @RolesAllowed({"admin", "supplier"})
    public ResponseEntity<List<SupplyDTO>> getSupply() {
        List<SupplyDTO> supplyDTOS = mapper.toSupplierDTOs(service.findAll());

        return ResponseEntity.ok(supplyDTOS);
    }

    @GetMapping("/SupplyCategory/{id}")
    @Timed("supply.getAll")
    @RolesAllowed({"admin", "supplier"})
    public ResponseEntity<List<SupplyDTO>> getSuppliesByCategoryId(@PathVariable Long id) {
        val supplyDTOS = mapper.toSupplierDTOs(service.findAllBySupplyCategory(id));

        return ResponseEntity.ok(supplyDTOS);
    }

}
