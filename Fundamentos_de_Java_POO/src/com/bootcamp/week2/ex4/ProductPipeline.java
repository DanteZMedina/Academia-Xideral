package com.bootcamp.week2.ex4;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductPipeline {
	
	private Predicate <Product> filter = p -> true;
	private Function <Product, String> transform = Product::toDisplayString;
	
	public ProductPipeline where (Predicate<Product> predicate) {
		this.filter = filter.and(predicate);
		return this;
	}
	
    public ProductPipeline transform(Function<Product, String> fn) {
        this.transform = fn;
        return this;
    }
	
	public void forEach(List<Product>products, Consumer<String> action)  { 
		// Filtrar productos, aplicar transformacion y ejecutar accion
		for (Product p : products) { 
			if (filter.test(p)) {
				String result = transform.apply(p);
				action.accept(result);
			}
		}
	}
	
	public long count (List<Product> products) {
		long total = 0; 
		
		for (Product p : products) { 
			if (filter.test(p) ) { 
				total ++;
			}
		}
		return total;
	}

}
