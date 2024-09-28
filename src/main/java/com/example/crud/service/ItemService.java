package com.example.crud.service;

import com.example.crud.dto.ItemDto;
import com.example.crud.exception.ItemNotFoundException;
import com.example.crud.model.Item;
import com.example.crud.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Item create(ItemDto item) {
        Item entity = new Item();

        entity.setName(item.getName());
        entity.setDescription(item.getDescription());
        entity.setPrice(item.getPrice());
        entity.setCreatedAt(new Date());

        return itemRepository.save(entity);
    }

    public Item get(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    public Item update(Long id, ItemDto item) {
        Item itemToUpdate = get(id);

        if (itemToUpdate.getName() != null) {
            itemToUpdate.setName(item.getName());
        }
        if (itemToUpdate.getDescription() != null) {
            itemToUpdate.setDescription(item.getDescription());
        }
        if (itemToUpdate.getPrice() != null) {
            itemToUpdate.setPrice(item.getPrice());
        }

        return itemRepository.save(itemToUpdate);
    }

    public void delete(Long id) {
        itemRepository.findById(id)
                .ifPresentOrElse(itemRepository::delete, () -> {
                    throw new ItemNotFoundException("Item not found");
                });
    }
}
