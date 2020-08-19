package th.co.appman.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import th.co.appman.product.dto.ProductDetail;
import th.co.appman.product.entity.Product;
import th.co.appman.product.service.ProductService;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> productAll() {
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/product-detail/{id}")
    public ProductDetail productDetail(@PathVariable("id") long id) {
        return productService.getProductDetail(id);
    }

}
