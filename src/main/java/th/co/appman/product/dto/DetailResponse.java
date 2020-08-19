package th.co.appman.product.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DetailResponse implements Serializable {
    private String name;
    private String value;
}
