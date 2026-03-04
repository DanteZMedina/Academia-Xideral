package com.dantezmedina.online_store.repository;

import com.dantezmedina.online_store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}