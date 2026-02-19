package com.bootcamp.week2.ex4;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//Qué es un pipeline ? 
// 1. Guarda un filtro acumulado (Predicate <Product>)
// 2. Guarda una transformación (Function <Product, String>)
// 3. Aplica eso a una lista
// 4. Eejcuta una accion final (Consumer <String>)
// es como un .stream() hecho a mano

public class ProductPipeline {
    private Predicate<Product> filter = p -> true;
    private Function <Product, String> transform = Product::toDisplayString;

    public ProductPipeline where (Predicate <Product> predicate ) {
        this.filter = filter.and(predicate);
        return this;
    }

    public ProductPipeline transform ( Function <Product, String> fn) {
        this.transform = fn;
        return this;
    }

    public void forEach(List<Product> products, Consumer <String> action) { 
        for (Product p : products) {
            // p pasa por el filtro ? 
            // si si --> Transformamos
            // Luego ejecutamos acción. 
            // Como se evalua un predicate ? 
            // con filter.test()
            if (filter.test(p)) {
                // Como se usa un function
                // con: transform.apply(p)
                action.accept(transform.apply(p));
            }
        }
    }

    public long count (List <Product> products) { 
        long total = 0;
        for (Product p : products) { 
            if (filter.test(p)) {
                total++;
            }
        }
        return total;
    }





}
