package com.dantezmedina.online_store.service;

import com.dantezmedina.online_store.dto.ProductRequest;
import com.dantezmedina.online_store.exception.ResourceNotFoundException;
import com.dantezmedina.online_store.model.Category;
import com.dantezmedina.online_store.model.Product;
import com.dantezmedina.online_store.repository.ProductRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductService service;

    Product product;

    @BeforeEach
    void setup() {
        product = Product.builder()
                .id(1L)
                .name("Laptop")
                .price(1200.0)
                .description("Gaming laptop")
                .category(Category.ELECTRONICS)
                .stock(10)
                .build();
    }

    // shouldReturnAllProducts
    @Test
    void shouldReturnAllProducts() {

        when(repository.findAll()).thenReturn(List.of(product));

        var result = service.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).name()).isEqualTo("Laptop");

        verify(repository).findAll();
    }

    // shouldReturnProductById
    @Test
    void shouldReturnProductById() {

        when(repository.findById(1L)).thenReturn(Optional.of(product));

        var result = service.findById(1L);

        assertThat(result.name()).isEqualTo("Laptop");

        verify(repository).findById(1L);
    }

    @Test
    void shouldThrowWhenProductNotFound() {

        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.findById(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Product not found");

        verify(repository).findById(1L);
    }

    @Test
    void shouldCreateProduct() {

        ProductRequest request = new ProductRequest(
                "Laptop",
                1200.0,
                "Gaming laptop",
                Category.ELECTRONICS,
                10);

        when(repository.existsByNameIgnoreCase("Laptop")).thenReturn(false);
        when(repository.save(any(Product.class))).thenReturn(product);

        var result = service.create(request);

        assertThat(result.name()).isEqualTo("Laptop");

        verify(repository).save(any(Product.class));
    }

    @Test
    void shouldRejectDuplicateName() {

        ProductRequest request = new ProductRequest(
                "Laptop",
                1200.0,
                "Gaming laptop",
                Category.ELECTRONICS,
                10);

        when(repository.existsByNameIgnoreCase("Laptop")).thenReturn(true);

        assertThatThrownBy(() -> service.create(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("already exists");

        verify(repository, never()).save(any());
    }

    @Test
    void shouldUpdateProduct() {

        ProductRequest request = new ProductRequest(
                "Laptop Pro",
                1500.0,
                "Updated laptop",
                Category.ELECTRONICS,
                5);

        when(repository.findById(1L)).thenReturn(Optional.of(product));
        when(repository.save(any(Product.class))).thenReturn(product);

        var result = service.update(1L, request);

        assertThat(result.name()).isEqualTo("Laptop Pro");

        verify(repository).save(product);
    }

    @Test
    void shouldDeleteProduct() {

        when(repository.existsById(1L)).thenReturn(true);

        service.delete(1L);

        verify(repository).deleteById(1L);
    }

    @Test
    void shouldSearchByName() {

        when(repository.findByNameContainingIgnoreCase("lap"))
                .thenReturn(List.of(product));

        var result = service.searchByName("lap");

        assertThat(result).hasSize(1);

        verify(repository).findByNameContainingIgnoreCase("lap");
    }
}