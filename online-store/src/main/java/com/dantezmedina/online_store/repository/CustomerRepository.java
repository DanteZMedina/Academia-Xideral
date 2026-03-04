package com.dantezmedina.online_store.repository;

import com.dantezmedina.online_store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}