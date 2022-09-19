package com.momen.food.order;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Order/v1")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;
    private final OrderMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody OrderDTO orderDTO) {
        val order = mapper.toOrder(orderDTO);
        service.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO) {
        val order = mapper.toOrder(orderDTO);
        val dto = mapper.toOrderDTO(service.update(order));
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        val orderDTO = mapper.toOrderDTO(service.getById(id));
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        val orderDTOS = mapper.toOrderDTOs(service.findAll());
        return ResponseEntity.ok(orderDTOS);
    }
}
