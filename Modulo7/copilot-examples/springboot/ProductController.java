package com.example.copilot.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para la gestión de productos.
 *
 * <p>Esta clase fue generada con asistencia de GitHub Copilot.
 * Al escribir las primeras dos anotaciones y la firma del primer endpoint,
 * Copilot generó automáticamente los endpoints CRUD restantes, incluyendo
 * los métodos HTTP correctos, los códigos de respuesta HTTP y el manejo
 * de errores con {@code ResponseEntity}.</p>
 *
 * <p><b>Anotaciones Spring demostradas:</b></p>
 * <ul>
 *   <li>{@code @RestController} – combina @Controller y @ResponseBody</li>
 *   <li>{@code @RequestMapping} – mapea la ruta base del controlador</li>
 *   <li>{@code @GetMapping}, {@code @PostMapping}, {@code @PutMapping}, {@code @DeleteMapping}</li>
 *   <li>{@code @PathVariable} – extrae variables de la URL</li>
 *   <li>{@code @RequestBody} – deserializa el cuerpo JSON de la petición</li>
 *   <li>{@code @RequestParam} – extrae parámetros de query string</li>
 *   <li>{@code @Autowired} – inyección de dependencias del servicio</li>
 * </ul>
 *
 * <p>Base URL: {@code /api/products}</p>
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    /** Servicio de negocio inyectado automáticamente por Spring. */
    private final ProductService productService;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param productService servicio de productos
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // -----------------------------------------------------------------------
    // Endpoints CRUD
    // -----------------------------------------------------------------------

    /**
     * Obtiene la lista completa de productos.
     *
     * @return 200 OK con la lista de productos
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Obtiene un producto por su identificador.
     *
     * @param id identificador del producto en la URL
     * @return 200 OK con el producto, o 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo producto en el sistema.
     *
     * @param product datos del producto en el cuerpo de la petición (JSON)
     * @return 201 CREATED con el producto guardado
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    /**
     * Actualiza un producto existente.
     *
     * @param id             identificador del producto en la URL
     * @param productDetails datos actualizados en el cuerpo de la petición
     * @return 200 OK con el producto actualizado, o 404 si no existe
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                  @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un producto del sistema.
     *
     * @param id identificador del producto en la URL
     * @return 204 NO CONTENT si se eliminó correctamente, o 404 si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // -----------------------------------------------------------------------
    // Endpoints de consulta
    // -----------------------------------------------------------------------

    /**
     * Busca productos por categoría.
     *
     * @param category nombre de la categoría (query param)
     * @return 200 OK con la lista de productos en la categoría
     */
    @GetMapping("/category")
    public ResponseEntity<List<Product>> getByCategory(@RequestParam String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    /**
     * Busca productos con stock bajo según un umbral.
     *
     * @param threshold umbral mínimo de stock (query param, default: 5)
     * @return 200 OK con lista de productos con stock bajo
     */
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> getLowStock(
            @RequestParam(defaultValue = "5") Integer threshold) {
        List<Product> products = productService.getLowStockProducts(threshold);
        return ResponseEntity.ok(products);
    }

    /**
     * Busca productos por nombre (búsqueda parcial).
     *
     * @param keyword texto a buscar en el nombre (query param)
     * @return 200 OK con lista de productos que coinciden
     */
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam String keyword) {
        List<Product> products = productService.searchByName(keyword);
        return ResponseEntity.ok(products);
    }
}
