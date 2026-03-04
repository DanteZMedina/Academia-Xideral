package com.dantezmedina.online_store.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrderRequest(

        @NotNull
        Long customerId,

        List<OrderItemRequest> items
) {}