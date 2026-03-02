package com.dantezmedina.online_store.service;

import com.dantezmedina.online_store.dto.*;
import com.dantezmedina.online_store.exception.ResourceNotFoundException;
import com.dantezmedina.online_store.model.Product;
import com.dantezmedina.online_store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));

        return mapToResponse(product);
    }

    public ProductResponse create(ProductRequest request) {

        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new IllegalArgumentException("Product already exists");
        }

        Product product = Product.builder()
                .name(request.name())
                .price(request.price())
                .description(request.description())
                .category(request.category())
                .stock(request.stock())
                .build();

        Product saved = repository.save(product);

        return mapToResponse(saved);
    }

    public ProductResponse update(Long id, ProductRequest request) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));

        product.setName(request.name());
        product.setPrice(request.price());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setStock(request.stock());

        return mapToResponse(repository.save(product));
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }

        repository.deleteById(id);
    }

    public List<ProductResponse> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getStock(),
                product.getCreatedAt()
        );
    }
}