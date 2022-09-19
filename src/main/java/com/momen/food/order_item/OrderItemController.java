package com.momen.food.order_item;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/OrderItem/v1")
@AllArgsConstructor
public class OrderItemController {

    private final OrderItemService service;
    private OrderItemMapper mapper;

    @PostMapping
    public ResponseEntity<Void> saveSupplierCategory(@RequestBody OrderItemDTO dto) {
        OrderItem item = mapper.toOrderItem(dto);
        service.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<OrderItemDTO> add(@PathVariable Long id) {
        OrderItemDTO itemDTO = mapper.toOrderItemDTO(service.add(id));
        return ResponseEntity.ok(itemDTO);
    }

    @PutMapping("/minus/{id}")
    public ResponseEntity<OrderItemDTO> minus(@PathVariable Long id) {
        OrderItemDTO itemDTO = mapper.toOrderItemDTO(service.minus(id));
        return ResponseEntity.ok(itemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> findAll() {
        val items = service.findAll();
        return ResponseEntity.ok(mapper.toOrderItemDTOs(items));
    }


}
