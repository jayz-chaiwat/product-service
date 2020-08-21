package th.co.appman.product.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Detail implements Serializable {
    private long id;
    private long productId;
    private String detName;
    private String detValue;
}
