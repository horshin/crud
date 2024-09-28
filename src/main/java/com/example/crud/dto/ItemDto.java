package com.example.crud.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    @NotBlank(message = "Enter the name")
    private String name;

    @NotBlank(message = "Enter the description")
    private String description;

    @Min(value = 0, message = "Price must be more than 0")
    @NotNull(message = "Enter the price")
    private Double price;
}
