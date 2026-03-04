package com.dantezmedina.online_store.repository;

import com.dantezmedina.online_store.model.Product;
import com.dantezmedina.online_store.dto.TopProductResponse;
import com.dantezmedina.online_store.model.Category;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    List<Product> findByPriceBetween(Double min, Double max);

    List<Product> findByNameContainingIgnoreCase(String keyword);

    boolean existsByNameIgnoreCase(String name);

    @Query("SELECT p FROM Product p WHERE p.stock > 0 ORDER BY p.price ASC")
    List<Product> findAvailableProducts();

    @Query("""
            SELECT new com.dantezmedina.online_store.dto.TopProductResponse(
                 p.id,
                 p.name,
                 SUM(oi.quantity)
            )
            FROM OrderItem oi
            JOIN oi.product p
            GROUP BY p.id, p.name
            ORDER BY SUM(oi.quantity) DESC
            """)
    List<TopProductResponse> findTopSellingProducts(Pageable pageable);
}