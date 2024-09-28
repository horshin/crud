package com.example.crud.controller;

import com.example.crud.dto.ItemDto;
import com.example.crud.model.Item;
import com.example.crud.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "Get item by id")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemService.get(id));
    }

    @Operation(summary = "Create item")
    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody ItemDto item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(item));
    }

    @Operation(summary = "Delete item by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update item by id")
    @PatchMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @Valid @RequestBody ItemDto item) {
        return ResponseEntity.ok().body(itemService.update(id, item));
    }
}
