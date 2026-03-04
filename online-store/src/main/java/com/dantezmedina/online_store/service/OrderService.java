package com.dantezmedina.online_store.service;

import com.dantezmedina.online_store.dto.*;
import com.dantezmedina.online_store.exception.ResourceNotFoundException;
import com.dantezmedina.online_store.model.*;
import com.dantezmedina.online_store.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public Order createOrder(CreateOrderRequest request) {

        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);

        List<OrderItem> items = new ArrayList<>();
        double total = 0;

        for (OrderItemRequest itemRequest : request.items()) {

            Product product = productRepository.findById(itemRequest.productId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Product not found"));

            if (product.getStock() < itemRequest.quantity()) {
                throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
            }

            product.setStock(product.getStock() - itemRequest.quantity());

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemRequest.quantity());
            item.setPrice(product.getPrice());

            total += product.getPrice() * itemRequest.quantity();

            items.add(item);
        }

        order.setItems(items);
        order.setTotal(total);

        return orderRepository.save(order);
    }
}