package ecommerce_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
 @Table(name = "products",
        schema = "jpa_ecommerce",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "stock_keeping_unique",
                    columnNames = "sku"
            )
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_keeping_unique", nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @CreationTimestamp
    private LocalDateTime lastUpdated;
}
