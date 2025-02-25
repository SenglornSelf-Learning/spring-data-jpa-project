package ecommerce_project.repository;

import com.github.javafaker.Faker;
import ecommerce_project.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    private final Faker faker = new Faker();

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
        Optional<Product> existingProduct  = productRepository.findById(id);

        /* update product info */
        if(existingProduct.isPresent()){
            Product newProduct = existingProduct.get();                 // Get the existing product
            newProduct.setName("Test");
            newProduct.setDescription("new product");

            /* save update */
            Product productUpdate = productRepository.save(newProduct);
            System.out.println(productUpdate.getId());
            System.out.println(productUpdate.toString());
            System.out.println("Update new product successful!");
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    @Test
    void findById(){
        Long id = 1L;
        Product productId = productRepository.findById(id).get();
        System.out.println("Product with " + id + " is found!");
        System.out.println(productId.toString());
    }

    @Test
    void saveAllProduct(){
        /* create new product object */
        Product product1 = new Product();
        product1.setName("product 1");
        product1.setDescription("Angkor milk");
        product1.setSku("100");
        product1.setPrice(new BigDecimal(10));
        product1.setImageUrl("product1.png");
        product1.setActive(true);
        System.out.println("save product 1 successful!");

        /* product 2 */
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("Milk");
        product2.setSku("100");
        product2.setPrice(new BigDecimal(10));
        product2.setImageUrl("milk1.png");
        product2.setActive(true);
        System.out.println("save product 2 successful!");

        /* save product object */
        List<Product> saveAllProduct = productRepository.saveAll(List.of(product1, product2));

        /* display product info */
        System.out.println("product successful!");
        System.out.println(saveAllProduct.toString());
    }

    /* using java faker generate fake data */
    @Test
    void generateFakeProducts() {
        List<Product> products = new ArrayList<>();

        for (int i = 4; i < 24; i++) {
            Product product = new Product();
            product.setName(faker.name().name());
            product.setDescription(faker.lorem().sentence());
            product.setSku(faker.number().digits(10));
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(faker.commerce().price())));
            product.setActive(faker.bool().bool());
            product.setImageUrl(faker.internet().image());

            products.add(product);
        }

        productRepository.saveAll(products);
        System.out.println("product sava successful!");
    }

    @Test
    void findAllProductName(){
        List<Product> products = productRepository.findAll();
        System.out.println("Get All Product Name");
        products.forEach((product -> {
            System.out.println(product.getName());
        }));
    }

     @Test
    void deleteById(){
        Long id = 23L;

         if (productRepository.existsById(id)) {
             productRepository.deleteById(id);
             System.out.println("Product with ID " + id + " deleted successfully!");
         } else {
             System.out.println("Product with ID " + id + " not found!");
         }
    }

    @Test
    void countProduct(){
        long productCount = productRepository.count();
        System.out.println("Count Product : " + productCount);
    }
}