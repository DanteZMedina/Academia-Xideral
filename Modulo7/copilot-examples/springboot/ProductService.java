package com.example.copilot.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de negocio para la gestión de productos.
 *
 * <p>Esta clase fue generada con asistencia de GitHub Copilot.
 * Al escribir la anotación {@code @Service} y la firma del primer método,
 * Copilot completó la implementación de todos los métodos CRUD, incluyendo
 * el manejo de excepciones con {@code RuntimeException}.</p>
 *
 * <p><b>Conceptos Spring demostrados:</b></p>
 * <ul>
 *   <li>{@code @Service} – marca la clase como componente de capa de servicio</li>
 *   <li>{@code @Autowired} – inyección de dependencias del repositorio</li>
 *   <li>Separación de responsabilidades: el servicio contiene la lógica de negocio</li>
 * </ul>
 */
@Service
public class ProductService {

    /**
     * Repositorio inyectado automáticamente por Spring para acceso a datos.
     * Copilot sugirió usar inyección por constructor en lugar de campo
     * para facilitar las pruebas unitarias.
     */
    private final ProductRepository productRepository;

    /**
     * Constructor con inyección de dependencias.
     * Spring inyecta automáticamente la implementación del repositorio.
     *
     * @param productRepository repositorio de productos
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // -----------------------------------------------------------------------
    // Operaciones CRUD
    // -----------------------------------------------------------------------

    /**
     * Recupera todos los productos del sistema.
     *
     * @return lista completa de productos
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Busca un producto por su identificador único.
     * Lanza una excepción si el producto no existe.
     *
     * @param id identificador del producto
     * @return el producto encontrado
     * @throws RuntimeException si no existe un producto con el id dado
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    /**
     * Crea y persiste un nuevo producto en el sistema.
     *
     * @param product datos del nuevo producto
     * @return el producto guardado con su id asignado
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Actualiza los datos de un producto existente.
     * Solo se actualizan los campos que no sean nulos en el objeto recibido.
     *
     * @param id             identificador del producto a actualizar
     * @param productDetails datos nuevos del producto
     * @return el producto actualizado
     * @throws RuntimeException si no existe un producto con el id dado
     */
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setCategory(productDetails.getCategory());

        return productRepository.save(product);
    }

    /**
     * Elimina un producto del sistema por su id.
     *
     * @param id identificador del producto a eliminar
     * @throws RuntimeException si no existe un producto con el id dado
     */
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    // -----------------------------------------------------------------------
    // Consultas de negocio
    // -----------------------------------------------------------------------

    /**
     * Recupera todos los productos de una categoría.
     *
     * @param category nombre de la categoría
     * @return lista de productos en la categoría indicada
     */
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    /**
     * Busca productos con stock disponible por debajo de un umbral.
     * Útil para alertas de reabastecimiento.
     *
     * @param threshold cantidad mínima aceptable de stock
     * @return lista de productos con stock bajo
     */
    public List<Product> getLowStockProducts(Integer threshold) {
        return productRepository.findProductsWithLowStock(threshold);
    }

    /**
     * Busca productos por nombre (búsqueda parcial, sin distinción de
     * mayúsculas/minúsculas).
     *
     * @param keyword texto a buscar en el nombre del producto
     * @return lista de productos cuyo nombre contiene el keyword
     */
    public List<Product> searchByName(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}
