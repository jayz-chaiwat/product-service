package th.co.appman.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import th.co.appman.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
