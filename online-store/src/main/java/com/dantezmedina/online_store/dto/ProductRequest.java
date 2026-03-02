package com.dantezmedina.online_store.dto;

import com.dantezmedina.online_store.model.Category;
import jakarta.validation.constraints.*;

public record ProductRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotNull
        @Positive
        Double price,

        String description,

        @NotNull
        Category category,

        @NotNull
        @PositiveOrZero
        Integer stock
) {}