package ecommerce_project.repository;

import ecommerce_project.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPQLQueryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQL(){
        Product products = productRepository.findByNameOrDescriptionJPQLIndex("Test", "new product");
        System.out.println("Product found!");
        System.out.println(products.getId());
        System.out.println(products.getName());
        System.out.println(products.getDescription());
    }

    @Test
    void findNameOrDescriptionJPQLParam(){
        Product products = productRepository.findByNameOrDescriptionJPQLIndexParam("product2", "Milk");
        System.out.println("find Product with param is found!");
        System.out.println(products.getId());
        System.out.println(products.getName());
        System.out.println(products.getDescription());
    }
}
