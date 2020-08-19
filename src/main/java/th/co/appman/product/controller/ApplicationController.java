package th.co.appman.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping
    public ObjectNode status() {
        return new ObjectMapper()
                .createObjectNode()
                .put("status","UP");
    }

}
