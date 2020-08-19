package th.co.appman.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private long id;

    @Basic
    @Column(nullable = false)
    private long productId;

    @Basic
    @Column(nullable = false, length = 120)
    private String detName;

    @Basic
    @Column(nullable = false)
    private String detValue;
}
