package ecommerce_project.repository;

import ecommerce_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    Optional<Product> findById(Long id);

    /* method is mapped to ?1, the second is mapped to ?2, */
    @Query(value = "SELECT p FROM Product p WHERE p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJPQLIndex(String name, String description);

    /* Named parameters */
    @Query(value = "SELECT p FROM Product p WHERE p.name =:name or p.description =:description")
    Product findByNameOrDescriptionJPQLIndexParam(@Param("name") String name, @Param("description") String description);



}
