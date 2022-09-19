package com.momen.food.address;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Address/v1")
@AllArgsConstructor
public class AddressController {
    private final AddressService service;
    private final AddressMapper mapper;

    @PostMapping
    private ResponseEntity<Void> save(@RequestBody AddressDTO addressDTO) {
        val address = mapper.toAddress(addressDTO);
        service.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    private ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
        val address = mapper.toAddress(addressDTO);
        return ResponseEntity.ok(mapper.toAddressDto(service.update(address)));
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    private ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        val address = service.findById(id);
        return ResponseEntity.ok(mapper.toAddressDto(address));
    }

    @GetMapping
    private ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.ok(mapper.toAddressDTOs(service.findAll()));
    }

}
