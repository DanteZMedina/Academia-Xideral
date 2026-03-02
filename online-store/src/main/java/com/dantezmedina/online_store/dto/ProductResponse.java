package com.dantezmedina.online_store.dto;

import com.dantezmedina.online_store.model.Category;

import java.time.LocalDateTime;

public record ProductResponse(
        Long id,
        String name,
        Double price,
        String description,
        Category category,
        Integer stock,
        LocalDateTime createdAt
) {}