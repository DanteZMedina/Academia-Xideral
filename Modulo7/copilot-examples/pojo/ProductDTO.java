package com.example.copilot.pojo;

/**
 * Data Transfer Object (DTO) para la entidad Product.
 *
 * <p>Esta clase fue generada con asistencia de GitHub Copilot.
 * Se utiliza para transferir datos de productos entre capas de la aplicación
 * sin exponer directamente la entidad JPA.</p>
 *
 * <p><b>Caso de uso Copilot:</b> Al escribir el comentario de clase y el primer campo,
 * Copilot sugirió automáticamente los campos restantes, constructores,
 * getters y setters.</p>
 */
public class ProductDTO {

    /** Identificador único del producto. */
    private Long id;

    /** Nombre descriptivo del producto. */
    private String name;

    /** Descripción detallada del producto. */
    private String description;

    /** Precio unitario del producto. */
    private Double price;

    /** Cantidad disponible en inventario. */
    private Integer stock;

    /** Categoría a la que pertenece el producto. */
    private String category;

    // -----------------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------------

    /** Constructor vacío requerido por frameworks de serialización. */
    public ProductDTO() {}

    /**
     * Constructor con todos los campos.
     *
     * @param id          identificador del producto
     * @param name        nombre del producto
     * @param description descripción del producto
     * @param price       precio unitario
     * @param stock       cantidad en inventario
     * @param category    categoría del producto
     */
    public ProductDTO(Long id, String name, String description,
                      Double price, Integer stock, String category) {
        this.id = id;
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

    // -----------------------------------------------------------------------
    // toString
    // -----------------------------------------------------------------------

    /**
     * Representación en cadena del DTO para facilitar el debug.
     *
     * @return cadena con todos los campos del DTO
     */
    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }
}
