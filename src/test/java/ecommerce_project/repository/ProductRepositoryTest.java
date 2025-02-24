package ecommerce_project.repository;

import ecommerce_project.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createProduct(){

        /* create new product object */
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("Angkor milk");
        product.setSku("100");
        product.setPrice(new BigDecimal(10));
        product.setImageUrl("product1.png");
        product.setActive(true);

        /* save product object */
        Product saveProduct = productRepository.save(product);

        /* display product info */
        System.out.println("save new product successful!");
        System.out.println(saveProduct.getId());
        System.out.println(saveProduct.toString());
    }

    @Test
    void updateProduct(){
        /* find product by ID */
        Long id = 1L;
        Product newProduct = productRepository.findById(id).get();

        /* update product info */
        newProduct.setName("updated name product");
        newProduct.setDescription("product had been update...");

        Product productUpdate = productRepository.save(newProduct);

        /* save update */
        System.out.println("Update new product successful!");
        System.out.println(productUpdate.getId());
        System.out.println(productUpdate.toString());
    }
}