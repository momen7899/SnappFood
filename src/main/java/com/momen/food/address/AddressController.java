package com.momen.food.address;

import io.micrometer.core.annotation.Timed;
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
    public ResponseEntity<Void> save(@RequestBody AddressDTO addressDTO) {
        val address = mapper.toAddress(addressDTO);
        service.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
        val address = mapper.toAddress(addressDTO);
        return ResponseEntity.ok(mapper.toAddressDto(service.update(address)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        val address = service.findById(id);
        return ResponseEntity.ok(mapper.toAddressDto(address));
    }

    @GetMapping
    @Timed("address.getAll")
    public ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.ok(mapper.toAddressDTOs(service.findAll()));
    }

}
