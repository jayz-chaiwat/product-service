package th.co.appman.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.co.appman.product.dto.Detail;
import th.co.appman.product.dto.DetailResponse;
import th.co.appman.product.dto.ProductDetail;
import th.co.appman.product.entity.Product;
import th.co.appman.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    @Value("${detail.service.url}")
    private String detailUrl;

    private final ProductRepository productRepository;

    private final RestTemplate restTemplate;

    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public Product getProduct(long id) {
         Optional<Product> product = productRepository.findById(id);
         return product.isPresent() ? product.get():new Product();
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public ProductDetail getProductDetail(long id) {

        ProductDetail productDet = new ProductDetail();

        Optional<Product> productOpt = productRepository.findById(id);
        Product product = null;
        if(productOpt.isPresent()) {
            product = productOpt.get();
        }

        if(product == null) {
            return productDet;
        }

        ResponseEntity<Detail[]> response = restTemplate.getForEntity(detailUrl+id, Detail[].class);
        if(HttpStatus.OK.equals(response.getStatusCode())){
            BeanUtils.copyProperties(product,productDet);
            Detail[] details = response.getBody();
            List<DetailResponse> detailResponses = new ArrayList<>();
            if(details != null && details.length > 0) {
                for(Detail detail : details) {
                    DetailResponse detailResponse = new DetailResponse();
                    detailResponse.setName(detail.getDetName());
                    detailResponse.setValue(detail.getDetValue());
                    detailResponses.add(detailResponse);
                }
            }
            productDet.setDetails(detailResponses);
        }
        return productDet;
    }

}
