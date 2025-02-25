package ecommerce_project.repository;

import ecommerce_project.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    /* find product name */
    @Test
    void findByName(){
        Product product = productRepository.findByName("Test");

        System.out.println("Product Info");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    /* find product by ID */

    @Test
    void findById(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        System.out.println("product info...");
        System.out.println(product.getId());
        System.out.println(product.toString());
    }
}
