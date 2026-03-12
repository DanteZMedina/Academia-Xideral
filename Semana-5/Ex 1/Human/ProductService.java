package Ex 1.Human;

import Ex 1.Human.entity.Product;
import Ex 1.Human.repository.productRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) { 
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updatedProduct(Long id, Product updatedProduct) { 
        Product product = getProductById(id);

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setInStock(updatedProduct.isInStock());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) { 
        productRepository.deleteById(id);
    }
    public List<Product> findByCategory(String category) { 
        return productRepository.findByCategory(category);
    }
}
