package th.co.appman.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Basic
    @Column(nullable = false, length = 120)
    private String productName;

    @Basic
    @Column(nullable = false)
    private String productDesc;
}
