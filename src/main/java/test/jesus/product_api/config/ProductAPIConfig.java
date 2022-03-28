package test.jesus.product_api.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("product-api")
public class ProductAPIConfig {
    @Setter @Getter private String url;
    @Setter @Getter private String endpoint_product;
    @Setter @Getter private String endpoint_productSimilarIds;

    @Setter @Getter private int request_timeout_in_seconds;

}

