package com.example.inventory.service;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private final ProductRepository repository = Mockito.mock(ProductRepository.class);
    private final ProductService service = new ProductService(repository);

    @Test
    void shouldReturnAllProducts() {

        Mockito.when(repository.findAll()).thenReturn(List.of(new Product()));

        List<Product> products = service.getAllProducts();

        assertEquals(1, products.size());
    }

    @Test
    void shouldReturnProductById() {

        Product product = new Product();
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(product));

        Product result = service.getProductById(1L);

        assertNotNull(result);
    }

    @Test
    void shouldThrowExceptionIfProductNotFound() {

        Mockito.when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            service.getProductById(1L);
        });
    }

    @Test
    void shouldCreateProduct() {

        Product product = new Product();

        Mockito.when(repository.save(product)).thenReturn(product);

        Product saved = service.createProduct(product);

        assertNotNull(saved);
    }

    @Test
    void shouldDeleteProduct() {

        service.deleteProduct(1L);

        Mockito.verify(repository).deleteById(1L);
    }
}