package th.co.appman.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    private final Environment environment;

    public ApplicationController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public ObjectNode status() {
        String env = "default";
        if(environment.getActiveProfiles().length > 0){
            env = environment.getActiveProfiles()[0];
        }
        return new ObjectMapper()
                .createObjectNode()
                .put("status","UP").put("env",env);
    }

}
