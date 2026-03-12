package com.example.copilot.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio Spring Data JPA para la entidad {@link Product}.
 *
 * <p>Esta interfaz fue generada con asistencia de GitHub Copilot.
 * Al escribir {@code extends JpaRepository<Product, Long>}, Copilot
 * sugirió los métodos de consulta personalizados basándose en los
 * campos de la entidad.</p>
 *
 * <p><b>Anotaciones Spring demostradas:</b>
 * {@code @Repository}, {@code @Query}, {@code @Param}</p>
 *
 * <p>Spring Data JPA genera automáticamente la implementación de todos
 * los métodos en tiempo de ejecución.</p>
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Busca un producto por su nombre exacto.
     *
     * @param name nombre del producto a buscar
     * @return un {@link Optional} con el producto si existe
     */
    Optional<Product> findByName(String name);

    /**
     * Recupera todos los productos de una categoría específica.
     *
     * @param category nombre de la categoría
     * @return lista de productos en la categoría indicada
     */
    List<Product> findByCategory(String category);

    /**
     * Busca productos cuyo precio esté dentro del rango indicado.
     *
     * @param minPrice precio mínimo (inclusivo)
     * @param maxPrice precio máximo (inclusivo)
     * @return lista de productos dentro del rango de precio
     */
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Recupera todos los productos con stock disponible mayor a cero.
     *
     * @return lista de productos con stock positivo
     */
    List<Product> findByStockGreaterThan(Integer stock);

    /**
     * Busca productos cuyo nombre contenga el texto indicado (sin distinción
     * de mayúsculas/minúsculas).
     *
     * @param keyword texto a buscar dentro del nombre del producto
     * @return lista de productos cuyo nombre contiene el keyword
     */
    List<Product> findByNameContainingIgnoreCase(String keyword);

    /**
     * Consulta JPQL personalizada que retorna productos con stock bajo.
     * Se considera stock bajo cuando la cantidad es menor al umbral dado.
     *
     * @param threshold umbral mínimo de stock
     * @return lista de productos con stock por debajo del umbral
     */
    @Query("SELECT p FROM Product p WHERE p.stock < :threshold ORDER BY p.stock ASC")
    List<Product> findProductsWithLowStock(@Param("threshold") Integer threshold);
}
