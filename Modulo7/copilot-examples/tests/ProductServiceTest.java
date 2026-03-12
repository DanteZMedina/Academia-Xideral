package com.example.copilot.tests;

import com.example.copilot.springboot.Product;
import com.example.copilot.springboot.ProductRepository;
import com.example.copilot.springboot.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests unitarios para {@link ProductService}.
 *
 * <p>Esta clase fue generada con asistencia de GitHub Copilot.
 * Al escribir la primera prueba con {@code when(...).thenReturn(...)},
 * Copilot generó automáticamente los casos de prueba restantes,
 * incluyendo los escenarios de error y las verificaciones con
 * {@code verify(...)}.</p>
 *
 * <p><b>Conceptos de testing demostrados:</b></p>
 * <ul>
 *   <li>{@code @ExtendWith(MockitoExtension.class)} – integra Mockito con JUnit 5</li>
 *   <li>{@code @Mock} – crea instancias mock del repositorio</li>
 *   <li>{@code @InjectMocks} – inyecta los mocks en el servicio bajo prueba</li>
 *   <li>{@code when(...).thenReturn(...)} – define comportamiento del mock</li>
 *   <li>{@code verify(...)} – verifica que ciertos métodos fueron llamados</li>
 *   <li>{@code assertThrows(...)} – verifica que se lanza una excepción</li>
 * </ul>
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    /**
     * Mock del repositorio: simula la capa de datos sin necesitar base de datos real.
     * Copilot sugirió esta anotación automáticamente al definir el campo.
     */
    @Mock
    private ProductRepository productRepository;

    /**
     * Instancia del servicio bajo prueba con los mocks inyectados.
     * Copilot reconoció la dependencia con productRepository e inyectó el mock.
     */
    @InjectMocks
    private ProductService productService;

    /** Producto de prueba reutilizado en múltiples tests. */
    private Product sampleProduct;

    /**
     * Configura los datos de prueba antes de cada test.
     * Copilot generó este método con datos representativos del dominio.
     */
    @BeforeEach
    void setUp() {
        sampleProduct = new Product("Laptop Dell XPS", "Laptop profesional de alto rendimiento",
                1299.99, 15, "Electrónica"); 
        sampleProduct.setId(1L);
    }

    // -----------------------------------------------------------------------
    // Tests: getAllProducts
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("getAllProducts - debe retornar lista de todos los productos")
    void getAllProducts_shouldReturnAllProducts() {
        // Arrange: define qué retorna el mock cuando se llame findAll()
        List<Product> expectedProducts = Arrays.asList(
                sampleProduct,
                new Product("Mouse Logitech", "Mouse inalámbrico ergonómico", 49.99, 50, "Accesorios")
        );
        when(productRepository.findAll()).thenReturn(expectedProducts);

        // Act: ejecuta el método bajo prueba
        List<Product> result = productService.getAllProducts();

        // Assert: verifica el resultado
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    // -----------------------------------------------------------------------
    // Tests: getProductById
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("getProductById - debe retornar el producto cuando existe")
    void getProductById_whenProductExists_shouldReturnProduct() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        // Act
        Product result = productService.getProductById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Laptop Dell XPS", result.getName());
        assertEquals(1299.99, result.getPrice());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("getProductById - debe lanzar excepción cuando el producto no existe")
    void getProductById_whenProductNotFound_shouldThrowException() {
        // Arrange: el repositorio retorna vacío para cualquier id
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert: verifica que se lanza RuntimeException
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> productService.getProductById(99L)
        );

        assertEquals("Producto no encontrado con id: 99", exception.getMessage());
        verify(productRepository, times(1)).findById(99L);
    }

    // -----------------------------------------------------------------------
    // Tests: createProduct
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("createProduct - debe guardar y retornar el producto creado")
    void createProduct_shouldSaveAndReturnProduct() {
        // Arrange
        Product newProduct = new Product("Teclado Mecánico", "Teclado RGB compacto", 89.99, 30, "Accesorios");
        when(productRepository.save(any(Product.class))).thenReturn(newProduct);

        // Act
        Product result = productService.createProduct(newProduct);

        // Assert
        assertNotNull(result);
        assertEquals("Teclado Mecánico", result.getName());
        assertEquals(89.99, result.getPrice());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    // -----------------------------------------------------------------------
    // Tests: updateProduct
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("updateProduct - debe actualizar y retornar el producto modificado")
    void updateProduct_whenProductExists_shouldUpdateAndReturn() {
        // Arrange
        Product updatedDetails = new Product("Laptop Dell XPS 15", "Actualización 2024",
                1499.99, 10, "Electrónica");
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        when(productRepository.save(any(Product.class))).thenReturn(sampleProduct);

        // Act
        Product result = productService.updateProduct(1L, updatedDetails);

        // Assert
        assertNotNull(result);
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    @DisplayName("updateProduct - debe lanzar excepción si el producto no existe")
    void updateProduct_whenProductNotFound_shouldThrowException() {
        // Arrange
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                RuntimeException.class,
                () -> productService.updateProduct(99L, sampleProduct)
        );

        verify(productRepository, times(1)).findById(99L);
    }

    // -----------------------------------------------------------------------
    // Tests: deleteProduct
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("deleteProduct - debe eliminar el producto cuando existe")
    void deleteProduct_whenProductExists_shouldDeleteSuccessfully() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        // Act
        productService.deleteProduct(1L);

        // Assert: verifica que delete fue llamado exactamente una vez
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).delete(sampleProduct);
    }

    // -----------------------------------------------------------------------
    // Tests: getProductsByCategory
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("getProductsByCategory - debe retornar productos de la categoría indicada")
    void getProductsByCategory_shouldReturnProductsInCategory() {
        // Arrange
        List<Product> electronics = List.of(sampleProduct);
        when(productRepository.findByCategory("Electrónica")).thenReturn(electronics);

        // Act
        List<Product> result = productService.getProductsByCategory("Electrónica");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Electrónica", result.get(0).getCategory());
        verify(productRepository, times(1)).findByCategory("Electrónica");
    }

    // -----------------------------------------------------------------------
    // Tests: getLowStockProducts
    // -----------------------------------------------------------------------

    @Test
    @DisplayName("getLowStockProducts - debe retornar productos con stock bajo el umbral")
    void getLowStockProducts_shouldReturnProductsBelowThreshold() {
        // Arrange
        Product lowStockProduct = new Product("Auriculares Sony", "Auriculares noise-cancelling",
                299.99, 3, "Electrónica");
        when(productRepository.findProductsWithLowStock(5)).thenReturn(List.of(lowStockProduct));

        // Act
        List<Product> result = productService.getLowStockProducts(5);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).getStock());
        verify(productRepository, times(1)).findProductsWithLowStock(5);
    }
}
