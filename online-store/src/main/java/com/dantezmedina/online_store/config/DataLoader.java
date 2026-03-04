package com.dantezmedina.online_store.config;

import com.dantezmedina.online_store.model.*;
import com.dantezmedina.online_store.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;

    @Override
    public void run(String... args) {

        if (productRepo.count() == 0) {

            productRepo.saveAll(List.of(
                    Product.builder()
                            .name("Laptop Pro")
                            .price(1500.0)
                            .description("High-end laptop")
                            .category(Category.ELECTRONICS)
                            .stock(50)
                            .build(),

                    Product.builder()
                            .name("Java Programming Book")
                            .price(50.0)
                            .description("Learn Java")
                            .category(Category.BOOKS)
                            .stock(100)
                            .build(),

                    Product.builder()
                            .name("Running Shoes")
                            .price(120.0)
                            .description("Sport shoes")
                            .category(Category.SPORTS)
                            .stock(80)
                            .build()));
        }

        if (customerRepo.count() == 0) {

            customerRepo.save(
                    Customer.builder()
                            .name("Dante Medina")
                            .email("dante@email.com")
                            .build());
        }
    }
}