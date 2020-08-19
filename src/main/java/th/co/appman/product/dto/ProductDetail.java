package th.co.appman.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductDetail implements Serializable {
    private Long id;
    private String productName;
    private String productDesc;
    private List<DetailResponse> details;
}
