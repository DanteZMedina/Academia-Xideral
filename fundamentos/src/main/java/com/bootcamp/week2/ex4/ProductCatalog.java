package com.bootcamp.week2.ex4;

import java.util.List;
import java.util.function.Supplier;

public class ProductCatalog {
    public static void main(String[] args) {
        Supplier<List<Product>> catalogSupplier = () -> List.of(
                new Product("Laptop", 999.99, "Electronica", true),
                new Product("Mouse", 29.99, "Electronica", true),
                new Product("Teclado", 79.99, "Electronica", false),
                new Product("Camisa", 39.99, "Ropa", true),
                new Product("Java Book", 49.99, "Libros", true),
                new Product("Monitor", 349.99, "Electronica", true));

        List<Product> catalogo = catalogSupplier.get();

        System.out.println("=== Catalogo Completo ===");
        catalogo.stream()
                .map(Product::toDisplayString)
                .forEach(System.out::println);

        System.out.println("\n=== Pipeline: Electronica en Stock, precio > $50 ===");
        new ProductPipeline()
                .where(Product::isAvailable)
                .where(p -> p.category().equals("Electronica"))
                .where(p -> p.price() > 50)
                .forEach(catalogo, System.out::println);

        System.out.println("\n=== Pipeline: Disponibles, precio < $100 ===");        
        ProductPipeline pipeline = new ProductPipeline()
            .where(Product::isAvailable)
            .where(p -> p.price() < 100)
            .transform(p -> "  * " + p.name().toUpperCase() + " - $" + p.price());
            pipeline.forEach(catalogo, System.out::println);

            System.out.println("\nTotal disponibles: "
                + new ProductPipeline()
                    .where(Product::isAvailable)
                    .count(catalogo)
                                    );
    }
}
