package com.dantezmedina.online_store.dto;

public record TopProductResponse(
        Long productId,
        String name,
        Long totalSold
) {}