package com.example.copilot.springboot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa un producto en el sistema de inventario.
 *
 * <p>Esta clase fue generada con asistencia de GitHub Copilot.
 * Al escribir la anotación {@code @Entity} y el comentario de clase,
 * Copilot sugirió automáticamente los campos típicos de un producto,
 * las anotaciones JPA correspondientes y los métodos de acceso.</p>
 *
 * <p><b>Anotaciones Spring/JPA demostradas:</b>
 * {@code @Entity}, {@code @Table}, {@code @Id}, {@code @GeneratedValue},
 * {@code @Column}</p>
 */
@Entity
@Table(name = "products")
public class Product {

    /** Identificador único autogenerado por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre del producto. No puede ser nulo y tiene máximo 100 caracteres. */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /** Descripción detallada del producto. */
    @Column(name = "description", length = 500)
    private String description;

    /** Precio unitario del producto. No puede ser nulo. */
    @Column(name = "price", nullable = false)
    private Double price;

    /** Cantidad disponible en inventario. */
    @Column(name = "stock", nullable = false)
    private Integer stock;

    /** Categoría del producto. */
    @Column(name = "category", length = 50)
    private String category;

    // -----------------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------------

    /** Constructor vacío requerido por JPA. */
    public Product() {}

    /**
     * Constructor con todos los campos (excepto id, que es autogenerado).
     *
     * @param name        nombre del producto
     * @param description descripción del producto
     * @param price       precio unitario
     * @param stock       cantidad en inventario
     * @param category    categoría del producto
     */
    public Product(String name, String description, Double price,
                   Integer stock, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    // -----------------------------------------------------------------------
    // Getters y Setters
    // -----------------------------------------------------------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
