package com.bootcamp.week3.ex4;

import java.time.LocalDate;

public record Sale(
        String product,
        String category,
        double amount,
        String region,
        LocalDate date
) {}